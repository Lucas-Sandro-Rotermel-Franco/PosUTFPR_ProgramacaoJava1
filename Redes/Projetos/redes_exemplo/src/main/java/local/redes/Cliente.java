package local.redes;

import java.io.*;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Cliente {
    private static Socket conexao;
    private static DataInputStream entrada;
    private static DataOutputStream saida;

    public static void main(String[] args) {
        try {
            //conectar ao servidor
            conexao = new Socket("127.0.0.1", 55000);

            //enviar um numero inteiro
            saida = new DataOutputStream(conexao.getOutputStream());
            BufferedReader br = new BufferedReader(new
                    InputStreamReader(System.in));
            String mensagem = br.readLine();

            int numero = 10;
            saida.writeInt(numero);

            //receber resposta do servidor
            entrada = new DataInputStream(conexao.getInputStream());
            String resposta = entrada.readUTF();
            System.out.println("Resposta do servidor: " + resposta);

            //fechar conexao
            saida.close();
            entrada.close();
            conexao.close();

        } catch (IOException e) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, e);
        }
    }
}
