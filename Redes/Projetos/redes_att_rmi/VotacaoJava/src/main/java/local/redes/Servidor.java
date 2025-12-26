package local.redes;

import java.net.MalformedURLException;
import java.rmi.AccessException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author lucassandro
 */
public class Servidor extends UnicastRemoteObject implements Urna {
    private List<Candidato> candidatos;
    private int tamanhoMaiorNomeCandidato;
    private int tamanhoMaiorQtdVotos;
    
    public Servidor() throws RemoteException {
        super();
        candidatos = new ArrayList<>();
        tamanhoMaiorNomeCandidato = 0;
        tamanhoMaiorQtdVotos = 0;
    }

    public List<Candidato> getCandidatos() {
        return candidatos;
    }

    public int getTamanhoMaiorNomeCandidato() {
        return tamanhoMaiorNomeCandidato;
    }

    public int getTamanhoMaiorQtdVotos() {
        return tamanhoMaiorQtdVotos;
    }

    @Override
    public String cadastraCandidato(Candidato candidato) throws RemoteException {
        if (candidatos.stream()
                      .filter(c -> candidato.getNumeroCandidato() == c.getNumeroCandidato())
                      .count() > 0)
            return "Candidato com número informado já existente!";
        
        candidatos.add(candidato);
        obtemMaiorNomeCandidato(candidato);
        obtemMaiorQtdVotos(candidato);
        return "Candidato cadastrado com sucesso!";
    }

    @Override
    public String adicionaVotos(int numeroCandidato, int qtdVotos) throws RemoteException {
        if (candidatos.stream()
                      .filter(c -> c.getNumeroCandidato() == numeroCandidato)
                      .count() == 0)
            return "Candidato não existente!";
        
        candidatos.stream()
                .filter(c -> c.getNumeroCandidato() == numeroCandidato)
                .findFirst()
                .ifPresent(c -> { c.somaQtdVotos(qtdVotos);
                                  obtemMaiorQtdVotos(c);});
        return "Candidato teve número de votos atualizado com sucesso!";
    }
    
    private void obtemMaiorNomeCandidato(Candidato candidato) {
        if (tamanhoMaiorNomeCandidato < candidato.obtemTamanhoNome())
            tamanhoMaiorNomeCandidato = candidato.obtemTamanhoNome();
    }
    
    private void obtemMaiorQtdVotos(Candidato candidato) {
        if (String.valueOf(candidato.getQtdVotos()).length() > tamanhoMaiorQtdVotos)
            tamanhoMaiorQtdVotos = String.valueOf(candidato.getQtdVotos()).length();
    }
    
    public static void main(String[] args) {
        System.out.println("Eleição");
        System.out.println("-------\n");
        try {
            Servidor servidor = new Servidor();
            Registry registro =
                    LocateRegistry.createRegistry(1099);
            Naming.rebind("urnaRMI", servidor);
            
            while (true) {
                System.out.println("Votos apurados:\n");
                servidor.getCandidatos().stream()
                        .sorted(Comparator.comparingInt(Candidato::getQtdVotos).reversed())
                        .forEach(c -> System.out.println(
                                c.getNumeroCandidato() +
                                        " " + c.getNome() +
                                        " " + "-".repeat(servidor.getTamanhoMaiorNomeCandidato() - c.obtemTamanhoNome() + 1) +
                                        " " + c.getQtdVotos() +
                                        " ".repeat(servidor.getTamanhoMaiorQtdVotos() - String.valueOf(c.getQtdVotos()).length() + 1) +
                                        "votos"));
                System.out.println("\n");
                Thread.sleep(5000);  
            }
        } catch (RemoteException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MalformedURLException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
