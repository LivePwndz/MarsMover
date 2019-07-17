package marsrover;

public class Navigation {

	private Point x;
	private Point y;
	private Direction direction;

	public Navigation(Point x, Point y, Direction direction) {
		super();
		this.x = x;
		this.y = y;
		this.direction = direction;
	}

	public Point getX() {
		return x;
	}

	public void setX(Point x) {
		this.x = x;
	}

	public Point getY() {
		return y;
	}

	public void setY(Point y) {
		this.y = y;
	}

	public Direction getDirection() {
		return direction;
	}

	public void setDirection(Direction direction) {
		this.direction = direction;
	}

	public void move(Direction direction) {
		switch (direction) {

		case N: {
			y.moveForward();
			break;
		}

		case E: {
			x.moveForward();
			break;
		}

		case S: {
			y.moveBackward();
			break;
		}

		case W: {
			x.moveBackward();
			break;
		}

		default: {
			throw new RuntimeException("Unknown direction");
		}

		}

	}

	public void moveBackward() {
		Direction reverseDirection = direction.getReverseDirection();
		move(reverseDirection);
	}

	public void moveForward() {
		move(direction);
	}

	void turnLeft() {
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

	void turnRight() {
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

}
