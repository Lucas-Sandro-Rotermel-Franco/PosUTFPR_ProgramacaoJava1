package local.redes;


import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Servidor extends Thread {
    private static ServerSocket servidor;
    private static Socket socket;
    private static DataInputStream entrada;
    private static DataOutputStream saida;

    public Servidor(Socket conexao) {
        this.socket = conexao;
    }

    @Override
    public void run() {
        //receber dados do cliente
        int valor;

        try {
            entrada = new DataInputStream(socket.getInputStream());

            valor = entrada.readInt();

            //realizar verificação do valor
            String resultado = "";
            if (valor > 0)
                resultado = "O valor é maior que zero";
            else
                resultado = "O valor é menor ou igual a zero";

            //retornar dados ao cliente
            saida = new DataOutputStream(socket.getOutputStream());
            saida.writeUTF(resultado);

            //fechar a conexão
            saida.close();
            entrada.close();
            socket.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) throws IOException{
        //especificar porta e aguardar conexão
        servidor = new ServerSocket(55000);

        while (true) {
            Socket conexao = servidor.accept();
            Servidor thread = new Servidor(conexao);
            thread.start();
        }
    }
}