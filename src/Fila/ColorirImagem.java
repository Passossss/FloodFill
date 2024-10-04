package Fila;

import Util.Pixels;
import javax.swing.*;
import java.awt.Color;
import java.awt.image.BufferedImage;


class ColorirImagem {
    private BufferedImage imagem;
    private Color novaCor;
    private Fila fila;
    private int delay = 100;

    public ColorirImagem(BufferedImage imagem, Color novaCor) {
        this.imagem = imagem;
        this.novaCor = novaCor;
        this.fila = new Fila(imagem.getWidth() * imagem.getHeight());
    }

    public void floodFillComFila(int x, int y, ImagePanel panel) {
        Color corOriginal = new Color(imagem.getRGB(x, y));
        if (corOriginal.equals(novaCor)) {
            return;
        }

        fila.enqueue(new Pixels(x, y));

        Timer timer = new Timer(10, e -> {
            int pixelsPerTick = 200;
            int processed = 0;

            while (!fila.isEmpty() && processed < pixelsPerTick) {
                Pixels p = fila.dequeue();
                int px = p.x;
                int py = p.y;

                if (px >= 0 && px < imagem.getWidth() && py >= 0 && py < imagem.getHeight() && imagem.getRGB(px, py) == corOriginal.getRGB()) {
                    imagem.setRGB(px, py, novaCor.getRGB());

                    fila.enqueue(new Pixels(px + 1, py));
                    fila.enqueue(new Pixels(px - 1, py));
                    fila.enqueue(new Pixels(px, py + 1));
                    fila.enqueue(new Pixels(px, py - 1));

                    panel.setImagem(imagem);
                }
                processed++;
            }

            if (fila.isEmpty()) {
                ((Timer) e.getSource()).stop();
            }
        });
        timer.start();
    }

    public BufferedImage getImagem() {
        return imagem;
    }
}