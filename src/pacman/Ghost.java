package pacman;

public class Ghost{
	Position position;
	
	int ghostDx = -1;
	int ghostDy = 0;
	
	public Ghost(Position position, int dx, int dy) {
		this.position = position;
		this.ghostDx = dx;
		this.ghostDy = dy;
	}

	public boolean at(int x, int y) {
		return position.getY() == y && position.getX() == x;
	}

	public void moveNext() {
		position.setX(ghostDx + position.getX());
		position.setY(ghostDy + position.getY());
	}

	public void invertDx() {
		ghostDx = -1 * ghostDx;		
	}

	public void invertDy() {
		ghostDy = -1 * ghostDy;		
	}

	public Position getPosition() {
		return position;
	}

	public Position getNext() {
		return new Position(position).addX(ghostDx).addY(ghostDy);
	}
};
