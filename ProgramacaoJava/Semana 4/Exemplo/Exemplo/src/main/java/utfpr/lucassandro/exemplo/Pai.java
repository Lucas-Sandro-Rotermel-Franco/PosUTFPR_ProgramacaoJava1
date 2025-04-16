package utfpr.lucassandro.exemplo;


import utfpr.lucassandro.exemplo.Genitores;

public class Pai extends Genitores {
    private String corCalca;

    public Pai() {
        this.corCalca = "";
    }

    public String getCorCalca() {
        return corCalca;
    }

    public void setCorCalca(String corCalca) {
        this.corCalca = corCalca;
    }

    @Override
    public int calcRg() {
        return this.getRgGens() * 100;
    }

}