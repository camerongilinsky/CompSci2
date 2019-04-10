public class Testing {

	public static void main(String[] args)
	{
		/*
		String dateIn = "11/11/2018";
		
		String[] monthDayYear = dateIn.split("/", 3);
		System.out.printf("%s / %s / %s\n", monthDayYear[0],monthDayYear[1], monthDayYear[2]);
		int month = Integer.parseInt(monthDayYear[0]);
		int day = Integer.parseInt(monthDayYear[1]);
		int year = Integer.parseInt(monthDayYear[2]);
		
		System.out.printf("%s ; %s ; %s", month, day, year);
		System.out.print(monthDayYear[2]);
		*/
		String name = "Gilinsky, Cameron";
		String temp = String.format("%-25s", name);
		System.out.println(temp);
	}
	
	public void setDate(String dateIn)
	{

	}
	

}
