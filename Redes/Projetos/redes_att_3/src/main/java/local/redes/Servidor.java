package local.redes;

import java.io.DataOutputStream;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

// @author Lucas Sandro Rotermel Franco
public class Servidor {

    private static Socket socket;
    private static ServerSocket server;

    private static ObjectInputStream entrada;
    private static DataOutputStream saida;

    public static void main(String[] args) {
        try {
            server = new ServerSocket(50000);
            socket = server.accept();
            entrada = new ObjectInputStream(socket.getInputStream());

            Pessoa pessoa = (Pessoa) entrada.readObject();

            System.out.println(pessoa.toString());

            saida = new DataOutputStream(socket.getOutputStream());
            saida.writeUTF("Dados recebidos corretamente!");

            saida.close();
            entrada.close();
            socket.close();
            server.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}