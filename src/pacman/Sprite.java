package pacman;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;

public class Sprite {
    private BufferedImage image;

    public Sprite(String path) throws IOException {
        this.image = ImageIO.read(new FileInputStream(path));
    }

    public void draw(Graphics graphics, int x, int y, int size, int offset) {
        graphics.drawImage(image, offset + x * size, offset + y * size, size, size, null);
    }
}
