package marsrover;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

public class RoverTests {

	private static Rover rover;

	@BeforeClass
	public static void setup() {
		rover = new Rover(1, 1, Direction.N);
	}

	@Test
	public void shouldMoveForward() {
		int x = rover.getX();
		int y = rover.getY();

		int newX = x + 1;
		int newY = y + 1;

		rover.moveForward();
		Assert.assertTrue(rover.getX() == newX && rover.getY() == newY);

	}

	@Test
	public void shouldMoveBackward() {
		int x = rover.getX();
		int y = rover.getY();

		int newX = x - 1;
		int newY = y - 1;

		rover.moveBackward();
		Assert.assertTrue(rover.getX() == newX && rover.getY() == newY);

	}

	@Test
	public void shouldTurnLeft() {

		// Set direction
		rover.setDirection(Direction.N);
		rover.turnLeft();
		Assert.assertTrue(rover.getDirection().equals(Direction.W));

	}

	@Test
	public void shouldTurnRight() {
		// Set direction
		rover.setDirection(Direction.W);
		rover.turnRight();
		Assert.assertTrue(rover.getDirection().equals(Direction.N));

	}

}
