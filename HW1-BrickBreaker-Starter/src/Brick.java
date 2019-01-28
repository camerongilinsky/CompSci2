// COURSE: CSCI1620
// TERM: Spring 2019
//
// NAME: Carter Kennell
// RESOURCES: Partner Programming with Cameron Gilinsky


import javafx.scene.paint.Color;

public class Brick 
{

	
	private static final int BRICK_HEIGHT = 20;
	private static final int BRICK_WIDTH = 50;
	private int brickLeft;
	private int brickTop;
	private Color brickColor;
	private boolean hit;
	private int brickStrength;
	
	
	public Brick (int topIn, int leftIn)
	{
		brickLeft = leftIn;
		brickTop = topIn;
		brickStrength = 3;
	}
	
	public Brick (int topIn, int leftIn, int hitsIn) 
	{
		brickTop = topIn;
		brickLeft = leftIn;
		brickStrength = hitsIn;
	}
	
	public void gotHit(Brick hitBrick)
	{
		if (brickStrength > 0)
		{
			brickStrength = brickStrength - 1;
		}
	}
	
	public int getTop()
	{
		return brickTop;
	}
	
	public int getLeft()
	{
		return brickLeft;	
	}
	
	public int getWidth()
	{
		return BRICK_WIDTH;
	}
	
	public int getHeight() 
	{
		return BRICK_HEIGHT;
	}
	
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
		/*else
		{
			brickColor = Color.BLACK;
		}*/
		return brickColor;
	}
	
	public int getStrength()
	{
		return brickStrength;
	}
	
	public boolean hit()
	{
		hit = false;
		
		if (brickStrength == 0)
		{
			hit = true;
		}
		
		return hit;
	}
	
	public TouchPosition isTouching (Ball theBall)
	{
		if ((theBall.getY() + theBall.getRadius()) - 1 >= getTop()
				&& (theBall.getY() + theBall.getRadius()) - 1 <= getTop() + 3
				&& (theBall.getX()) >= getLeft()
				&& (theBall.getX()) <= (getLeft() + BRICK_WIDTH - 1)
				&& brickColor != Color.WHITE)
		{
			return TouchPosition.TOP;
		} 
		else if ((theBall.getY() - theBall.getRadius()) + 1 <= (getTop() + BRICK_HEIGHT - 1)
				&& (theBall.getY() - theBall.getRadius()) + 1 >= (getTop() + BRICK_HEIGHT - 4)
				&& (theBall.getX()) >= getLeft()
				&& (theBall.getX()) <= (getLeft() + BRICK_WIDTH - 1)
				&& brickColor != Color.WHITE)
		{	
			return TouchPosition.BOTTOM;
		} 
		else if ((theBall.getX() + theBall.getRadius()) - 1 >= getLeft()
				&& (theBall.getX() + theBall.getRadius()) - 1 <= getLeft() + 3
				&& (theBall.getY()) >= getTop()
				&& (theBall.getY()) <= (getTop() + BRICK_HEIGHT - 1)
				&& brickColor != Color.WHITE)
		{
			return TouchPosition.LEFT;
		} 
		else if ((theBall.getX() - theBall.getRadius()) + 1 <= (getLeft() + BRICK_WIDTH - 1)
				&& (theBall.getX() - theBall.getRadius()) + 1 >= (getLeft() + BRICK_WIDTH - 4)
				&& (theBall.getY()) >= getTop()
				&& (theBall.getY()) <= (getTop() + BRICK_HEIGHT - 1)
				&& brickColor != Color.WHITE)
		{
			return TouchPosition.RIGHT;
		} 
		else
		{
			return TouchPosition.NONE;
		}
	}
	
	public String toString() 
	{
		String result;
		result = "Brick at " + getLeft() + " " + getTop() + " " 
				+ (getLeft() + BRICK_WIDTH - 1) + " " + (getTop() + BRICK_HEIGHT - 1);
		
		return result;
	}
}