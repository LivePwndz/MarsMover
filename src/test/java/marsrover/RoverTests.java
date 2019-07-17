package marsrover;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class RoverTests {

	private Rover rover;

	@Before
	public void setup() {
		rover = new Rover(1, 1, Direction.N);
	}
	
	
	@Test( expected = RuntimeException.class )
	public void onReceivingInvalidCommandshouldThrowRuntimeException() {
		rover.receiveCommands(new char[] { 'K' });
	}
	

	@Test
	public void shouldReceiveMultipleCommands() {
		int x = rover.getX();
		int y = rover.getY();

		int newX = x + 0;
		int newY = y + 0;
		rover.receiveCommands(new char[] { 'f', 'b', 'l', 'r' });

		Assert.assertTrue(rover.getX() == newX && rover.getY() == newY);
		Assert.assertTrue(rover.getDirection().equals(Direction.N));

	}

	@Test
	public void shouldMoveForward() {
		int x = rover.getX();
		int y = rover.getY();

		int newX = x + 1;
		int newY = y + 1;
		rover.receiveCommands(new char[] { 'f' });

		Assert.assertTrue(rover.getX() == newX && rover.getY() == newY);

	}

	@Test
	public void shouldMoveBackward() {
		int x = rover.getX();
		int y = rover.getY();

		int newX = x - 1;
		int newY = y - 1;

		rover.receiveCommands(new char[] { 'b' });
		Assert.assertTrue(rover.getX() == newX && rover.getY() == newY);

	}

	@Test
	public void shouldTurnLeft() {
		// Set direction
		rover.setDirection(Direction.N);
		rover.receiveCommands(new char[] { 'l' });
		Assert.assertTrue(rover.getDirection().equals(Direction.W));

	}

	@Test
	public void shouldTurnRight() {
		// Set direction
		rover.setDirection(Direction.W);
		rover.receiveCommands(new char[] { 'r' });
		Assert.assertTrue(rover.getDirection().equals(Direction.N));

	}

}
