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
		value = value + 1;
		if( value > valueMax ) {
			value = 0;
		}
		
	}
	
	public void moveBackward() {
		value = value - 1;
		if( value < 0 ) {
			value = valueMax;
		}
		
	}
	
	
	
}
