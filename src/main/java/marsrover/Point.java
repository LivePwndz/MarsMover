package marsrover;

public class Point {
	private int value;
	private int valueMax;

	public Point(int value) {
		super();
		this.value = value;
	}

	public Point(int value, int valueMax) {
		super();
		this.value = value;
		this.valueMax = valueMax;
	}

	public int getValueMax() {
		return valueMax;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public void moveForward() {
		move(1);

	}

	public void move(int unit) {
		value = value + unit;
		if (value > valueMax) {
			value = 0;
		} else if (value < 0) {
			value = valueMax;
		}

	}

	public void moveBackward() {
		move(-1);
	}

}
