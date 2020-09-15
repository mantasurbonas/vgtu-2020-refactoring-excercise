package pacman;

public enum PlayerInput {
    NONE(0),
    UP(1),
    RIGHT(1),
    DOWN(1),
    LEFT(1),
    QUIT(2);

    public int getPriority() {
        return this.priority;
    }

    PlayerInput(int priority) {
        this.priority = priority;
    }

    private final int priority;
}
