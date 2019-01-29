// COURSE: CSCI1620
// TERM: Spring 2019
//
// NAME: Cameron Gilinsky and Carter Kennell
// RESOURCES: Piazza discussion board posts by the students and instructors for this class,
//            found at https://piazza.com/class/jqiqv19pp2w4sw?cid=5

/**
 * This class encapsulates data and behaviors for a Paddle within the brick breaker game.
 * Once created a Paddle can move in the x dimension, but retains a fixed y coordinate.
 * Furthermore, all Paddle objects have a fixed height of 10 pixels and fixed width of 80 pixels.
 * @author bdorn
 */
public class Paddle
{
	/**
	 * The width of the Paddle.
	 */
	private static final int WIDTH = 80;
	
	/**
	 * The height of the Paddle.
	 */
	private static final int HEIGHT = 10;
	
	/**
	 * The starting left (x) and top (y) positions of the Paddle, respectively.
	 */
	private int left, top;

	/**
	 * Creates a new Paddle object at a specified coordinate location in the model.
	 * @param leftIn is the x position of the top-left corner for the new Paddle.
	 * @param topIn is the y position of the top-left corner for the new Paddle.
	 */
	public Paddle(int leftIn, int topIn)
	{
		left = leftIn;
		top = topIn;
	}
	
	/**
	 * Retrieves the x coordinate of the current left side of this Paddle.
	 * @return the x coordinate.
	 */
	public int getLeft()
	{
		return left;
	}
	
	/**
	 * Retrieves the y coordinate of the fixed top of this Paddle.
	 * @return the y coordinate.
	 */
	public int getTop()
	{
		return top;
	}
	
	/**
	 * Retrieves the fixed width of this Paddle object.
	 * @return the width of the Paddle in pixels.
	 */
	public int getWidth()
	{
		return WIDTH;
	}
	
	/**
	 * Retrieves the fixed height of this Paddle object.
	 * @return the height of the Paddle in pixels.
	 */
	public int getHeight()
	{
		return HEIGHT;
	}
	
	/**
	 * Updates the state of this Paddle object to correspond to a new x-position
	 * for its left-side. This method has no impact on the y positioning of thePaddle.
	 * @param newLeft is the new x coordinate for the Paddle's left side. 
	 * 		  A logical minimum of 0 is enforced on the Paddle, so negative values will 
	 * 		  result in a new position of 0.
	 */
	public void moveTo(int newLeft)
	{
		if (newLeft < 0)
		{
			left = 0;
		}
		else
		{
			left = newLeft;
		}
	}
	

	/**
	 * This method checks if the Ball is touching the top of the Paddle.
	 * @param theBall is the ball being used.
	 * @return whether or not the Ball is touching the top of the Paddle.
	 */
	public boolean touchingTop(Ball theBall)
	{	
		return theBall.getY() + theBall.getRadius() - 1 >= getTop() - 1 
				&& theBall.getY() + theBall.getRadius() - 1 <= getTop() + 4
				&& theBall.getX() >= getLeft() - 5
				&& theBall.getX() <= getLeft() + getWidth() + 4;
	}
	
	/**
	 * This method checks if the Ball is touching the left side of the Paddle.
	 * @param theBall is the ball being used.
	 * @return whether or not the Ball is touching the left side of the Paddle.
	 */
	public boolean touchingLeft(Ball theBall)
	{	
		return theBall.getX() + theBall.getRadius() - 1 >= getLeft() - 1
				&& theBall.getX() + theBall.getRadius() - 1 <= getLeft() + 4
				&& theBall.getY() >= getTop() - 2
				&& theBall.getY() <= getTop() + getHeight() + 1;
	}
	
	/**
	 * This method checks if the Ball is touching the right side of the Paddle.
	 * @param theBall is the ball being used.
	 * @return whether or not the Ball is touching the right side of the Paddle.
	 */
	public boolean touchingRight(Ball theBall)
	{	
		return theBall.getX() - theBall.getRadius() + 1 <= getLeft() + getWidth() + 1
				&& theBall.getX() - theBall.getRadius() + 1 >= getLeft() + getWidth() - 4
				&& theBall.getY() >= getTop() - 2
				&& theBall.getY() <= getTop() + getHeight() + 1;
	}
	
	/**
	 * This method implements a collision detection algorithm to identify whether
	 * this Paddle is currently being hit by a given Ball object. It will produce a
	 * return value to signal which side, if any, is currently being hit.
	 * @param theBall is the Ball to examine for collision with this Paddle.
	 * @return a valid TouchPosition state representing where theBall is intersecting
	 * 		   this Paddle.When no collision is detected at all NONE should be
	 *		   returned. Otherwise, TOP, LEFT, or RIGHT will be returned corresponding to
	 * 	  	   which side of this Paddle is currently being hit by theBall. Note, a value 
	 * 		   of BOTTOM is not possible under standard physics rules for brick breaker and thus 
	 * 		   is not expected.
	 */
	public TouchPosition isTouching(Ball theBall)
	{
		TouchPosition tP;
		
		if (touchingTop(theBall))
		{
			tP = TouchPosition.TOP;
		}
		else if (touchingRight(theBall))
		{
			tP = TouchPosition.RIGHT;
		}
		else if (touchingLeft(theBall))
		{
			tP = TouchPosition.LEFT;
		}
		else
		{
			tP = TouchPosition.NONE;
		}
		
		return tP;
	}
}
