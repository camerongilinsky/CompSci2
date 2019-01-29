// COURSE: CSCI1620
// TERM: Spring 2019
//
// NAME: Cameron Gilinsky and Carter Kennell
// RESOURCES: Piazza discussion board posts by the students and instructors for this class,
//            found at https://piazza.com/class/jqiqv19pp2w4sw?cid=5

public class Paddle
{
	private static final int WIDTH = 80;
	private static final int HEIGHT = 10;
	private int left, top;
	//constructor
	public Paddle(int leftIn, int topIn)
	{
		left = leftIn;
		top = topIn;
	}
	
	public int getLeft()
	{
		return left;
	}
	
	public int getTop()
	{
		return top;
	}
	
	public int getWidth()
	{
		return WIDTH;
	}
	
	public int getHeight()
	{
		return HEIGHT;
	}
	
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
	
	public TouchPosition isTouching(Ball theBall)
	{
		if (theBall.getY() + theBall.getRadius() - 1 >= getTop() - 1
				&& theBall.getY() + theBall.getRadius() - 1 <= getTop() + 4
				&& theBall.getX() >= getLeft() - 5
				&& theBall.getX() <= getLeft() + getWidth() + 4)
		{
			return TouchPosition.TOP;
		}
		else if (theBall.getX() - theBall.getRadius() + 1 <= getLeft() + getWidth() + 1
				&& theBall.getX() - theBall.getRadius() + 1 >= getLeft() + getWidth() - 4
				&& theBall.getY()/* + theBall.getRadius() - 1*/ >= getTop() - 2
				&& theBall.getY()/* + theBall.getRadius() - 1*/ <= getTop() + getHeight() + 1)
				//	<= getTop() + getHeight() - 2 + (2 * theBall.getRadius()))
		{
			return TouchPosition.RIGHT;
		}
		else if (theBall.getX() + theBall.getRadius() - 1 >= getLeft() - 1
				&& theBall.getX() + theBall.getRadius() - 1 <= getLeft() + 4
				&& theBall.getY()/* + theBall.getRadius() - 1 */ >= getTop() - 2
				&& theBall.getY()/* + theBall.getRadius() - 1 */ <= getTop() + getHeight() + 1)
				//	<= getTop() + getHeight() - 2 + (2 * theBall.getRadius()))
		{
			return TouchPosition.LEFT;
		}
		else
		{
			return TouchPosition.NONE;
		}
	}
}
