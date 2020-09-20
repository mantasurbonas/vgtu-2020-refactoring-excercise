package pacman;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;

import javax.imageio.ImageIO;

public class WindowsRenderer {

    private final BufferedImage ghostImage;
    private final BufferedImage wallImage;
    private final BufferedImage pacmanImage;

    public WindowsRenderer() throws IOException {
        pacmanImage = ImageIO.read(new FileInputStream("img/pacman-open.png"));
        ghostImage = ImageIO.read(new FileInputStream("img/ghost.png"));
        wallImage = ImageIO.read(new FileInputStream("img/wall.png"));
    }

    public void render(Graphics g, GameLevel level) {
        g.drawImage(pacmanImage, 30 + level.getPacman().getPosition().getX() * 17,
                30 + level.getPacman().getPosition().getY() * 17, 17, 17, null);

        for (Ghost ghost : level.getGhosts())
            g.drawImage(ghostImage, 30 + ghost.getPosition().getX() * 17, 30 + ghost.getPosition().getY() * 17, 17, 17,
                    null);

        for (int y = 0; y < level.getGameMap().width(); y++) {
            for (int x = 0; x < level.getGameMap().height(); x++)
                if (level.getGameMap().isWall(y, x))
                    g.drawImage(wallImage, 30 + x * 17, 30 + y * 17, 17, 17, null);
        }
    }
}
