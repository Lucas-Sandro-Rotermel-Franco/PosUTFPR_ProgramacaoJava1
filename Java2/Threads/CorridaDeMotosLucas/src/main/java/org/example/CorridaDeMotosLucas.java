package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CountDownLatch;

public class CorridaDeMotosLucas {

    private static final int TOTAL_COMPETIDORES = 10;
    private static final int TOTAL_CORRIDAS = 30;

    public static void main(String[] args) throws InterruptedException {
        new CorridaDeMotosLucas().iniciarCorridas();
    }

    void iniciarCorridas() throws InterruptedException {
        final var podio = new Podio();

        for (int idx = 0; idx < TOTAL_CORRIDAS; idx++) {
            CountDownLatch inicioCorrida = new CountDownLatch(1);
            CountDownLatch finalCorrida = new CountDownLatch(TOTAL_COMPETIDORES);
            podio.prepararNovaCorrida();

            for (int j = 0; j < TOTAL_COMPETIDORES; j++) {
                final int id = j + 1;
                Thread t = new Thread(new Competidor(id, podio, inicioCorrida, finalCorrida));
                t.start();
            }

            inicioCorrida.countDown();
            finalCorrida.await();
        }

        podio.informarPodio();
    }

    private static class Competidor implements Runnable {
        private final int id;
        private final Podio podio;
        private final CountDownLatch inicioCorrida;
        private final CountDownLatch finalCorrida;

        public Competidor(int id, Podio podio, CountDownLatch inicioCorrida, CountDownLatch finalCorrida) {
            this.id = id;
            this.podio = podio;
            this.inicioCorrida = inicioCorrida;
            this.finalCorrida = finalCorrida;
        }

        @Override
        public void run() {
            try {
                inicioCorrida.await();
                podio.linhaDeChegada(id - 1);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            } finally {
                finalCorrida.countDown();
            }
        }
    }

    private static class Podio {
        final List<Integer> pontuacoes = new ArrayList<>(Collections.nCopies(TOTAL_COMPETIDORES, 0));
        private int pontuacaoAtual;

        public synchronized void prepararNovaCorrida() {
            pontuacaoAtual = TOTAL_COMPETIDORES;
        }

        public void linhaDeChegada(int idx) {
            synchronized (this) {
                pontuacoes.set(idx, pontuacoes.get(idx) + pontuacaoAtual);
                pontuacaoAtual--;
            }
        }

        public void informarPodio() {
            List<Posicao> resultados = new ArrayList<>();
            for (int i = 0; i < TOTAL_COMPETIDORES; i++) {
                resultados.add(new Posicao(i + 1, pontuacoes.get(i)));
            }

            resultados.sort((a, b) -> Integer.compare(b.pontos, a.pontos));

            System.out.println("==== Podio ====");
            for (int idx = 0; idx < 3; idx++) {
                var r = resultados.get(idx);
                System.out.printf("Competidor #%d com %d pontos%n", r.id, r.pontos);
            }

            System.out.println("\n==== Tabela de pontos ====");
            for (int idx = 0; idx < resultados.size(); idx++) {
                var r = resultados.get(idx);
                System.out.printf("Competidor #%d com %d pontos%n", r.id, r.pontos);
            }
        }

        private static class Posicao {
            final int id;
            final int pontos;

            Posicao(int id, int pontos) {
                this.id = id;
                this.pontos = pontos;
            }
        }
    }
}
