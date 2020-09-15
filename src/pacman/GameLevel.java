package pacman;

import java.util.List;

public class GameLevel {

	private GameMap gameMap;
	private Pacman pacman;
	private List<Ghost> ghosts;

	public GameLevel(GameMap map, Pacman pacman, List<Ghost> ghosts) {
		setGameMap(map);
		setPacman(pacman);
		setGhosts(ghosts);
	}

	public GameMap getGameMap() {
		return gameMap;
	}

	public void setGameMap(GameMap gameMap) {
		this.gameMap = gameMap;
	}

	public Pacman getPacman() {
		return pacman;
	}

	public void setPacman(Pacman pacman) {
		this.pacman = pacman;
	}

	public List<Ghost> getGhosts() {
		return ghosts;
	}

	public void setGhosts(List<Ghost> ghosts) {
		this.ghosts = ghosts;
	}
}
