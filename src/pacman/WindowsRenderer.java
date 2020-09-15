package pacman;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.imageio.ImageIO;

public class WindowsRenderer implements Renderer {

	private BufferedImage ghostImage;
	private BufferedImage wallImage;
	private BufferedImage pacmanImage;

	public WindowsRenderer() throws IOException {
		pacmanImage = ImageIO.read(new FileInputStream("img/pacman-open.png"));
		ghostImage = ImageIO.read(new FileInputStream("img/ghost.png"));
		wallImage = ImageIO.read(new FileInputStream("img/wall.png"));
	}

	@Override
	public void render(Graphics g, GameLevel level) {
		g.drawImage(pacmanImage, 50 + level.getPacman().getPosition().getX() * 20,
				50 + level.getPacman().getPosition().getY() * 20, 20, 20, null);

		for (Ghost ghost : level.getGhosts())
			g.drawImage(ghostImage, 50 + ghost.getPosition().getX() * 20, 50 + ghost.getPosition().getY() * 20, 20, 20,
					null);

		for (int y = 0; y < level.getGameMap().width(); y++) {
			for (int x = 0; x < level.getGameMap().height(); x++)
				if (level.getGameMap().isWall(y, x))
					g.drawImage(wallImage, 50 + x * 20, 50 + y * 20, 20, 20, null);
		}
	}

}
