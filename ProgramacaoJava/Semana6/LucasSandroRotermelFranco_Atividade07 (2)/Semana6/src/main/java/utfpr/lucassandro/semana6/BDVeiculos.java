/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utfpr.lucassandro.semana6;

/**
 *
 * @author lucassandro
 */
public class BDVeiculos {
    private static Passeio vetPasseio[] = new Passeio[5];
    private static Carga vetCarga[] = new Carga[5];

    public static Passeio[] getVetPasseio() {
        return vetPasseio;
    }

    public static void setVetPasseio(Passeio[] vetPasseio) {
        BDVeiculos.vetPasseio = vetPasseio;
    }

    public static Carga[] getVetCarga() {
        return vetCarga;
    }

    public static void setVetCarga(Carga[] vetCarga) {
        BDVeiculos.vetCarga = vetCarga;
    }
    
    private static void placaExistente(String placa) throws VeicExistException {
        for (int idx = 0; idx < vetPasseio.length; idx++) {
            if (vetPasseio[idx] == null)
                continue;
            
            if (vetPasseio[idx].getPlaca().equals(placa))
                throw new VeicExistException();
        }
        
        for (int idx = 0; idx < vetCarga.length; idx++) {
            if (vetCarga[idx] == null)
                continue;
            
            if (vetCarga[idx].getPlaca().equals(placa))
                throw new VeicExistException();
        }
        
        return;
    }
    
    public static void cadastraPasseio(Passeio passeio) throws VeicExistException {
        int idx;
        idx = validaEspacoVetor(vetPasseio);
        
        if (idx < 0) {
            System.out.println("Vetor de passeio está cheio!");
            return;
        }
        
        placaExistente(passeio.getPlaca());
        
        vetPasseio[idx] = passeio;
    }
    
    public static void cadastraCarga(Carga carga) throws VeicExistException {
        int idx;
        idx = validaEspacoVetor(vetCarga);
        
        if (idx < 0) {
            System.out.println("Vetor de carga está cheio!");
            return;
        }

        placaExistente(carga.getPlaca());
        
        vetCarga[idx] = carga;
    }
    
    private static int validaEspacoVetor(Object[] vetor) {
        for (int idx = 0; idx < vetor.length; idx++) {
            if (vetor[idx] == null) {
                return idx;
            }
        }
        
        return -1;
    }
    
}
