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
public abstract class ClienteBanco implements Verifica{
    private int numeroConta = 0;
    private String nome = " ";
    private Endereco ender = new Endereco();

    public int getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(int numeroConta) throws NumException {
        if (numeroConta > 0) {
            this.numeroConta = numeroConta;
            return;
        }
        
        throw new NumException();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Endereco getEnder() {
        return ender;
    }

    public void setEnder(Endereco ender) {
        this.ender = ender;
    }
    
    public abstract void verifDoc();

    @Override
    public void validar() {
        if (numeroConta % 2 == 0) {
            System.out.println("É par");
            return;
        }
        
        System.out.println("É ímpar");
    }
}
