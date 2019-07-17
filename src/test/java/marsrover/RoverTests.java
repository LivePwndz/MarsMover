package marsrover;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class RoverTests {

	private Rover rover;

	@Before
	public void setup() {
		rover = new Rover(new Navigation(new Point(1, 10), new Point(1, 10), Direction.N));
	}

	@Test(expected = RuntimeException.class)
	public void onReceivingInvalidCommandshouldThrowRuntimeException() {
		rover.receiveCommands(new char[] { 'K' });
	}

	// @Ignore
	@Test
	public void facingNorthShouldReceiveMultipleCommands() {
		int x = rover.getNav().getX().getValue();
		int y = rover.getNav().getY().getValue();

		int newXValue = x + 0;
		int newYValue = y + 0;
		rover.receiveCommands(new char[] { 'f', 'b', 'l', 'r' });
		Assert.assertTrue(
				rover.getNav().getY().getValue() == newXValue && rover.getNav().getY().getValue() == newYValue);
		Assert.assertTrue(rover.getNav().getDirection().equals(Direction.N));

	}

	// @Ignore
	@Test
	public void facingNorthShouldMoveForward() {
		int x = rover.getNav().getY().getValue();
		int y = rover.getNav().getX().getValue();

		int newXValue = x;
		int newYValue = y + 1;
		rover.receiveCommands(new char[] { 'f' });

		Assert.assertTrue(
				rover.getNav().getX().getValue() == newXValue && rover.getNav().getY().getValue() == newYValue);

	}

	// @Ignore
	@Test
	public void facingNorthShouldMoveForwardAndWrap() {

		rover.getNav().setY(new Point(10));

		int newXValue = rover.getNav().getX().getValue();
		int newYValue = 0;
		rover.receiveCommands(new char[] { 'f' });

		Assert.assertTrue(
				rover.getNav().getX().getValue() == newXValue && rover.getNav().getY().getValue() == newYValue);

	}

	@Test
	public void facingNorthShouldMoveBackward() {
		int x = rover.getNav().getX().getValue();
		int y = rover.getNav().getY().getValue();

		int newXValue = x;
		int newYValue = y - 1;

		rover.receiveCommands(new char[] { 'b' });
		Assert.assertTrue(
				rover.getNav().getX().getValue() == newXValue && rover.getNav().getY().getValue() == newYValue);

	}

	@Test
	public void facingNorthShouldMoveBackwardAndWrap() {
		// rover.setX(new Point(0));
		rover.getNav().setY(new Point(0));

		int newXValue = rover.getNav().getY().getValue();
		int newYValue = rover.getNav().getY().getValueMax();

		rover.receiveCommands(new char[] { 'b' });
		Assert.assertTrue(
				rover.getNav().getY().getValue() == newXValue && rover.getNav().getY().getValue() == newYValue);

	}

	@Test
	public void shouldTurnLeft() {
		// Set direction
		rover.getNav().setDirection(Direction.N);
		rover.receiveCommands(new char[] { 'l' });
		Assert.assertTrue(rover.getNav().getDirection().equals(Direction.W));

	}

	@Test
	public void shouldTurnRight() {
		// Set direction
		rover.getNav().setDirection(Direction.W);
		rover.receiveCommands(new char[] { 'r' });
		Assert.assertTrue(rover.getNav().getDirection().equals(Direction.N));

	}

	@Test
	public void shouldMakeCompleteTurnClockwise() {
		// Set direction
		rover.getNav().setDirection(Direction.N);
		rover.receiveCommands(new char[] { 'r', 'r', 'r', 'r' });
		Assert.assertTrue(rover.getNav().getDirection().equals(Direction.N));

	}

	@Test
	public void shouldMakeCompleteTurnAntiClockwise() {
		// Set direction
		rover.getNav().setDirection(Direction.N);
		rover.receiveCommands(new char[] { 'l', 'l', 'l', 'l' });
		Assert.assertTrue(rover.getNav().getDirection().equals(Direction.N));

	}

}
