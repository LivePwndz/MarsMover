package marsrover;

public class Rover {

	private Point x;
	private Point y;
	private Direction direction;

	public Rover(Point x, Point y, Direction direction) {
		super();
		this.x = x;
		this.y = y;
		this.direction = direction;
	}

	public void move( Direction direction) {
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
		Direction reverseDirection = getDirection().getReverseDirection();
		move(reverseDirection);
	}
	
	public void moveForward() {
		move(getDirection());
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

	public void receiveCommands(char[] commands) {
		if (commands == null)
			throw new RuntimeException("Commands argument is NULL");

		for (char command : commands) {
			receiveCommand(command);
		}
	}

	private void receiveCommand(char f) {

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
