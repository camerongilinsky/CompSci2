// COURSE: CSCI1620
// TERM: Spring 2019
//
// NAME: Cameron Gilinsky and Carter Kennell
// RESOURCES: Piazza discussion board posts by the students and instructors for this class,
//            found at https://piazza.com/class/jqiqv19pp2w4sw?cid=5


import javafx.scene.paint.Color;

/**
 * This class is used to store state information corresponding to a single Brick within
 * the brick breaker game model. It provides basic information about the Brick's position
 * as well as information about the current strength of a Brick. All Bricks in brick breaker
 * have a height of 20 and a width of 50, regardless of other state information.
 * @author bdorn
 */
public class Brick 
{
	/**
	 * Height of the Brick.
	 */
	private static final int BRICK_HEIGHT = 20;
	
	/**
	 * Width of the Brick.
	 */
	private static final int BRICK_WIDTH = 50;
	
	/**
	 * The starting left (x) position of the Brick.
	 */
	private int brickLeft;
	
	/**
	 * The starting top (y) position of the Brick.
	 */
	private int brickTop;
	
	/**
	 * The Color of the Brick.
	 */
	private Color brickColor;
	
	/**
	 * The strength of the Brick.
	 */
	private int brickStrength;
	
	/**
	 * Creates a basic Brick object at a specified position. The new Brick will default
	 * with a strength of 3, meaning that it will break after 3 hits by a ball.
	 * @param topIn is the y position of the top of this Brick in the model.
	 * @param leftIn is the x position of the left side of this Brick in the model.
	 */
	public Brick(int topIn, int leftIn)
	{
		brickLeft = leftIn;
		brickTop = topIn;
		brickStrength = 3;
	}
	
	/**
	 * Creates a custom Brick object at a specified position with a specified strength.
	 * @param topIn is the y position of the top of this Brick in the model.
	 * @param leftIn is the x position of the left side of this Brick in the model.
	 * @param hitsIn is The initial strength of this Brick. A value greater than zero represents
	 * 		  that this Brick will break after that number of hits. A value of 0 represents
	 * 		  a "non-brick" or empty space in the model. A value of -1 represents that this
	 * 		  Brick cannot be broken at all, regardless of the number of hits.
	 */
	public Brick(int topIn, int leftIn, int hitsIn) 
	{
		brickTop = topIn;
		brickLeft = leftIn;
		brickStrength = hitsIn;
	}
	
	/**
	 * Retrieves the y coordinate of the top of this Brick.
	 * @return the y coordinate of the top edge.
	 */
	public int getTop()
	{
		return brickTop;
	}
	
	/**
	 * Retrieves the x coordinate of the left side of this Brick.
	 * @return the x coordinate of the left edge.
	 */
	public int getLeft()
	{
		return brickLeft;	
	}
	
	/**
	 * Retrieves the width of this Brick.
	 * @return the width of the Brick.
	 */
	public int getWidth()
	{
		return BRICK_WIDTH;
	}
	
	/**
	 * Retrieves the height of this Brick.
	 * @return the height of the Brick.
	 */
	public int getHeight()
	{
		return BRICK_HEIGHT;
	}
	
	/**
	 * The current color to represent this Brick's breakability state.
	 * @return There are five possible Colors that can be returned based
	 * 		   on theBrick's current strength: Color.BLACK if this Brick cannot be broken;
	 * 		   Color.WHITE if this Brick has been completely broken; and Color.RED,
	 * 		   Color.YELLOW, Color.GREEN if this Brick will break after 1, 2, and 3 more hits,
	 * 		   consecutively.
	 */
	public javafx.scene.paint.Color getColor()
	{
		if (brickStrength == 3)
		{
			brickColor = Color.GREEN;
		}
		else if (brickStrength == 2)
		{
			brickColor = Color.YELLOW;
		}
		else if (brickStrength == 1)
		{
			brickColor = Color.RED;
		}
		else if (brickStrength == 0)
		{
			brickColor = Color.WHITE;
		}
		else if (brickStrength == -1)
		{
			brickColor = Color.BLACK;
		}
		
		return brickColor;
	}
	
	/**
	 * Returns the current strength of the Brick.
	 * @return the current strength value of the Brick.
	 */
	public int getStrength()
	{
		return brickStrength;
	}
	
	/**
	 * This mutator method will update this Brick's state data to account for being hit
	 * by the Ball once.
	 * @return true when the hit caused this brick to break completely, false otherwise.
	 */
	public boolean hit()
	{
		boolean hit = false;
		
		if (brickStrength > 1)
		{
			brickStrength--;
			getColor();
		}
		else if (brickStrength == 1)
		{
			brickStrength--;
			getColor();
			hit = true;
		}
		
		return hit;
	}
	
