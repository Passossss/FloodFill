import Util.Pixels;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import Aula.DynamicStack;

public class FloodFill {
    private BufferedImage image;
    private ImageSlideshow slideshow;

    public FloodFill(String imagePath, ImageSlideshow slideshow) throws IOException {
        File file = new File(imagePath);
        this.image = ImageIO.read(file);
        this.slideshow = slideshow;
    }

    public void applyFloodFill(Pixels initialPixel, Color newColor) throws IOException {
        int initialColorRGB = image.getRGB(initialPixel.x, initialPixel.y);
        Color initialColor = new Color(initialColorRGB);
        DynamicStack<Pixels> stack = new DynamicStack<>();
        stack.push(initialPixel);

        while (!stack.isEmpty()) {
            Pixels pixel = stack.pop();
            recolorizePixel(pixel, newColor);
            addAdjacentPixels(pixel, initialColor, stack);
            slideshow.updateImage(image);
        }
    }

    private void addAdjacentPixels(Pixels pixel, Color initialColor, DynamicStack<Pixels> stack) {
        Pixels left = new Pixels(pixel.x - 1, pixel.y);
        Pixels right = new Pixels(pixel.x + 1, pixel.y);
        Pixels above = new Pixels(pixel.x, pixel.y - 1);
        Pixels below = new Pixels(pixel.x, pixel.y + 1);

        tryAddPixel(left, initialColor, stack);
        tryAddPixel(right, initialColor, stack);
        tryAddPixel(above, initialColor, stack);
        tryAddPixel(below, initialColor, stack);
    }

    private void tryAddPixel(Pixels pixel, Color initialColor, DynamicStack<Pixels> stack) {
        try {
            Color pixelColor = new Color(image.getRGB(pixel.x, pixel.y));
            if (pixelColor.equals(initialColor)) {
                stack.push(pixel);
            }
        } catch (ArrayIndexOutOfBoundsException ignored) {
        }
    }

    private void recolorizePixel(Pixels pixel, Color color) {
        image.setRGB(pixel.x, pixel.y, color.getRGB());
    }

    public void showResult() throws IOException {
        File outputFile = new File("src/resultado/resultadoFlood.png");
        ImageIO.write(image, "png", outputFile);
    }

    public BufferedImage getImage() {
        return image;
    }
}
