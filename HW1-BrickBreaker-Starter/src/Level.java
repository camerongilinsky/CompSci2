
public class Level
{
	private int width, height;
	private Ball theBall;
	
	//constructor
	public Level(int widthIn, int heightIn)
	{
		width = widthIn;
		height = heightIn;
	}
	
	public Level(int widthIn, int heightIn, String brickConfig)
	{
		width = widthIn;
		height = heightIn;
	}
	
	//method
	
	public Ball getBall()
	{
		return theBall;
	}
	
	public Brick[][] getBricks()
	{
		
	}
}
