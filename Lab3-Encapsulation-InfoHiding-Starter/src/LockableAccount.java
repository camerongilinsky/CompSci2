// COURSE: CSCI1620
// TERM: Spring 2019
//
// NAME: Cameron Gilinsky
// RESOURCES: Piazza discussion board posts by the students and instructors for this class,
//            found at https://piazza.com/class/jqiqv19pp2w4sw?cid=5
//            and Oracle's online Java documentation for the String.valueOf() method.

/**
 * Emulates a simple account with basic information and the ability to be locked and unlocked. An unlocked account shows
 * all information while a locked account will hide many of the details. This demonstrates how encapsulation can be used
 * to implement information hiding; as class designers we have full control over what information can be accessed, how
 * it is accessed, and how it is altered.
 * @author Cameron Gilinsky (ckgilinsky)
 */
public class LockableAccount
{
	/**
	 * The maximum value an account number can be.
	 */
	private static final int ACCOUNT_NUM_MAX = 9999;
	
	/**
	 * The minimum value an account number can be.
	 */
	private static final int ACCOUNT_NUM_MIN = 1000;
	
	/**
	 * The account number for the account.
	 */
	private int accountNumber;
	
	/**
	 * The user's email address.
	 */
	private String emailAddress;
	
	/**
	 * Whether the account is locked or not. True is locked, false is unlocked.
	 */
	private boolean locked;
	
	/**
	 * Any notification the user may have; if this value is null then there is no notification.
	 */
	private String notification;
	
	/**
	 * The user's password.
	 */
	private String password;
	
	/**
	 * The user name for the account.
	 */
	private String userName;
	
	
	/**
	 * Constructor used to create a new LockableAccount.
	 * @param userNameIn is the account's user name.
	 * @param accountNumberIn is the requested account number for the account.
	 * 		  If input value is invalid, this will be set to -1.
	 * @param emailAddressIn is the account's email address.
	 * @param passwordIn is the account's password.
	 */
	public LockableAccount(String userNameIn, int accountNumberIn, String emailAddressIn, String passwordIn)
	{
		userName = userNameIn;

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
	
	/**
	 * Sets the notification of the account.
	 * @param notificationIn is the notification to be set.
	 */
	public void addNotification(String notificationIn)
	{
		notification = notificationIn;
	}
	
	/**
	 * Returns the account number; the String returned depends on the locked state of
	 * the account and if the account number is valid. If the account number is invalid
	 * returns the String "Invalid account number,please contact customer support" whether
	 * or not the account is unlocked. If the account number is valid and the account is
	 * unlocked it will return the account number as a String; if the account is locked
	 * it will return asterisks in place of the digits.
	 * @return the full or partially hidden account number.
	 */
	public String getAccountNumberString()
	{
		String setAccountNumber;
		
		if (!locked)
		{
			if (accountNumber == -1)
			{
				setAccountNumber = "Invalid account number, please contact customer support";
			}
			else
			{
				setAccountNumber = Integer.toString(accountNumber);
			}
		}
		else
		{
			if (accountNumber == -1)
			{
				setAccountNumber = "Invalid account number, please contact customer support";
			}
			else
			{
				int asterisksLength = Integer.toString(accountNumber).length();
				char[] asterisks = new char[asterisksLength];
				int i = 0;
				while (i < asterisksLength)
				{
					asterisks[i] = '*';
					i++;
				}
				setAccountNumber = String.valueOf(asterisks);
			}
		}
		
		return setAccountNumber;
	}
	
	/**
	 * Returns the account's email address; the String returned depends on the locked state
	 * of the account. If the account is not locked it will return the emailAddress as it is
	 * stored. If the account is locked the String will be the first character of the emailAddress
	 * with the remainder of the characters in the emailAddress as asterisks *.
	 * @return the full or partially hidden email.
	 */
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
	
	/**
	 * Returns the notification; the String returned depends on the locked state of the
	 * account and if there is a notification. If there is no notification returns the
	 * String "No notification".If there is a notification and the account is unlocked
	 * it will return the notification. If there is a notification and the account is
	 * locked it will return the String "You have a notification".
	 * @return the notification String.
	 */
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
	
	/**
	 * Locks the account.
	 */
	public void lock()
	{
		locked = true;
	}
	
	/**
	 * Attempts to set the account number to the requested value. If the passed value
	 * is between the account minimum and maximum inclusive, accountNumber will be set
	 * to the passed value. If the account number is not within the valid range,
	 * accountNumber will be set to -1 to denote an invalid account number.
	 * @param accountNumberIn is the account number requested.
	 */
	public void setAccountNumber(int accountNumberIn)
	{
		if (accountNumberIn >= ACCOUNT_NUM_MIN && accountNumberIn <= ACCOUNT_NUM_MAX)
		{
			accountNumber = accountNumberIn;
		}
		else
		{
			accountNumber = -1;
		}
	}
	
	/**
	 * Attempts to unlock the account with the passed password String. Only if the
	 * passed password matches theaccount's password the account will be unlocked by
	 * setting locked to false. Returns true if successfully unlocked, false otherwise.
	 * If the password passed is null it is treated the same as an incorrect password.
	 * @param passwordIn is the password to attempt to unlock the account.
	 * @return whether or not the account is unlocked.
	 */
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
