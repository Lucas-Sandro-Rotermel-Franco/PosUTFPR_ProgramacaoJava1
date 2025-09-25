//Nome:Lucas Sandro Rotermel Franco
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utfpr.lucassandro.prova1;

/**
 *
 * @author lucassandro
 */
public final class PessoaJuridica extends ClienteBanco {
    private int cnpj = 0;
    private PessoaFisica responsavel = new PessoaFisica();

    public int getCnpj() {
        return cnpj;
    }

    public void setCnpj(int cnpj) {
        this.cnpj = cnpj;
    }

    public PessoaFisica getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(PessoaFisica responsavel) {
        this.responsavel = responsavel;
    }

    @Override
    public void verifDoc() {
        if (responsavel.getNome().length() < 30) {
            System.out.println("Nome válido para Responsável");
            return;
        }
        
        System.out.println("Nome inválido para Responsável");
    }
}
