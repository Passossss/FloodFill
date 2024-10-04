package Fila;

import Util.Pixels;
import javax.swing.*;
import java.awt.Color;
import java.awt.image.BufferedImage;


class ColorirImagem {
    private BufferedImage imagem;
    private Color novaCor;
    private Fila fila;
    private int delay = 100; // Delay para a animação

    public ColorirImagem(BufferedImage imagem, Color novaCor) {
        this.imagem = imagem;
        this.novaCor = novaCor;
        this.fila = new Fila(imagem.getWidth() * imagem.getHeight());
    }

    public void floodFillComFila(int x, int y, ImagePanel panel) {
        Color corOriginal = new Color(imagem.getRGB(x, y));
        if (corOriginal.equals(novaCor)) {
            return; // Se a cor original é a mesma que a nova cor, não faz nada
        }

        fila.enqueue(new Pixels(x, y));

        // Criar um Timer para controlar a animação
        Timer timer = new Timer(10, e -> {  // Reduzir o delay para 10ms
            int pixelsPerTick = 200; // Número de pixels a serem processados por tick
            int processed = 0; // Contador de pixels processados

            while (!fila.isEmpty() && processed < pixelsPerTick) {
                Pixels p = fila.dequeue();
                int px = p.x;
                int py = p.y;

                // Colorir o pixel
                if (px >= 0 && px < imagem.getWidth() && py >= 0 && py < imagem.getHeight() && imagem.getRGB(px, py) == corOriginal.getRGB()) {
                    imagem.setRGB(px, py, novaCor.getRGB());

                    // Adicionar pixels adjacentes à fila
                    fila.enqueue(new Pixels(px + 1, py));
                    fila.enqueue(new Pixels(px - 1, py));
                    fila.enqueue(new Pixels(px, py + 1));
                    fila.enqueue(new Pixels(px, py - 1));

                    // Atualizar o painel
                    panel.setImagem(imagem);
                }
                processed++;
            }

            if (fila.isEmpty()) {
                ((Timer) e.getSource()).stop(); // Parar o timer quando a fila estiver vazia
            }
        });
        timer.start();
    }

    public BufferedImage getImagem() {
        return imagem;
    }
}