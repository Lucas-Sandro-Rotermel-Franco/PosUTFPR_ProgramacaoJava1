package local.redes;

import java.io.Serializable;

/**
 *
 * @author lucassandro
 */
class Candidato implements Serializable {
    private String nome;
    private int numeroCandidato;
    private int qtdVotos;

    public Candidato(String nome, int numeroCandidato) {
        this.nome = nome;
        this.numeroCandidato = numeroCandidato;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getNumeroCandidato() {
        return numeroCandidato;
    }

    public void setNumeroCandidato(int numeroCandidato) {
        this.numeroCandidato = numeroCandidato;
    }

    public int getQtdVotos() {
        return qtdVotos;
    }

    public void setQtdVotos(int qtdVotos) {
        this.qtdVotos = qtdVotos;
    }
    
    public void somaQtdVotos(int qtdVotos) {
        this.qtdVotos += qtdVotos;
    }
    
    public int obtemTamanhoNome() {
        return String.valueOf(numeroCandidato).length() + nome.length();
    }
    
}
