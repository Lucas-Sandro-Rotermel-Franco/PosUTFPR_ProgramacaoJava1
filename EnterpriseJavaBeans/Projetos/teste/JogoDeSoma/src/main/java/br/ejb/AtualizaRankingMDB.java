package br.ejb;

import br.data.model.Jogador;
import jakarta.ejb.ActivationConfigProperty;
import jakarta.ejb.MessageDriven;
import jakarta.ejb.EJB;
import jakarta.inject.Inject;
import jakarta.jms.JMSException;
import jakarta.jms.Message;
import jakarta.jms.MessageListener;
import jakarta.jms.TextMessage;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 *
 * @author lucassandro
 */
@MessageDriven(activationConfig = {
    @ActivationConfigProperty(propertyName = "destinationLookup", propertyValue = "java/Fila"),
    @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "jakarta.jms.Queue")
})
public class AtualizaRankingMDB implements MessageListener {

    private static final Logger LOGGER = Logger.getLogger(AtualizaRankingMDB.class.getName());

    @EJB
    private EjbJogadores ejbJogadores;

    @Inject
    private RastreadorMelhorJogador melhorJogador;

    private final ObjectMapper mapper = new ObjectMapper();

    @Override
    public void onMessage(Message message) {
        if (message instanceof TextMessage) {
            try {
                String texto = ((TextMessage) message).getText();
                JsonNode node = mapper.readTree(texto);
                String nome = node.has("nome") ? node.get("nome").asText(null) : null;
                int pontos = node.has("pontos") ? node.get("pontos").asInt(0) : 0;

                if (nome == null || nome.isEmpty()) {
                    LOGGER.log(Level.WARNING, "Nome não se encontra presente", texto);
                    return;
                }

                Jogador jogador = null;
                for (Jogador j : ejbJogadores.getAll()) {
                    if (j.getNome().equals(nome)) {
                        jogador = j;
                        break;
                    }
                }

                if (jogador == null) {
                    ejbJogadores.add(nome);
                    for (Jogador j : ejbJogadores.getAll()) {
                        if (j.getNome().equals(nome)) {
                            jogador = j;
                            break;
                        }
                    }
                }

                if (jogador != null) {
                    jogador.setPontos(pontos);
                }

                Jogador top = ejbJogadores.obtemMelhorJogador();
                String topNome = top != null ? top.getNome() : null;

                boolean changed = melhorJogador.atualizaMelhorJogador(topNome);
                if (changed) {
                    List<Jogador> ranking = ejbJogadores.getAll();
                    StringBuilder sb = new StringBuilder();
                    sb.append("Novo melhor jogador: ").append(topNome).append("\nRanking:\n");
                    for (int i = 0; i < ranking.size(); i++) {
                        Jogador j = ranking.get(i);
                        sb.append(String.format("%d. %s - %d\n", i + 1, j.getNome(), j.getPontos()));
                    }
                    LOGGER.info(sb.toString());
                }

            } catch (JMSException ex) {
                LOGGER.log(Level.SEVERE, "AtualizaRankingMDB JMSException reading message", ex);
            } catch (Exception ex) {
                LOGGER.log(Level.SEVERE, "AtualizaRankingMDB error processing message", ex);
            }
        } else {
            LOGGER.log(Level.WARNING, "AtualizaRankingMDB received unsupported message type: {0}", message.getClass().getName());
        }
    }
}

