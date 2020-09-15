package pacman;

public class GameRules {

	private final GameLevel level;

	public GameRules(GameLevel level) {
		this.level = level;
	}

	public boolean isPacmanEaten() {
		for (Ghost ghost: level.getGhosts())
			if(isPacmanEaten(ghost, level.getPacman()))
				return true;
		return false;
	}
	
	public static boolean isPacmanEaten(Ghost ghost, Pacman pacman) {
		return ghost.getPosition().equals(pacman.getPosition());
	}

	public void processUserInput(PlayerInput playerInput) {
		switch (playerInput) {
			case UP:
				if (level.getGameMap().isAvailable(level.getPacman().getPosition().up()))
					level.getPacman().setPosition(level.getPacman().getPosition().up());
				break;
			case RIGHT:
				if (level.getGameMap().isAvailable(level.getPacman().getPosition().right()))
					level.getPacman().setPosition(level.getPacman().getPosition().right());
				break;
			case DOWN:
				if (level.getGameMap().isAvailable(level.getPacman().getPosition().down()))
					level.getPacman().setPosition(level.getPacman().getPosition().down());
				break;
			case LEFT:
				if (level.getGameMap().isAvailable(level.getPacman().getPosition().left()))
					level.getPacman().setPosition(level.getPacman().getPosition().left());
				break;
			case QUIT:
				closeGame();
			default:
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
			ghost.invert();
		}
		
		ghost.moveNext();
	}

	public void closeGame() {
		System.exit(0);
	}
}
