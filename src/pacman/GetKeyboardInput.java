package pacman;

public class GetKeyboardInput {

    private final GameLevel level;

    public GetKeyboardInput(GameLevel level) {
        this.level = level;
    }

    public void processUserInput(int key) {
        switch (key) {
            case 'a':
                if (level.getGameMap().isAvailable(level.getPacman().getPosition().left()))
                    level.getPacman().setPosition(level.getPacman().getPosition().left());
                break;
            case 'd':
                if (level.getGameMap().isAvailable(level.getPacman().getPosition().right()))
                    level.getPacman().setPosition(level.getPacman().getPosition().right());
                break;
            case 'w':
                if (level.getGameMap().isAvailable(level.getPacman().getPosition().up()))
                    level.getPacman().setPosition(level.getPacman().getPosition().up());
                break;
            case 's':
                if (level.getGameMap().isAvailable(level.getPacman().getPosition().down()))
                    level.getPacman().setPosition(level.getPacman().getPosition().down());
                break;
            case 'q':
                System.exit(0);
        }
    }
}
