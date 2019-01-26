/**
 * Emulates a simple account with basic information and the ability to be locked and unlocked. An unlocked account shows
 * all information while a locked account will hide many of the details. This demonstrates how encapsulation can be used
 * to implement information hiding; as class designers we have full control over what information can be accessed, how
 * it is accessed, and how it is altered.
 */
public class LockableAccount
{
	
	private static final int ACCOUNT_NUM_MAX = 9999;
	private static final int ACCOUNT_NUM_MIN = 1000;
	private int accountNumber;
	private String emailAddress;
	private boolean locked; //T = locked, F = unlocked
	private String notification;
	private String password;
	private String userName;
	
	//Constructor goes here
	
	public LockableAccount(String userNameIn, int accountNumberIn, String emailAddressIn, String passwordIn)
	{
		//if (userNameIn == null)
		//{
			userName = userNameIn;
		//}
		//else
		//{
		//	userName = "1";
		//}
		if (accountNumberIn >= ACCOUNT_NUM_MIN && accountNumberIn <= ACCOUNT_NUM_MAX)
		{
			accountNumber = accountNumberIn;
		}
		else
		{
			accountNumber = -1;
		}
		
		emailAddress = emailAddressIn;
		
		if (passwordIn != null)
		{
			password = passwordIn;
		}
		
		locked = true;
	}
	
	//Class methods go here
	
	public void addNotification(String notificationIn)
	{
		notification = notificationIn;
	}
	
	public String getAccountNumberString()
	{
		if (!locked)
		{
			if (accountNumber == -1)
			{
				return "Invalid account number, please contact customer support";
			}
			else
			{
				return Integer.toString(accountNumber);
			}
		}
		else
		{
			if (accountNumber == -1)
			{
				return "Invalid account number, please contact customer support";
			}
			else
			{
				int asterisksLength = Integer.toString(accountNumber).length();
				//String firstNum = Integer.toString(accountNumber);
				char[] asterisks = new char[asterisksLength];
				int i = 0;
				while (i < asterisksLength)
				{
					asterisks[i] = '*';
					i++;
				}
				String asterisksString = String.valueOf(asterisks);
				return new String(asterisksString);
			}
		}
	}
	
	public String getEmailAddress()
	{
		if (!locked)
		{
			return emailAddress;
		}
		else
		{
			int asterisksLength = emailAddress.length();
			char[] asterisks = new char[asterisksLength - 1];
			int i = 0;
			while (i < asterisksLength - 1)
			{
				asterisks[i] = '*';
				i++;
			}
			String asterisksString = String.valueOf(asterisks);
			return new String(emailAddress.substring(0, 1) + asterisksString);
		}
		
	}
	
	public String getNotification()
	{
		String notificationOut;
		
		if (notification == null)
		{
			notificationOut = "No notification";
		}
		else if (locked)
		{
			notificationOut = "You have a notification";
		}
		else
		{
			notificationOut = notification;
		}
		
		return notificationOut;
	}
	
	public void lock()
	{
		locked = true;
	}
	
	public void setAccountNumber(int accountNumberIn)
	{
		/*if (locked == false)
		{*/
			if (accountNumberIn >= ACCOUNT_NUM_MIN && accountNumberIn <= ACCOUNT_NUM_MAX)
			{
				accountNumber = accountNumberIn;
			}
			else
			{
				accountNumber = -1;
			}
			
		//}
		/*else
		{
			accountNumber = -1;
		}*/
	}
	
	public boolean unlock(String passwordIn)
	{
		if (passwordIn == password && passwordIn != null)
		{
			locked = false;
			return true;
			
		}
		else
		{
			locked = true;
			return false;
			
		}
	}
	
	//Do not change toString	
	/**
	 * Returns the information of the account; the String returned depends on the locked state of the account.
	 * If the account is unlocked it will clear the notification by setting it to null. Uses the getter methods
	 * for account number, email address, and notification to ensure the appropriate values are displayed
	 * depending on the locked state of the account.
	 * @return A String representing this account
	 */
	public String toString()
	{
		String out;
		
		if (locked)
		{
			out = "***LOCKED ACCOUNT***";
		}
		else
		{
			out = "***UNLOCKED ACCOUNT***";
		}
		out += String.format("\nUser Name: %s\nAccount Number: %s\nEmail Address: %s\n%s",
				userName, getAccountNumberString(), getEmailAddress(), getNotification());
			
		if (!locked)
		{
			notification = null;
		}
		
		return out;
	}
	
}
