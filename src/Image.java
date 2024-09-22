import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import java.util.Arrays;
import java.util.Comparator;

public class Image extends JFrame {
    private JLabel label;
    private File[] images;
    private int currentImage = 0;
    private Timer timer;

    public Image(String folderPath, int width, int height) {
        label = new JLabel();
        label.setHorizontalAlignment(JLabel.CENTER);
        add(label);
        setSize(width, height);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        images = new File(folderPath).listFiles((dir, name) -> name.endsWith(".png") || name.endsWith(".jpg"));
        if (images != null && images.length > 0) {
            Arrays.sort(images, Comparator.comparing(File::getName));
            timer = new Timer(100, e -> showNextImage());
            timer.start();
            showNextImage();
        }
    }

    private void showNextImage() {
        try {
            BufferedImage img = ImageIO.read(images[currentImage]);
            ImageIcon icon = new ImageIcon(img.getScaledInstance(label.getWidth(), label.getHeight(), java.awt.Image.SCALE_SMOOTH));
            label.setIcon(icon);
            currentImage = (currentImage + 1) % images.length;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
