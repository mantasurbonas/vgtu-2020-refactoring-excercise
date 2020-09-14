package pacman;

public class GameRendered {

	public void renderMap(GameLevel gameLevel) {
		for (int y = 0; y < gameLevel.getGameMap().width(); y++) {
			for (int x = 0; x < gameLevel.getGameMap().height(); x++) {
				boolean isGhost = false;
				for (Ghost ghost: gameLevel.getGhosts()) {
					if (ghost.at(x, y)){
						System.out.print("W");
						isGhost = true;
					}
				}

				if (isGhost)
					continue;
				if (gameLevel.getPacman().getPosition().at(x, y)) {
					System.out.print("C");
				}
				else
				if (gameLevel.getGameMap().isWall(y, x))
					System.out.print("#");
				else
				if (gameLevel.getGameMap().isAvailable(y, x))
					System.out.print(" ");
			}
			System.out.println();
		}
	}
}
