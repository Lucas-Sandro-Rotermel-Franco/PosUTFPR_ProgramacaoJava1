package utfpr.lucassandro.exemplo;

public class TesteFam {
    public static void main(String arg[]) {

//N�o se pode instanciar objetos de uma classe abstrata.
//Descomente a linha abaixo, que faz a declara��o/intancia��o de Genitores,
//e tente compilar o c�digo.
//Genitores gen = new Genitores(); //descomente esta linha para testar

        Pai p = new Pai();
        Mae m = new Mae();
        p.setRgGens(1);
        p.setNomeGens("Papai");
        p.setCorCalca("Azul");
        p.getFilhoGens().setRgFilho(11);
        p.getFilhoGens().setNomeFilho("Filho do Pai");

        m.setRgGens(2);
        m.setNomeGens("Mam�e");
        m.setCorVestido("Rosa");
        m.getFilhoGens().setRgFilho(22);
        m.getFilhoGens().setNomeFilho("Filho da M�e");

        System.out.println("***********************************");
        System.out.println("\t\t\t Dados do Pai");
        System.out.println("***********************************");
        System.out.println("rg do Pai............: " + p.getRgGens());
        System.out.println("rg Calculado do Pai..: " + p.calcRg());
        System.out.println("nome do Pai..........: " + p.getNomeGens());
        System.out.println("cor da Cal�a do Pai..: " + p.getCorCalca());
        System.out.println("rg do Filho do Pai...: " + p.getFilhoGens().getRgFilho());
        System.out.println("nome do Filho do Pai.: " + p.getFilhoGens().getNomeFilho());

        System.out.println("\n\n***********************************");
        System.out.println("\t\t\t Dados da M�e");
        System.out.println("***********************************");
        System.out.println("rg da M�e............: " + m.getRgGens());
        System.out.println("rg Calculado da M�e..: " + m.calcRg());
        System.out.println("nome da M�e..........: " + m.getNomeGens());
        System.out.println("cor do Vestido da M�e: " + m.getCorVestido());
        System.out.println("rg do Filho da M�e...: " + m.getFilhoGens().getRgFilho());
        System.out.println("nome Filho do Pai....: " + m.getFilhoGens().getNomeFilho());
    }
}