import Util.Pixels;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        String imagePath = "C:/Users/gusap/IdeaProjects/FloodFill/flood.png"; // Caminho da imagem
        JFrame frame = new JFrame("Flood Fill Animation");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ImageSlideshow slideshow = new ImageSlideshow(null); // Inicializa a janela do slideshow
        frame.add(slideshow);
        frame.pack();
        frame.setVisible(true);

        try {
            FloodFill floodFill = new FloodFill(imagePath, slideshow); // Passa a instância de ImageSlideshow
            floodFill.applyFloodFill(new Pixels(0, 0), Color.RED); // Substitua (0, 0) pelo pixel inicial desejado
            floodFill.showResult(); // Salva a imagem final
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(frame, "Erro ao carregar a imagem: " + e.getMessage());
        }
    }
}
