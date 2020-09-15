package pacman;

public class Pacman {

    private Position position;

    public Pacman(Position pos) {
        this.position = pos;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }
}