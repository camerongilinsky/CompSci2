// COURSE: CSCI1620
// TERM: Spring 2019
//
// NAME: Cameron Gilinsky and Carter Kennell
// RESOURCES: Piazza discussion board posts by the students and instructors for this class,
//            found at https://piazza.com/class/jqiqv19pp2w4sw?cid=5

//import javafx.scene.paint.Color;



public class Level
{
	private int width, height;
	private Ball theBall;
	private Paddle thePaddle;
	private Brick[][] theBricks = new Brick[5][7];
	
	//constructor
	public Level(int widthIn, int heightIn)
	{
		width = widthIn;
		height = heightIn;
		theBall = new Ball(width / 2, height/2);
		thePaddle = new Paddle(0, height - 20);
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
		theBall = new Ball(width / 2, height / 2);
		thePaddle = new Paddle(0, height - 20);
		for (int i = 0; i < 5; i++)
		{
			char[] brickConfigChar = brickConfig[i].toCharArray();
			
			for (int j = 0; j < 7; j++)
			{
				int hitStart;
				//int value = Integer.parseInt(brickConfig[j].substring(j, j + 1));
				if (brickConfigChar[j] == '3')
				{
					hitStart = 3;
				}
				else if (brickConfigChar[j] == '2')
				{
					hitStart = 2;
				}
				else if (brickConfigChar[j] == '1')
				{
					hitStart = 1;
				}
				else if (brickConfigChar[j] == '0')
				{
					hitStart = 0;
				}
				else
				{
					hitStart = -1;
				}
				
				theBricks[i][j] = new Brick(40 + i*25, 10 + j*55, hitStart);
																//brickConfig[j].substring(i, i+1);
				theBricks[i][j].getColor();
			}
		}
		
	}
	
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
		boolean won = false;
		
		
		for (int j = 0; j < 7; j++)
		{
			if (theBricks[0][j].getStrength() != 0)
			{
				won = false;
				break;
			}
			else
			{
				won = true;
			}
				
		}
		
		if (theBall.getY() > thePaddle.getTop() + thePaddle.getHeight())
		{
			return GameState.LOST;
		}
		else if (won  /*theBricks[x][y].getColor() == Color.WHITE*/)
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
		boolean touchingTop = false;
		boolean touchingBottom = false;
		boolean touchingRight = false;
		boolean touchingLeft = false;

		for (int i = 0; i < 5; i++)
		{
			for (int j = 0; j < 7; j++)
			{
				if (theBricks[i][j].isTouching(theBall) == TouchPosition.BOTTOM
					&& theBricks[i][j].getStrength() != 0)
				{
					touchingBottom = true;
					theBricks[i][j].hit();
					theBricks[i][j].getColor();
				}
				else if (theBricks[i][j].isTouching(theBall) == TouchPosition.TOP
					&& theBricks[i][j].getStrength() != 0)
				{
					touchingTop = true;
					theBricks[i][j].hit();
					theBricks[i][j].getColor();
				}
				else if (theBricks[i][j].isTouching(theBall) == TouchPosition.RIGHT
					&& theBricks[i][j].getStrength() != 0)
				{
					touchingRight = true;
					theBricks[i][j].hit();
					theBricks[i][j].getColor();
				}
				else if (theBricks[i][j].isTouching(theBall) == TouchPosition.LEFT
					&& theBricks[i][j].getStrength() != 0)
				{
					touchingLeft = true;
					theBricks[i][j].hit();
					theBricks[i][j].getColor();
				}
			}
		}
		
		if (theBall.getX() + theBall.getRadius() == width - 1
				|| theBall.getX() - theBall.getRadius() == 1
				|| touchingRight
				|| touchingLeft
				|| theBall.getX() == 0
				|| theBall.getX() == width - 1
				|| thePaddle.isTouching(theBall) == TouchPosition.LEFT
				|| thePaddle.isTouching(theBall) == TouchPosition.RIGHT)
		{
			theBall.bounceHorizontal();
			theBall.moveOnce();
		}
		else if (theBall.getY() - theBall.getRadius() + 1 <= 7
				|| touchingBottom
				|| touchingTop
				|| theBall.getY() == 0
				|| thePaddle.isTouching(theBall) == TouchPosition.TOP)
		{
			theBall.bounceVertical();
			theBall.moveOnce();
		}
		else
		{
			theBall.moveOnce();
		}
	}
}
