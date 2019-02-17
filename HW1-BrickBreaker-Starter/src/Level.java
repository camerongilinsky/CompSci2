// COURSE: CSCI1620
// TERM: Spring 2019
//
// NAME: Cameron Gilinsky and Carter Kennell
// RESOURCES: Piazza discussion board posts by the students and instructors for this class,
//            found at https://piazza.com/class/jqiqv19pp2w4sw?cid=5

/**
 * This class models a basic game level in the brick breaker game. It allows for the creation of
 * new levels, simulation of game steps, and retrieval of current state information. All levels
 * contain a grid of 5 rows and 7 columns of Bricks (some of which may have been broken),
 * a single Ball, and a single Paddle.
 * @author bdorn
 */
public class Level
{
	/**
	 * The height at which the Paddle will be from the bottom of the Level.
	 */
	private static final int PADDLE_OFFSET = 20;
	
	/**
	 * The height at which the top row of Bricks will be from the top of the Level.
	 */
	private static final int BRICK_OFFSET_Y = 40;
	
	/**
	 * The width at which the left row of Bricks will be from the top of the Level.
	 */
	private static final int BRICK_OFFSET_X = 10;
	
	/**
	 * The vertical separation distance between the top of each Brick.
	 */
	private static final int BRICK_SEPARATION_Y = 25;
	
	/**
	 * The horizontal separation distance between the left side of each Brick.
	 */
	private static final int BRICK_SEPARATION_X = 55;
	
	/**
	 * The size of the Level in pixels.
	 */
	private int width, height;
	
	/**
	 * The Ball to be used.
	 */
	private Ball theBall;
	
	/**
	 * The Paddle to be used.
	 */
	private Paddle thePaddle;
	
	/**
	 * The Bricks to be used.
	 */
	private Brick[][] theBricks = new Brick[5][7];
	
	/**
	 * Creates a default level with a given dimension. The default brick configuration is a 5 row and
	 * 7 column grid of Brick objects, each which requires 3 hits to break. Bricks are arranged starting
	 * 40 pixels from the top edge of the screen and 10 pixels from the left edge of the screen. Bricks
	 * should be spaced with 5 pixels between each Brick in both dimensions. The Ball will start in the
	 * center of the screen, and the Paddle's top-left edge should be positioned at the left
	 * edge and 20 pixels up from the bottom of the screen.
	 * @param widthIn is the logical width of the new level in pixels.
	 * @param heightIn is the logical height of the new level in pixels.
	 */
	public Level(int widthIn, int heightIn)
	{
		width = widthIn;
		height = heightIn;
		theBall = new Ball(width / 2, height / 2);
		thePaddle = new Paddle(0, height - PADDLE_OFFSET);
		for (int i = 0; i < 5; i++)
		{
			for (int j = 0; j < 7; j++)
			{
				theBricks[i][j] = new Brick(BRICK_OFFSET_Y + i * BRICK_SEPARATION_Y,
						BRICK_OFFSET_X + j * BRICK_SEPARATION_X, 3);
				theBricks[i][j].getColor();
			}
		}
	}
	
	/**
	 * Creates a level with a given dimension and specified brick configuration. The Brick configuration
	 * is specified through an array of String values where each character corresponds to a single Brick.
	 * This array of Strings is guaranteed to contain 5 valid Strings, each of which will have 7 characters.
	 * Characters in the string will correspond to one value in {'*', '0', '1', '2', '3'} where: 
	 * '*' signifies a brick that cannot be broken 
     * '0' signifies a "ghost brick" that is already broken 
     * '1' signifies a brick that requires one hit to break 
     * '2' signifies a brick that requires two hits to break 
     * '3' signifies a brick that requires three hits to break 
     * Input strings are assumed valid and no error checking is provided.
     * Bricks are arranged starting 40 pixels from the top edge of the screen and 10 pixels from the left edge of
     * the screen. Bricks should be spaced with 5 pixels between each Brick in both dimensions.
     * The Ball will start in the center of the screen, and the Paddle's top-left edge should be positioned at the left
     * edge and 20 pixels up from the bottom of the screen.
	 * @param widthIn is the logical width of the new level in pixels.
	 * @param heightIn is the logical height of the new level in pixels.
	 * @param brickConfig is the configuration array specifying the grid of Bricks to use in this new level.
	 */
	public Level(int widthIn, int heightIn, String[] brickConfig)
	{
		width = widthIn;
		height = heightIn;
		theBall = new Ball(width / 2, height / 2);
		thePaddle = new Paddle(0, height - PADDLE_OFFSET);
		for (int i = 0; i < 5; i++)
		{
			char[] brickConfigChar = brickConfig[i].toCharArray();
			
			for (int j = 0; j < 7; j++)
			{
				int hitStart;
				
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
				
				theBricks[i][j] = new Brick(BRICK_OFFSET_Y + i * BRICK_SEPARATION_Y,
						BRICK_OFFSET_X + j * BRICK_SEPARATION_X, hitStart);
				
				theBricks[i][j].getColor();
			}
		}
		
	}
	
	/**
	 * Retrieves the Ball object in this Level.
	 * @return the Ball used in the model.
	 */
	public Ball getBall()
	{
		return theBall;
	}
	
	/**
	 * Retrieves the Paddle object in this Level.
	 * @return the Paddle used in the model.
	 */
	public Paddle getPaddle()
	{
		return thePaddle;
	}
	
	/**
	 * Retrieves a 5 by 7 array of Brick objects corresponding to the current grid of
	 * Bricks in the model.
	 * @return data for the Bricks in the game level.
	 */
	public Brick[][] getBricks()
	{
		return theBricks;
	}
	
