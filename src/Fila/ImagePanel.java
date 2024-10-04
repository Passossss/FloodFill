package Fila;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class ImagePanel extends JPanel {
    private BufferedImage imagem;

    public ImagePanel(BufferedImage imagem) {
        this.imagem = imagem;
    }

    public void setImagem(BufferedImage imagem) {
        this.imagem = imagem;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (imagem != null) {
            g.drawImage(imagem, 0, 0, null);
        }
    }
}
