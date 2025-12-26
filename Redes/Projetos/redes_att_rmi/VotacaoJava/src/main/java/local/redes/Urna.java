package local.redes;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author lucassandro
 */
public interface Urna extends Remote {
    String cadastraCandidato(Candidato candidato) throws RemoteException;
    String adicionaVotos(int numeroCandidato, int qtdVotos) throws RemoteException;
}
