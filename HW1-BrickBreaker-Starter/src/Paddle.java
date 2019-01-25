
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
		if (theBall.getY() + theBall.getRadius() >= getTop()
				&& theBall.getX() >= getLeft()
				&& theBall.getX() <= getLeft() + WIDTH)
		{
			return TouchPosition.TOP;
		}
		else if (theBall.getX() - theBall.getRadius() == getLeft() + WIDTH
				&& theBall.getY() >= getTop()
				&& theBall.getY() <= getTop() + HEIGHT)
		{
			return TouchPosition.RIGHT;
		}
		else if (theBall.getX() + theBall.getRadius() == getLeft()
				&& theBall.getY() >= getTop()
				&& theBall.getY() <= getTop() + HEIGHT)
		{
			return TouchPosition.LEFT;
		}
		else
		{
			return TouchPosition.NONE;
		}
	}
}
