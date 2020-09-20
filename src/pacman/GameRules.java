package pacman;

public class GameRules {

    private final GameLevel level;

    public GameRules(GameLevel level) {
        this.level = level;
    }

    public boolean isPacmanEaten() {
        boolean result = false;
        for (Ghost ghost : level.getGhosts())
            result = result || isPacmanEaten(ghost, level.getPacman());
        return result;
    }

    public static boolean isPacmanEaten(Ghost ghost, Pacman pacman) {
        return ghost.getPosition().equals(pacman.getPosition());
    }

    public void moveGhosts() {
        for (Ghost ghost : level.getGhosts())
            moveGhost(ghost);
    }

    private void moveGhost(Ghost ghost) {
        if (!level.getGameMap().isAvailable(ghost.getNext())) {
            ghost.invertDx();
            ghost.invertDy();
        }

        ghost.moveNext();
    }
}
