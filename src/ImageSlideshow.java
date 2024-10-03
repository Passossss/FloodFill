import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class ImageSlideshow extends JPanel {
    private BufferedImage currentImage;

    public ImageSlideshow(BufferedImage initialImage) {
        this.currentImage = initialImage;
    }

    public void updateImage(BufferedImage newImage) {
        this.currentImage = newImage;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (currentImage != null) {
            g.drawImage(currentImage, 0, 0, getWidth(), getHeight(), null);
        }
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(800, 600);
    }
}
