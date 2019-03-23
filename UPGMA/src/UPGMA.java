public class UPGMA
{
	public static void main(String[] args)
	{
		double[][] mat =
		{
			{0, 2.5, 10.44, 4.12, 11.75},
			{0, 0, 12.5, 6.4, 13.93},
			{0, 0, 0, 6.48, 1.41},
			{0, 0, 0, 0, 7.35},
			{0, 0, 0, 0, 0}
		};

		
		
		
		for (int i = 0; i < 5; i++)
		{
			for (int j = 0; j < 5; j++)
			{
				System.out.printf("%6.2f ", mat[i][j]);
			}
			System.out.print("\n");
		}
		
		double firstMinimum = getMinimumValue(mat);
		

		System.out.println(getMinimumValue(mat));
		System.out.printf("%d,%d\n", getMinValRow(mat), getMinValColumn(mat));
		//String.format("(" + rowIndex + 1, args)
		mat = deleteRowAndColumn(mat,getMinValRow(mat), getMinValColumn(mat));
		
		for (int i = 0; i < 4; i++)
		{
			for (int j = 0; j < 4; j++)
			{
				System.out.printf("%6.2f ", mat[i][j]);
			}
			System.out.print("\n");
		}
	}
	
    public static double getMinimumValue(double[][] input)
    {
        double minimumValue = input[0][1];
        for (int j = 0; j < input.length; j++)
        {
            for (int i = 0; i < input[j].length; i++)
            {
                if (input[j][i] < minimumValue && input[j][i] != 0)
                {
                    minimumValue = input[j][i];
                }
            }
        }
        return minimumValue;
    }
    
	//find row index of minimum value
    public static int getMinValRow(double[][] input)
    {
		int rowIndex = 0;
		
		for (int i = 0; i < input.length; i++)
		{
			for (int j = 0; j < input.length; j++)
			{
				if (input[i][j] == getMinimumValue(input))
				{
					rowIndex = i;
					break;
				}
			}
		}
		
		return rowIndex;
    }
    
	//find row column of minimum value
    public static int getMinValColumn(double[][] input)
    {
		int columnIndex = 0;
		
		for (int i = 0; i < input.length; i++)
		{
			for (int j = 0; j < input.length; j++)
			{
				if (input[i][j] == getMinimumValue(input))
				{
					columnIndex = j;
					break;
				}
			}
		}
		
		return columnIndex;
    }
    
    public static double[][] deleteRowAndColumn(double[][] input, int rowToDelete, int columnToDelete)
    {
    	double[][] newArray = new double[input.length - 1][input.length - 1];
    	
    	
    	int newRows = 0;
    	int newColumns = 0;
    	
    	for (int i = 0; i < input.length - 1; i++)
    	{
    		for (int j = 0; j < input.length - 1; j++)
    		{
    			if (i != rowToDelete && j != columnToDelete)
    			{
    				newArray[newRows][newColumns] = input[i][j];
    				
    			}
    			newColumns++;
    		}
    	}
    	
    	return newArray;
    }
}
