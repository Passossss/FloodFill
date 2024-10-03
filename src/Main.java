import Util.Pixels;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        String imagePath = "C:/Users/gusap/IdeaProjects/FloodFill/flood.png";
        JFrame frame = new JFrame("Flood Fill Animation");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ImageSlideshow slideshow = new ImageSlideshow(null);
        frame.add(slideshow);
        frame.pack();
        frame.setVisible(true);

        try {
            FloodFill floodFill = new FloodFill(imagePath, slideshow);
            floodFill.applyFloodFill(new Pixels(0, 0), Color.RED);
            floodFill.showResult();
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(frame, "Erro ao carregar a imagem: " + e.getMessage());
        }
    }
}
