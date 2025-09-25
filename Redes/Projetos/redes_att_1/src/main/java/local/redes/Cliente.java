package local.redes;

import java.io.*;
import java.net.Socket;

// @author Lucas Sandro Rotermel Franco
public class Cliente {
    private static Socket conexao;
    private static DataInputStream entrada;
    private static DataOutputStream saida;

    public static void main(String[] args) {
        try {
            conexao = new Socket("127.0.0.1", 50000);

            saida = new DataOutputStream(conexao.getOutputStream());
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            System.out.println("Digite um CPF para verificação:");
            String cpf = br.readLine();

            saida.writeUTF(cpf);

            entrada = new DataInputStream(conexao.getInputStream());
            String resposta = entrada.readUTF();
            System.out.println(resposta);

            saida.close();
            entrada.close();
            conexao.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
