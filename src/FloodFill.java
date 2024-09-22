import java.awt.*;
import java.io.*;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import Aula.DynamicStack;

public class FloodFill  {
    BufferedImage image;

    public FloodFill(String imagePath) throws IOException {
        File file = new File(imagePath);
        image = ImageIO.read(file);
    }

    public void applyFloodFill(Pixels initialpixel, Color newColor) throws IOException {
        var colorInitial = image.getRGB(initialpixel.x, initialpixel.y);
        var rgbInitial = new Color(colorInitial);

        var pilha = new DynamicStack<Pixels>();
        recolorizeStack(initialpixel, pilha, newColor, rgbInitial);
    }

    public void showResult() {
        new Image("src/out", image.getWidth(), image.getHeight());
    }

    private void recolorizeStack(Pixels pixel, DynamicStack<Pixels> pilha, Color newColor, Color rgbInitial) throws IOException {
        saveImage(String.format("src/out/%s.png", 0));
        var saveCount = 1;

        var saveImageEach = 1750;
        var pixelCount = 0;

        while (pixel != null) {
            System.out.println("pixel " + pixel.x + ", " + pixel.y);

            recolorizepixel(pixel, newColor);
            addAdjactes(pixel, rgbInitial, pilha);
            pixelCount++;

            if (!pilha.isEmpty()) {
                pixel = pilha.pop();
            } else {
                pixel = null;
            }

            if (pixelCount % saveImageEach == 0) {
                saveImage(String.format("src/out/%s.png", saveCount));
                saveCount++;
            }
        }

    }

    private void addAdjactes(Pixels pixel, Color rgbInitial, DynamicStack<Pixels> pilha) {
        var left = new Pixels(pixel.x - 1, pixel.y);
        var right = new Pixels(pixel.x + 1, pixel.y);
        var top = new Pixels(pixel.x, pixel.y - 1);
        var button = new Pixels(pixel.x, pixel.y + 1);

        tryAddpixel(left, rgbInitial, pilha);
        tryAddpixel(right, rgbInitial, pilha);
        tryAddpixel(top, rgbInitial, pilha);
        tryAddpixel(button, rgbInitial, pilha);
    }

    private void tryAddpixel(Pixels pixel, Color rgbInitial, DynamicStack<Pixels> pilha) {
        try {
            var pixelRgb = new Color(image.getRGB(pixel.x, pixel.y));
            if (pixelRgb.equals(rgbInitial)) { pilha.push(pixel); }
        } catch (Exception _) {
        }
    }

    private void saveImage(String path) throws IOException {
        var fileOutput = new File(path);
        var pathSplit = path.split("\\.");
        var type = pathSplit[pathSplit.length - 1];
        ImageIO.write(image, type, fileOutput);
    }

    private void recolorizepixel(Pixels pixel, Color color) {
        image.setRGB(pixel.x, pixel.y, color.getRGB());
    }
}
