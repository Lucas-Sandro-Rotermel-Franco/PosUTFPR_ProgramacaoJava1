package utfpr.lucassandro.exemplo;


import utfpr.lucassandro.exemplo.Genitores;

public class Mae extends Genitores {
    private String corVestido;

    public Mae() {
        this.corVestido = "";
    }

    public String getCorVestido() {
        return corVestido;
    }

    public void setCorVestido(String corVestido) {
        this.corVestido = corVestido;
    }


    @Override
    public int calcRg() {
        return this.getRgGens() * 1000;
    }

}