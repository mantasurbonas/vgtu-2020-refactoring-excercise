package pacman;

public class Delta {
    private int dx;
    private int dy;

    public Delta(int dx, int dy) {
        this.setDX(dx);
        this.setDY(dy);
    }

    public Delta(Delta delta) {
        this.dx = delta.dx;
        this.dy = delta.dy;
    }

    public void invertX() {
        this.setDX(-1 * this.getDX());
    }

    public void invertY() {
        this.setDY(-1 * this.getDY());
    }

    public void invert() {
        invertX();
        invertY();
    }

    public int getDX() {
        return this.dx;
    }

    public int getDY() {
        return this.dy;
    }

    public void setDX(int dx) {
        this.dx = dx;
    }

    public void setDY(int dy) {
        this.dy = dy;
    }
}
