package br.ejb;

import jakarta.annotation.PostConstruct;
import jakarta.ejb.Singleton;
import jakarta.ejb.Startup;
import java.util.concurrent.atomic.AtomicReference;

/**
 *
 * @author lucassandro
 */
@Singleton
@Startup
public class RastreadorMelhorJogador {
    private final AtomicReference<String> melhorJogador = new AtomicReference<>();

    @PostConstruct
    private void init() {
        melhorJogador.set(null);
    }

    public String getMelhorJogador() {
        return melhorJogador.get();
    }

    public boolean atualizaMelhorJogador(String candidato) {
        String anterior;
        do {
            anterior = melhorJogador.get();
            if (candidato == null) {
                if (anterior == null) return false;
            } else {
                if (candidato.equals(anterior)) return false;
            }
        } while (!melhorJogador.compareAndSet(anterior, candidato));
        return true;
    }
}

