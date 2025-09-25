//Nome: Lucas Sandro Rotermel Franco
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package utfpr.lucassandro.prova1;

/**
 *
 * @author lucassandro
 */
public class TstConta {

    public static void main(String[] args) {
        PessoaJuridica pj = new PessoaJuridica();
        
        try {
            pj.setNumeroConta(1);
        } catch (NumException ex) {
            ex.impMsg();
            return;
        }
        
        pj.setCnpj(35);
        pj.getEnder().setRua("Rua do Limoeiro");
        pj.getResponsavel().setCpf(19);
        pj.getResponsavel().setNome("Cebolinha");
        
        System.out.println("Número da conta: " + pj.getNumeroConta());
        System.out.print("O número da conta ");
        pj.validar();
        System.out.println("CNPJ da conta: " + pj.getCnpj());
        System.out.println("Rua da conta: " + pj.getEnder().getRua());
        System.out.println("CPF do Responsável pela Conta: " + pj.getResponsavel().getCpf());
        System.out.print("A conta possui ");
        pj.getResponsavel().verifDoc();
        System.out.println("Nome do Responsável pela Conta: " + pj.getResponsavel().getNome());
        System.out.print("Conta possui ");
        pj.verifDoc();
    }
}
