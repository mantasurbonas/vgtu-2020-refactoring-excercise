package pacman;

public class GameRendered {

	private String toRender = " ";
	private boolean nonEmptyRender = false;

	public void renderMap(GameLevel gameLevel) {
		for (int y = 0; y < gameLevel.getGameMap().width(); y++) {
			for (int x = 0; x < gameLevel.getGameMap().height(); x++) {
				ResetState();

				for (Ghost ghost: gameLevel.getGhosts()) {
					if (ghost.at(x, y))
						UpdateRender("W");
				}
				if (gameLevel.getPacman().getPosition().at(x, y))
					UpdateRender("C");

				else if (gameLevel.getGameMap().isWall(y, x))
					UpdateRender("#");

				System.out.print(toRender);
			}
			System.out.println();
		}
	}

	private void ResetState() {
		this.toRender = " ";
		this.nonEmptyRender = false;
	}

	private void UpdateRender(String toRender) {
		if(!this.nonEmptyRender) {
			this.toRender = toRender;
			this.nonEmptyRender = true;
		}
	}
}
