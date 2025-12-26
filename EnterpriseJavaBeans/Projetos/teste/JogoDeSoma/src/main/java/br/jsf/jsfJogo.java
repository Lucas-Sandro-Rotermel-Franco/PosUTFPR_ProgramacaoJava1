package br.jsf;

import br.data.model.Jogador;
import br.ejb.EjbJogo;
import br.ejb.EjbJogadores;
import jakarta.ejb.EJB;
import jakarta.inject.Named;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Inject;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import jakarta.jms.JMSContext;
import jakarta.annotation.Resource;
import jakarta.jms.Queue;

/**
 *
 * @author lucassandro
 */
@Named(value = "jsfJogo")
@SessionScoped
public class jsfJogo implements Serializable {

    @Inject
    private jsfJogador jsfJogador;

    @EJB
    private EjbJogo ejbJogo;

    @EJB
    private EjbJogadores ejbJogadores;

    @Inject
    private JMSContext jmsContext;

    @Resource(lookup = "java/Fila")
    private Queue fila;

    @Getter
    @Setter
    private int valor1;

    @Getter
    @Setter
    private int valor2;

    @Getter
    @Setter
    private int resposta;

    @Getter
    @Setter
    private int gabarito;

    @Getter
    @Setter
    private String resultado;

    public jsfJogo() {
        geraValoresEGabarito();
    }

    private void geraValoresEGabarito() {
        valor1 = (int) (Math.random() * 100);
        valor2 = (int) (Math.random() * 100);
        gabarito = valor1 + valor2;
        resposta = 0;
    }

    public void validaResultado() {
        if (jsfJogador.getNome() == null || jsfJogador.getNome().isEmpty()) {
            resultado = "Informe seu nome primeiro!";
            return;
        }

        EjbJogadores ejbJogadores = jsfJogador.getEjbJogadores();

        Jogador jogadorAtual = null;
        for (Jogador jogador : ejbJogadores.getAll()) {
            if (jogador.getNome().equals(jsfJogador.getNome())) {
                jogadorAtual = jogador;
                break;
            }
        }

        if (jogadorAtual == null) {
            resultado = "Jogador não encontrado!";
            return;
        }

        if (ejbJogo.validaResposta(resposta, gabarito)) {
            jogadorAtual.setPontos(jogadorAtual.getPontos() + 1);
            resultado = "✅ Acertou!";

            try {
                String json = String.format("{\"nome\":\"%s\",\"pontos\":%d}", jogadorAtual.getNome(), jogadorAtual.getPontos());
                jmsContext.createProducer().send(fila, json);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } else {
            resultado = "❌ Errou!";
        }

        geraValoresEGabarito();
    }

}
