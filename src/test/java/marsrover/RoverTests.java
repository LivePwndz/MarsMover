package marsrover;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class RoverTests {

	private Rover rover;

	@Before
	public void setup() {
		rover = new Rover(new Point(1, 10), new Point(1, 10), Direction.N);
	}

	@Test(expected = RuntimeException.class)
	public void onReceivingInvalidCommandshouldThrowRuntimeException() {
		rover.receiveCommands(new char[] { 'K' });
	}

	@Test
	public void shouldReceiveMultipleCommands() {
		int x = rover.getX().getValue();
		int y = rover.getY().getValue();

		int newXValue = x + 0;
		int newYValue = y + 0;
		rover.receiveCommands(new char[] { 'f', 'b', 'l', 'r' });

		Assert.assertTrue(rover.getX().getValue() == newXValue && rover.getY().getValue() == newYValue);
		Assert.assertTrue(rover.getDirection().equals(Direction.N));

	}

	@Test
	public void shouldMoveForward() {
		int x = rover.getX().getValue();
		int y = rover.getY().getValue();

		int newXValue = x + 1;
		int newYValue = y + 1;
		rover.receiveCommands(new char[] { 'f' });

		Assert.assertTrue(rover.getX().getValue() == newXValue && rover.getY().getValue() == newYValue);

	}

	@Test
	public void shouldMoveForwardAndWrap() {
		// rover.setX(new Point(10));
		int x = rover.getX().getValue();
		int y = rover.getY().getValue();

		int newXValue = x + 1;
		int newYValue = y + 1;
		rover.receiveCommands(new char[] { 'f' });

		Assert.assertTrue(rover.getX().getValue() == newXValue && rover.getY().getValue() == newYValue);

	}

	@Test
	public void shouldMoveBackward() {
		int x = rover.getX().getValue();
		int y = rover.getY().getValue();

		int newXValue = x - 1;
		int newYValue = y - 1;

		rover.receiveCommands(new char[] { 'b' });
		Assert.assertTrue(rover.getX().getValue() == newXValue && rover.getY().getValue() == newYValue);

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