	/**
	 * Retrieves state information about the game's current progress based on the last
	 * simulated step.
	 * @return the appropriate state if the user has WON or LOST the game. If neither,PLAYING will be reported.
	 */
	public GameState getGameStatus()
	{
		boolean won = true;
		GameState gS;
		
		for (int i = 0; i < 5; i++)
		{
			for (int j = 0; j < 7; j++)
			{
				if (theBricks[i][j].getStrength() > 0)
				{
					won = false;
				}
			}
		}
		
		if (theBall.getY() > thePaddle.getTop() + thePaddle.getHeight())
		{
			gS = GameState.LOST;
		}
		else if (won)
		{
			gS = GameState.WON;
		}
		else
		{
			gS = GameState.PLAYING;
		}
		
		return gS;
	}
	
	/**
	 * This method updates this level's model data based on simulating one timestep in the game.
	 * Specifically the following will occur: 
	 * (1) The ball will be moved based on its last known trajectory, 
	 * (2) The ball will bounce off the side walls of the screen horizontally if hitting the
	 *     left or right sides, and vertically if hitting the top. 
	 * (3) The ball will bounce in the appropriate direction off the paddle if they are touching 
	 * (4) The ball will bounce in the appropriate direction off any Brick it is currently touching
	 *     and the Brick will react as required when hit by a Ball. 
	 * (5) The end game state (won or lost) will be updated if all possible Bricks are broken or theBal
	 *     hits the bottom of the screen, respectively.
	 */
	public void updateOneStep()
	{
		
		
		if (horizontalBounce()
				|| touchingRight()
				|| touchingLeft())
		{
			theBall.bounceHorizontal();
			theBall.moveOnce();
		}
		else if (verticalBounce()
				|| touchingBottom()
				|| touchingTop())
		{
			theBall.bounceVertical();
			theBall.moveOnce();
		}
		else
		{
			theBall.moveOnce();
		}
		

	}
	
	/**
	 * Determines if the Ball touching the bottom of a Brick.
	 * @return whether or not the Ball is touching the bottom of a Brick.
	 */
	public boolean touchingBottom()
	{
		boolean touchingBottom = false;
		
		for (int i = 0; i < 5; i++)
		{
			for (int j = 0; j < 7; j++)
			{
				if (theBricks[i][j].getStrength() != 0
						&& theBricks[i][j].isTouching(theBall) == TouchPosition.BOTTOM)
				{
					touchingBottom = true;
					theBricks[i][j].hit();
					theBricks[i][j].getColor();
					break;
				}
			}
		}
		
		return touchingBottom;
	}
	
	/**
	 * Determines if the Ball touching the top of a Brick.
	 * @return whether or not the Ball is touching the top of a Brick.
	 */
	public boolean touchingTop()
	{
		boolean touchingTop = false;
		
		for (int i = 0; i < 5; i++)
		{
			for (int j = 0; j < 7; j++)
			{
				if (theBricks[i][j].getStrength() != 0
						&& theBricks[i][j].isTouching(theBall) == TouchPosition.TOP)
				{
					touchingTop = true;
					theBricks[i][j].hit();
					theBricks[i][j].getColor();
					break;
				}
			}
		}
		
		return touchingTop;
	}
	
	/**
	 * Determines if the Ball touching the left side of a Brick.
	 * @return whether or not the Ball is touching the left side of a Brick.
	 */
	public boolean touchingLeft()
	{
		boolean touchingLeft = false;
		
		for (int i = 0; i < 5; i++)
		{
			for (int j = 0; j < 7; j++)
			{
				if (theBricks[i][j].getStrength() != 0
						&& theBricks[i][j].isTouching(theBall) == TouchPosition.LEFT)
				{
					touchingLeft = true;
					theBricks[i][j].hit();
					theBricks[i][j].getColor();
					break;
				}
			}
		}
		
		return touchingLeft;
	}
	
	/**
	 * Determines if the Ball touching the right side of a Brick.
	 * @return whether or not the Ball is touching the right side of a Brick.
	 */
	public boolean touchingRight()
	{
		boolean touchingRight = false;
		
		for (int i = 0; i < 5; i++)
		{
			for (int j = 0; j < 7; j++)
			{
				if (theBricks[i][j].getStrength() != 0
						&& theBricks[i][j].isTouching(theBall) == TouchPosition.RIGHT)
				{
					touchingRight = true;
					theBricks[i][j].hit();
					theBricks[i][j].getColor();
					break;
				}
			}
		}
		
		return touchingRight;
	}
	
	/**
	 * Determines if the ball needs to bounce horizontally.
	 * @return whether or not the Ball will bounce horizontally.
	 */
	public boolean horizontalBounce()
	{
		return theBall.getX() + theBall.getRadius() == width - 1
				|| theBall.getX() - theBall.getRadius() == 1
				|| theBall.getX() == 0
				|| theBall.getX() == width - 1
				|| thePaddle.isTouching(theBall) == TouchPosition.LEFT
				|| thePaddle.isTouching(theBall) == TouchPosition.RIGHT;
	}
	
	/**
	 * Determines if the ball needs to bounce vertically.
	 * @return whether or not the Ball will bounce vertically.
	 */
	public boolean verticalBounce()
	{
		return theBall.getY() - theBall.getRadius() + 1 <= 7
				|| theBall.getY() == 0
				|| thePaddle.isTouching(theBall) == TouchPosition.TOP;
	}
}
