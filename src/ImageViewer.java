import javax.swing.*;
import java.awt.image.BufferedImage;

public class ImageViewer extends JFrame {
    public ImageViewer(BufferedImage image) {
        setTitle("Resultado do Flood Fill");
        setSize(image.getWidth(), image.getHeight());
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JLabel label = new JLabel(new ImageIcon(image));
        add(label);

        setVisible(true);
    }
}
