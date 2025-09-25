package local.redes;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

// @author Lucas Sandro Rotermel Franco
public class Servidor {
    private static ServerSocket servidor;
    private static Socket socket;
    private static DataInputStream entrada;
    private static DataOutputStream saida;

    private static boolean ehCPFvalido(String cpf) {
        if (cpf == null || cpf.length() != 11)
            return false;

        if (todosCaracteresIguais(cpf))
            return false;

        String cpfComp = cpf.substring(0, 9);

        cpfComp += obtemDigitoValidador(cpfComp);

        cpfComp += obtemDigitoValidador(cpfComp);

        if (cpfComp.equals(cpf))
            return true;

        return false;
    }

    private static boolean todosCaracteresIguais(String cpf) {
        for (int idx = 1; idx < 11; idx++) {
            if (cpf.charAt(0) != cpf.charAt(idx))
                return false;
        }

        return true;
    }

    private static char obtemDigitoValidador(String inicioCPF) {
        int soma = 0;
        int peso = inicioCPF.length() + 1;

        for (int idx = 0; idx < inicioCPF.length(); ++idx) {
            soma += obtemNumeroDeCaracter(inicioCPF.charAt(idx)) * peso;
            peso--;
        }

        int restoDiv = 11 - (soma % 11);
        char digitoValidador = '0';
        if (restoDiv != 10 && restoDiv != 11)
            digitoValidador = obtemCaracterDeNumero(restoDiv);

        return digitoValidador;
    }

    private static char obtemCaracterDeNumero(int restoDiv) {
        return (char) (restoDiv + 48);
    }

    private static int obtemNumeroDeCaracter(char num) {
        return (int) num - 48;
    }

    public static void main(String[] args){
        String cpf;

        try {
            servidor = new ServerSocket(50000);
            socket = servidor.accept();
            entrada = new DataInputStream(socket.getInputStream());

            cpf = entrada.readUTF();

            String resultado = "Este CPF é inválido.";

            if (ehCPFvalido(cpf))
                resultado = "Este CPF é válido.";

            saida = new DataOutputStream(socket.getOutputStream());
            saida.writeUTF(resultado);

            saida.close();
            entrada.close();
            socket.close();
            servidor.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}