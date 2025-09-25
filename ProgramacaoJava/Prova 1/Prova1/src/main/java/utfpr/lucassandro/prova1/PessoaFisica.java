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
public final class PessoaFisica extends ClienteBanco {
    private int cpf = 0;

    public int getCpf() {
        return cpf;
    }

    public void setCpf(int cpf) {
        this.cpf = cpf;
    }
    
    @Override
    public void verifDoc() {
        if (cpf >= 10 && cpf <= 20) {
            System.out.println("CPF válido");
            return;
        }
        
        System.out.println("CPF inválido");
    }
}
