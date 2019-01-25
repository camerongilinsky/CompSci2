import javafx.scene.paint.Color;

public class Level
{
	private int width, height;
	private int x, y;
	private Ball theBall;
	private Paddle thePaddle;
	private Brick[][] theBricks = new Brick[5][7];
	
	//constructor
	public Level(int widthIn, int heightIn)
	{
		width = widthIn;
		height = heightIn;
		theBall = new Ball(widthIn / 2, heightIn/2);
		thePaddle = new Paddle(0, heightIn - 20);
		for (int i = 0; i < 5; i++)
		{
			for (int j = 0; j < 7; j++)
			{
				theBricks[i][j] = new Brick(40 + i*25, 10 + j*55, 3);
				theBricks[i][j].getColor();
			}
		}
	}
	
	public Level(int widthIn, int heightIn, String[] brickConfig)
	{
		width = widthIn;
		height = heightIn;
		theBall = new Ball(widthIn / 2, heightIn/2);
		thePaddle = new Paddle(0, heightIn - 20);
		for (int i = 0; i < 5; i++)
		{
			for (int j = 0; j < 7; j++)
			{
				theBricks[i][j] = new Brick(40 + i*25, 10 + j*55, Integer.parseInt(brickConfig[j].substring(i)));
																//brickConfig[j].substring(i, i+1);
				theBricks[i][j].getColor();
				
				
				//bricks are 20Hx50W and start at 40 from top and 10 from left
				//5 pixels of sep in each direction
				//  40,10 40,65 40,120 40,175 40,230 40,285 40,340
				//  65,10
				//  90,10
				// 115,10
				// 140,10
				
				/*	[32*02]
				    [1232*]
				    [32132]
				    4
				    4
				    4
				    4
				*/
			}
		}
		
	}
	
	//method
	
	public Ball getBall()
	{
		return theBall;
	}
	
	public Paddle getPaddle()
	{
		return thePaddle;
	}
	public Brick[][] getBricks()
	{
		return theBricks;
	}
	
	public GameState getGameStatus()
	{
		if (theBall.getY() > thePaddle.getTop() + thePaddle.getHeight())
		{
			return GameState.LOST;
		}
		else if (theBricks[x][y].getColor() == Color.WHITE)
		{
			return GameState.WON;
		}
		else
		{
			return GameState.PLAYING;
		}
		
	}
	
	public void updateOneStep()
	{
		boolean touchingTopOrBottom = false;
		boolean touchingLeftOrRight = false;
		
		//theBall.moveOnce();
		

		
		
		/*for (int i = 0; i < 5; i++)
		{
			for (int j = 0; j < 7; j++)
			{
				if (theBricks[i][j].isTouching(theBall) == TouchPosition.TOP 
						|| theBricks[i][j].isTouching(theBall) == TouchPosition.BOTTOM)
				{
					touchingTopOrBottom = true;
					break;
				}
				else if (theBricks[i][j].isTouching(theBall) == TouchPosition.RIGHT
						|| theBricks[i][j].isTouching(theBall) == TouchPosition.LEFT)
				{
					touchingLeftOrRight = true;
					break;
				}
			}
		}*/
		if (theBall.getX() + theBall.getRadius() == width - 1 || theBall.getX() - theBall.getRadius() == 1)
		{
			theBall.bounceHorizontal();
			theBall.moveOnce();
		}
	/*	else if (theBall.getY() == height - 75)
		{
			theBall.bounceVertical();
		}*/
		else if (touchingTopOrBottom)
		{
			theBall.bounceVertical();
			theBall.moveOnce();
		}
		else if (touchingLeftOrRight)
		{
			theBall.bounceHorizontal();
			theBall.moveOnce();
		}
		else if (theBall.getY() == 0)
		{
			theBall.bounceVertical();
			theBall.moveOnce();
		}
		else if (theBall.getX() == 0 || theBall.getX() == width - 1)
		{
			theBall.bounceHorizontal();
			theBall.moveOnce();
		}
		else if (thePaddle.isTouching(theBall) == TouchPosition.TOP)
		{
			theBall.bounceVertical();
			theBall.moveOnce();
		}
		else if (thePaddle.isTouching(theBall) == TouchPosition.LEFT
				|| thePaddle.isTouching(theBall) == TouchPosition.RIGHT)
		{
			theBall.bounceHorizontal();
			theBall.moveOnce();
		}
		else
		{
			theBall.moveOnce();
		}
		
	}
}
