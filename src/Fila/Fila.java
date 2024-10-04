package Fila;

import Util.Pixels;

class Fila {
    private Pixels[] elementos;
    private int capacidade;
    private int frente;
    private int tras;
    private int tamanho;

    public Fila(int capacidade) {
        this.capacidade = capacidade;
        this.elementos = new Pixels[capacidade];
        this.frente = 0;
        this.tras = -1;
        this.tamanho = 0;
    }

    public boolean isEmpty() {
        return tamanho == 0;
    }

    public void enqueue(Pixels pixel) {
        if (tamanho == capacidade) {
            throw new RuntimeException("Fila cheia");
        }
        tras = (tras + 1) % capacidade;
        elementos[tras] = pixel;
        tamanho++;
    }

    public Pixels dequeue() {
        if (isEmpty()) {
            throw new RuntimeException("Fila vazia");
        }
        Pixels pixel = elementos[frente];
        frente = (frente + 1) % capacidade;
        tamanho--;
        return pixel;
    }
}
