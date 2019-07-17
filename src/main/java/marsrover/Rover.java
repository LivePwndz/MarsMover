package marsrover;

public class Rover {

	private int x;
	private int y;
	private String direction;

	public Rover(int x, int y, String direction) {
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

	public String getDirection() {
		return direction;
	}

	public void setDirection(String direction) {
		this.direction = direction;
	}

	public void moveForward() {
		x++;
		y++;
	}

	public void moveBackward() {
		x--;
		y--;

	}

	public void turnLeft() {
		String currentDirection = getDirection();
		switch (currentDirection) {

		case "N": {
			setDirection("W");
			break;
		}

		case "W": {
			setDirection("S");
			break;
		}

		case "S": {
			setDirection("E");
			break;
		}

		case "E": {
			setDirection("N");
			break;
		}

		default: {
			throw new RuntimeException("Unknown direction");
		}

		}

	}
	
	
	public void turnRight() {
		String currentDirection = getDirection();
		switch (currentDirection) {

		case "N": {
			setDirection("E");
			break;
		}

		case "E": {
			setDirection("S");
			break;
		}

		case "S": {
			setDirection("W");
			break;
		}

		case "W": {
			setDirection("N");
			break;
		}

		default: {
			throw new RuntimeException("Unknown direction");
		}

		}

	}

}
