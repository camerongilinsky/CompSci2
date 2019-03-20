import java.util.Arrays;

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

	}

}
