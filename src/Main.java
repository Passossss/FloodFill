import java.awt.*;
import java.io.IOException;
//211, 230
public class Main {
    public static void main(String[] args) throws IOException {
        var path = "src/flood.png";

        var initialpixel = new Pixels(50, 50);
        var rgb = new Color(207, 79, 79);// testar alteracao no g, b

        var floodFill = new FloodFill(path);
        floodFill.applyFloodFill(initialpixel, rgb);
        floodFill.showResult();
    }
}