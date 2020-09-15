package pacman;

public class Ghost {
    private final Position position;
    private final Delta delta;

    public Ghost(Position position, Delta delta) {
        this.position = position;
        this.delta = delta;
    }

    public void moveNext() {
        position.apply(delta);
    }

    public void invert() {
        delta.invert();
    }

    public Position getPosition() {
        return position;
    }

    public Position getNext() {
        return position.next(delta);
    }
}
