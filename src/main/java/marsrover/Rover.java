package marsrover;

public class Rover {

	private int x;
	private int y;
	private Direction direction;

	public Rover(int x, int y, Direction direction) {
		super();
		this.x = x;
		this.y = y;
		this.direction = direction;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public Direction getDirection() {
		return direction;
	}

	public void setDirection(Direction direction) {
		this.direction = direction;
	}

	private void moveForward() {
		x++;
		y++;
	}

	private void moveBackward() {
		x--;
		y--;

	}

	private void turnLeft() {
		Direction currentDirection = getDirection();
		switch (currentDirection) {

		case N: {
			setDirection(Direction.W);
			break;
		}

		case W: {
			setDirection(Direction.S);
			break;
		}

		case S: {
			setDirection(Direction.E);
			break;
		}

		case E: {
			setDirection(Direction.N);
			break;
		}

		default: {
			throw new RuntimeException("Unknown direction");
		}

		}

	}

	private void turnRight() {
		Direction currentDirection = getDirection();
		switch (currentDirection) {

		case N: {
			setDirection(Direction.E);
			break;
		}

		case E: {
			setDirection(Direction.S);
			break;
		}

		case S: {
			setDirection(Direction.W);
			break;
		}

		case W: {
			setDirection(Direction.N);
			break;
		}

		default: {
			throw new RuntimeException("Unknown direction");
		}

		}

	}

	public void receiveCommand(char f) {

		switch (f) {
		case 'f': {
			moveForward();
			break;
		}

		case 'b': {
			moveBackward();
			break;
		}
		
		case 'l': {
			turnLeft();
			break;
		}
		
		case 'r': {
			turnRight();
			break;
		}

		default: {
			throw new RuntimeException("Unknown command: " + f);
		}
		}
	}

}
