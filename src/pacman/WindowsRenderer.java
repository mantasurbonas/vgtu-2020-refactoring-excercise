package pacman;

import java.awt.*;
import java.io.IOException;

public class WindowsRenderer implements Renderer {

	private Sprite ghostSprite;
	private Sprite wallSprite;
	private Sprite pacmanSprite;

	private int spriteSize = 20;
	private int offset = 50;

	public WindowsRenderer() throws IOException {
		pacmanSprite = new Sprite("img/pacman-open.png");
		ghostSprite = new Sprite("img/ghost.png");
		wallSprite = new Sprite("img/wall.png");
	}

	@Override
	public void render(Graphics graphics, GameLevel level) {
		pacmanSprite.draw(graphics, level.getPacman().getPosition().getX(), level.getPacman().getPosition().getY(), spriteSize, offset);

		for (Ghost ghost : level.getGhosts())
			ghostSprite.draw(graphics, ghost.getPosition().getX(), ghost.getPosition().getY(), spriteSize, offset);

		for (int y = 0; y < level.getGameMap().width(); y++) {
			for (int x = 0; x < level.getGameMap().height(); x++)
				if (level.getGameMap().isWall(y, x))
					wallSprite.draw(graphics, x, y, spriteSize, offset);

		}

	}

	public int getOffset() {
		return offset;
	}

	public void setOffset(int offset) {
		this.offset = offset;
	}

	public int getSpriteSize() {
		return spriteSize;
	}

	public void setSpriteSize(int spriteSize) {
		this.spriteSize = spriteSize;
	}
}
