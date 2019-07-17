package marsrover;

public enum Direction {
	N( 0,"N"),E( 1,"E"),S(2,"S"),W(3,"W");
	

    private int value;

    private String shortName;
    
    Direction( int value, String shortName ) {
    	this.value = value;
    	this.shortName = shortName;
    }
    

    public Direction getReverseDirection() {
        return values()[(this.getValue() + 2) % 4];

    }

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public String getShortName() {
		return shortName;
	}

	public void setShortName(String shortName) {
		this.shortName = shortName;
	}
    
    
}
