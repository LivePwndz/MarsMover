package marsrover;

public class Rover {

	private Navigation nav;

	public Rover( Navigation nav ) {
		super();
		this.nav = nav;
	}







	public Navigation getNav() {
		return nav;
	}







	public void setNav(Navigation nav) {
		this.nav = nav;
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
			nav.moveForward();
			break;
		}

		case 'b': {
			nav.moveBackward();
			break;
		}

		case 'l': {
			nav.turnLeft();
			break;
		}

		case 'r': {
			nav.turnRight();
			break;
		}

		default: {
			throw new RuntimeException("Unknown command: " + f);
		}
		}
	}

}
