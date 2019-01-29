// COURSE: CSCI1620
// TERM: Spring 2019
//
// NAME: Cameron Gilinsky and Carter Kennell
// RESOURCES: Piazza discussion board posts by the students and instructors for this class,
//            found at https://piazza.com/class/jqiqv19pp2w4sw?cid=5

/**
 * The Ball class encapsulates the basic data and behaviors to model the ball within the
 * brick breaker game. All Ball objects have a fixed radius of 10 pixels.
 * @author bdorn
 *
 */
public class Ball
{
	/**
	 * The Ball's x velocity in pixels.
	 */
	private static final int DX = 3;
	
	/**
	 * The Ball's y velocity in pixels.
	 */
	private static final int DY = 3;
	
	/**
	 * Starting position of the Ball, both x and y.
	 */
	private static final int POSITION = 100;
	
	/**
	 * Radius of the Ball.
	 */
	private static final int RADIUS = 10;
	
	/**
	 * Position of the Ball's center on the Level.
	 */
	private int xPos, yPos;
	
	/**
	 * The x and y velocities of the Ball.
	 */
	private int dx, dy;
	
	/**
	 * Creates a default Ball object with an initial location of (100, 100)
	 * and an initial trajectory of 3 pixels in both x and y dimensions.
	 */
	public Ball()
	{
		xPos = POSITION;
		yPos = POSITION;
		dx = DX;
		dy = DY;
	}
	
	/**
	 * Creates a Ball object with a custom initial location and a default
	 * trajectory of 3 pixels in both the x and y dimensions.
	 * @param x is the starting x position of the Ball's center.
	 * @param y is the starting y position of the Ball's center.
	 */
	public Ball(int x, int y)
	{
		xPos = x;
		yPos = y;
		dx = DX;
		dy = DY;
		
	}
	
	/**
	 * Causes this Ball's current horizontal trajectory to
	 * reverse direction by 180 degrees.
	 */
	public void bounceHorizontal()
	{
		dx *= -1;
	}
	
	/**
	 * Causes this Ball's current vertical trajectory to
	 * reverse direction by 180 degrees.
	 */
	public void bounceVertical()
	{
		dy *= -1;
	}
	
	/**
	 * Retrieves the radius of this Ball.
	 * @return the radius of this Ball.
	 */
	public int getRadius()
	{
		int radius = RADIUS;
		return radius;
	}
	
	/**
	 * Retrieves the current x position of this Ball's center.
	 * @return the x coordinate of the Ball's center.
	 */
	public int getX()
	{
		return xPos;
	}
	
	/**
	 * Retrieves the current y position of this Ball's center.
	 * @return the y coordinate of the Ball's center.
	 */
	public int getY()
	{
		return yPos;
	}
	
	/**
	 * This mutator method will move the position of this Ball through one timestep
	 * in the game by applying the x and y trajectory offsets to compute the new center
	 * position of this Ball.
	 */
	public void moveOnce()
	{
		xPos += dx;
		yPos += dy;
	}

	/**
	 * Retrieves a string representation of this Ball formatted as: 
	 * "Ball at (x, y) moving (dx, dy)" where x and y are the current x and y
	 * positions of this Ball's center and dx and dy are the current trajectory
	 * offsets for this Ball that are applied in each moveOnce operation.
	 * @return the String described above.
	 */
	public String toString()
	{
		return String.format("Ball at (%d, %d) moving (%d, %d)", xPos, yPos, dx, dy);
	}
}
