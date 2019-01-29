// COURSE: CSCI1620
// TERM: Spring 2019
//
// NAME: Cameron Gilinsky and Carter Kennell
// RESOURCES: Piazza discussion board posts by the students and instructors for this class,
//            found at https://piazza.com/class/jqiqv19pp2w4sw?cid=5


import javafx.scene.paint.Color;

public class Brick 
{

	
	private static final int BRICK_HEIGHT = 20;
	private static final int BRICK_WIDTH = 50;
	private int brickLeft;
	private int brickTop;
	private Color brickColor;
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
	
	/*public void gotHit(Brick hitBrick)
	{
		if (brickStrength > 0)
		{
			brickStrength = brickStrength - 1;
		}
	}*/
	
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
		boolean hit = false;
		
		if (brickStrength == 0)
		{
			hit = true;
		}
		else
		{
			brickStrength--;
		}
		
		return hit;
	}
	
	public TouchPosition isTouching (Ball theBall)
	{
		if ((theBall.getY() + theBall.getRadius()) - 1 >= getTop() - 1
				&& (theBall.getY() + theBall.getRadius()) - 1 <= getTop() + 4
				&& (theBall.getX()) >= getLeft() - 4
				&& (theBall.getX()) <= (getLeft() + getWidth() + 3)
				&& brickColor != Color.WHITE)
		{
			return TouchPosition.TOP;
		} 
		else if ((theBall.getY() - theBall.getRadius()) + 1 <= (getTop() + getHeight() - 1)
				&& (theBall.getY() - theBall.getRadius()) + 1 >= (getTop() + getHeight() - 4)
				&& (theBall.getX()) >= getLeft() - 3
				&& (theBall.getX()) <= (getLeft() + getWidth() + 3)
				&& brickColor != Color.WHITE)
		{	
			return TouchPosition.BOTTOM;
		} 
		else if ((theBall.getX() + theBall.getRadius()) - 1 >= getLeft() - 1
				&& (theBall.getX() + theBall.getRadius()) - 1 <= getLeft() + 4
				&& (theBall.getY()) >= getTop() - 2
				&& (theBall.getY()) <= (getTop() + getHeight() + 1)
				&& brickColor != Color.WHITE)
		{
			return TouchPosition.LEFT;
		} 
		else if ((theBall.getX() - theBall.getRadius()) + 1 <= (getLeft() + getWidth() + 1)
				&& (theBall.getX() - theBall.getRadius()) + 1 >= (getLeft() + getWidth() - 4)
				&& (theBall.getY()) >= getTop() - 2
				&& (theBall.getY()) <= (getTop() + getHeight() + 1)
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