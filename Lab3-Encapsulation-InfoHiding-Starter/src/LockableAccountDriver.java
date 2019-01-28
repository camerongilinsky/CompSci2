// COURSE: CSCI1620
// TERM: Spring 2019
//
// NAME: Cameron Gilinsky
// RESOURCES: Piazza discussion board posts by the students and instructors for this class,
//            found at https://piazza.com/class/jqiqv19pp2w4sw?cid=5
//            and Oracle's online Java documentation for the String.valueOf() method.

import java.util.Scanner;

/**
 * Driver to test your LockableAccount class.
 * @author Patrick Cavanaugh
 *
 */
public class LockableAccountDriver
{
	/**
	 * Scanner for retrieving input.
	 */
	private static Scanner input = new Scanner(System.in);
	
	/**
	 * Entry point for driver.
	 * @param args Not used.
	 */
	public static void main(String[] args)
	{
		//Create an account
		LockableAccount account = createAccount();
		String password;
		
		//Output locked account
		System.out.printf("\n%s\n\n", account);
		
		//Add a notification to the account
		System.out.println("ADDING A NOTIFICATION");
		account.addNotification("You have a meeting scheduled for today at 1:00");
		
		//Output account, still locked
		System.out.printf("\n%s\n\n", account);

		//Prompt until correct password entered
		do
		{
			System.out.print("Enter password: ");
			password = input.next();
		} while (!account.unlock(password));
		
		//Output unlocked account
		System.out.printf("\n%s\n\n", account);
		
		//Lock up the account
		System.out.println("LOCKING ACCOUNT");
		account.lock();
		
		//Output locked account
		System.out.printf("\n%s\n\n", account);
	}
	
	/**
	 * Get account details from user, create and return a new LockableAccount.
	 * @return The LockableAccount created from the user's input.
	 */
	public static LockableAccount createAccount()
	{
		String userName;
		int accountNumber;
		String emailAddress;
		String password;
		
		//Get account info
		System.out.print("Enter user name: ");
		userName = input.next();
		System.out.print("Enter account number: ");
		accountNumber = input.nextInt();
		System.out.print("Enter email address: ");
		emailAddress = input.next();
		System.out.print("Enter password: ");
		password = input.next();
		
		//Create and return the new LockableAccount
		return new LockableAccount(userName, accountNumber, emailAddress, password);
		
	}

}
