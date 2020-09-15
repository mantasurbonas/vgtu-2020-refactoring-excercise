package pacman;

public class GameRules {

	private final GameLevel level;

	public GameRules(GameLevel level) {
		this.level = level;
	}

	public boolean isPacmanEaten() {
		boolean result = false;
		for (Ghost ghost: level.getGhosts())
			result = result || isPacmanEaten(ghost, level.getPacman());
		return result;
	}
	
	public static boolean isPacmanEaten(Ghost ghost, Pacman pacman) {
		return ghost.getPosition().equals(pacman.getPosition());
	}

	public void processUserInput(int key) {
		switch (key) {
			case 'q':
				closeGame();
				break;
			case 'a':
				if (level.getGameMap().isAvailable(level.getPacman().getPosition().left()))
					level.getPacman().setPosition( level.getPacman().getPosition().left());
				break;
			case 'd':
				if (level.getGameMap().isAvailable(level.getPacman().getPosition().right()))
					level.getPacman().setPosition( level.getPacman().getPosition().right());
				break;
			case 'w':
				if (level.getGameMap().isAvailable(level.getPacman().getPosition().up()))
					level.getPacman().setPosition( level.getPacman().getPosition().up());
				break;
			case 's':
				if (level.getGameMap().isAvailable(level.getPacman().getPosition().down()))
					level.getPacman().setPosition( level.getPacman().getPosition().down());
				break;

		}
	}

	public void moveGhosts() {
		for (Ghost ghost: level.getGhosts())
			moveGhost(ghost);
		
		if (isPacmanEaten())
			closeGame();
	}
	
	private void moveGhost(Ghost ghost) {
		if (!level.getGameMap().isAvailable(ghost.getNext()) ) {
			ghost.invertDx();
			ghost.invertDy();
		}
		
		ghost.moveNext();
	}

	public void closeGame() {
		System.exit(0);
	}
}