	/**
	 * This method checks if the Ball is touching the top of the Brick.
	 * @param theBall is the ball being used.
	 * @return whether or not the Ball is touching the top of the Brick.
	 */
	public boolean touchingTop(Ball theBall)
	{	
		return (theBall.getY() + theBall.getRadius()) - 1 >= getTop() - 1
				&& (theBall.getY() + theBall.getRadius()) - 1 <= getTop() + 4
				&& (theBall.getX()) >= getLeft() - 6
				&& (theBall.getX()) <= (getLeft() + getWidth() + 5)
				&& brickColor != Color.WHITE;
	}
	
	/**
	 * This method checks if the Ball is touching the bottom of the Brick.
	 * @param theBall is the ball being used.
	 * @return whether or not the Ball is touching the bottom of the Brick.
	 */
	public boolean touchingBottom(Ball theBall)
	{	
		return (theBall.getY() - theBall.getRadius()) + 1 <= (getTop() + getHeight())
				&& (theBall.getY() - theBall.getRadius()) + 1 >= (getTop() + getHeight() - 5)
				&& (theBall.getX()) >= getLeft() - 6
				&& (theBall.getX()) <= (getLeft() + getWidth() + 5)
				&& brickColor != Color.WHITE;
	}
	
	/**
	 * This method checks if the Ball is touching the left side of the Brick.
	 * @param theBall is the ball being used.
	 * @return whether or not the Ball is touching the left side of the Brick.
	 */
	public boolean touchingLeft(Ball theBall)
	{	
		return (theBall.getX() + theBall.getRadius()) - 1 >= getLeft() - 1
				&& (theBall.getX() + theBall.getRadius()) - 1 <= getLeft() + 4
				&& (theBall.getY()) >= getTop() - 2
				&& (theBall.getY()) <= (getTop() + getHeight() + 1)
				&& brickColor != Color.WHITE;
	}
	
	/**
	 * This method checks if the Ball is touching the right side of the Brick.
	 * @param theBall is the ball being used.
	 * @return whether or not the Ball is touching the right side of the Brick.
	 */
	public boolean touchingRight(Ball theBall)
	{	
		return (theBall.getX() - theBall.getRadius()) + 1 <= (getLeft() + getWidth() + 1)
				&& (theBall.getX() - theBall.getRadius()) + 1 >= (getLeft() + getWidth() - 4)
				&& (theBall.getY()) >= getTop() - 2
				&& (theBall.getY()) <= (getTop() + getHeight() + 1)
				&& brickColor != Color.WHITE;
	}
	
	/**
	 * This method implements a collision detection algorithm to identify whether
	 * this Brick is currently being hit by a given Ball object. It will produce a
	 * return value to signal which side, if any, is currently being hit.
	 * @param theBall is the Ball to examine for collision with this Brick.
	 * @return a valid TouchPosition state representing where theBall is intersecting
	 * 		   this Brick. When no collision is detected at all or this Brick is already broken,
	 * 		   NONE should be returned. Otherwise, TOP, BOTTOM, LEFT, or RIGHT will be returned 
	 * 		   corresponding to which side of this Brick is currently being hit by theBall.
	 */
	public TouchPosition isTouching(Ball theBall)
	{
		TouchPosition tP;
		
		
		if (brickStrength == 0)
		{
			tP = TouchPosition.NONE;
		}
		else if (touchingTop(theBall))
		{
			tP = TouchPosition.TOP;
		} 
		else if (touchingBottom(theBall))
		{	
			tP = TouchPosition.BOTTOM;
		} 
		else if (touchingLeft(theBall))
		{
			tP = TouchPosition.LEFT;
		} 
		else if (touchingRight(theBall))
		{
			tP = TouchPosition.RIGHT;
		} 
		else
		{
			tP = TouchPosition.NONE;
		}
		
		return tP;
	}
	
	/**
	 * Retrieves a String representation of this Brick's current object state.
	 * The string will beformatted as: 
     * "Brick at (tlx, tly, brx, bry)"
     * where tlx/tly are the x and y coordinates of the top/left corner and brx/bry
     * are the x and y coordinates of the bottom right corner of this Brick.
     * @return the String described above.
	 */
	public String toString()
	{				
		return String.format("Brick at (%d, %d, %d, %d)",
				brickLeft, brickTop, brickLeft + BRICK_WIDTH - 1, brickTop + BRICK_HEIGHT - 1);
	}
}