package local.redes;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author lucassandro
 */
public class Cliente {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        try {
            Urna stub = (Urna) Naming.lookup("rmi://127.0.0.1/urnaRMI");
            
            System.out.println("Urna Java");
            System.out.println("---------");
            
            int opcao = 0;
            
            while (opcao != 3) {
                printOpcoes();
                
                opcao = lerInt(scanner);
                
                switch (opcao) {
                    case 1:
                        cadastrarCandidato(scanner, stub);
                        break;
                    case 2:
                        computarVotos(scanner, stub);
                        break;
                    case 3:
                        break;
                    default:
                        System.out.println("Opção não existente!");
                }
            }
        } catch (NotBoundException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MalformedURLException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        } catch (RemoteException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private static void printOpcoes() {
        System.out.println("1 - Cadastrar.");
        System.out.println("2 - Realizar cômputo de votos.");
        System.out.println("3 - Sair da aplicação.");
    }

    private static void cadastrarCandidato(Scanner scanner, Urna stub) throws RemoteException {
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        
        System.out.print("Número: ");
        int numero = lerInt(scanner);
        
        System.out.println(stub.cadastraCandidato(new Candidato(nome, numero)) + "\n\n");
    }

    private static void computarVotos(Scanner scanner, Urna stub) throws RemoteException {
        System.out.print("Informe o número do candidato a ter votos computados: ");
        int numeroCandidato = lerInt(scanner);
        
        System.out.println("Informe a quantidade de votos a serem enviadas para o candidato: ");
        int qtdVotos = lerInt(scanner);
        
        System.out.println(stub.adicionaVotos(numeroCandidato, qtdVotos) + "\n\n");
    }

    private static int lerInt(Scanner scanner) {
        while (true) {
            try {
                int valor = scanner.nextInt();
                scanner.nextLine();
                
                return valor;
            } catch (InputMismatchException ex) {
                System.out.println("Entrada inválida! Digite um número inteiro!");
                scanner.nextLine();
            }
        }
    }
}
