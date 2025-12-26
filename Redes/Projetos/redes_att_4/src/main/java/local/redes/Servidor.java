package local.redes;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

// @author Lucas Sandro Rotermel Franco
public class Servidor extends Thread {

    private static Socket socket;
    private static ServerSocket server;

    private static ObjectInputStream entrada;
    private static DataOutputStream saida;

    public Servidor(Socket conexao) {
        this.socket = conexao;
    }

    @Override
    public void run() {
        try {
            entrada = new ObjectInputStream(socket.getInputStream());

            Pessoa pessoa = (Pessoa) entrada.readObject();

            System.out.println(pessoa.toString());

            saida = new DataOutputStream(socket.getOutputStream());
            saida.writeUTF("Dados recebidos corretamente!");

            saida.close();
            entrada.close();
            socket.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) throws IOException {
        server = new ServerSocket(50000);

        while (true) {
            Socket conexao = server.accept();
            Servidor thread = new Servidor(conexao);
            thread.start();
        }
    }
}