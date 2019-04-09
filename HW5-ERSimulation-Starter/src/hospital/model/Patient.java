// COURSE: CSCI1620
// TERM: Spring 2019
//
// NAME: Cameron Gilinsky and Carter Kennell
// RESOURCES: Piazza discussion board posts by the
//				students and instructors for this class.

package hospital.model;

import java.io.Serializable;

/**
 * This class encapsulates information for Patients within our hospital management system.
 * It stores data about a patient, their reason for coming to the ER, and the time at which
 * they arrived. Priority and time information is used to enable comparisons between Patients
 * to determine who should be seen next by a doctor per our ER's triage rules.
 * @author ckgilinsky and ckennell
 */
public class Patient implements Comparable<Patient>, Serializable
{
	/**
	 * The patient's name.
	 */
	private String name;
	
	/**
	 * The patient's condition.
	 */
	private String condition;
	
	/**
	 * The current time.
	 */
	private int time;
	
	/**
	 * The priority according to the given triage rules.
	 */
	private int priority;
	
	
	/**
	 * Constructs a new Patient object based on the provided parameter information. The constructor
	 * assumes that all provided parameter values (including condition and priority information) are valid
	 * within the system. Thus, the code which creates Patient objects must verify the data provided
	 * conforms to the specified requirements.
	 * @param nameIn The Patient's name provided in "Last, First" format.
	 * @param conditionIn The primary complaint or reason for the ER visit. Valid field values are those
	 * 		  contained in the hospital configuration file.
	 * @param currentTime A numeric timestamp for when this Patient is created within the system. Timestamps
	 * 		  are integer values for the number of minutes since data collection began.
	 * @param priorityIn A numeric triage priority value between 1 and 5, inclusive based on the Patient's
	 * 		  condition. The constructor assumes that range checking and correctness of values
	 * 		  is done by the calling method.
	 */
	public Patient(String nameIn, String conditionIn,
			int currentTime, int priorityIn)
	{
		name = nameIn;
		condition = conditionIn;
		time = currentTime;
		priority = priorityIn;
	}
	
	/**
	 * Retrieves the time (in minutes) of when this Patient was created in the system. A timestamp of 0
	 * signifies that the Patient arrived immediately upon data collection starting.
	 * @return The timestamp corresponding to arrival.
	 */
	public int getTimeArrived()
	{
		return time;
	}
	
	/**
	 * Retrieves the name of the Patient in "Last, First" format.
	 * @return The Patient's name.
	 */
	public String getName()
	{
		return name;
	}
	
	/**
	 * Retrieves the condition for which this Patient came to the ER.
	 * @return The Patient's complaint or condition.
	 */
	public String getCondition()
	{
		return condition;
	}
	
	
	/**
	 * The numeric priority assigned to this Patient upon arrival at the ER.
	 * This value will always be between 1 and 5 inclusive, with 1 representing
	 * the highest priority.
	 * @return This Patient's priority rating.
	 */
	public int getPriority()
	{
		return priority;
	}
	
	/**
	 * Retrieves a string representation of this Patient's details suitable for printing
	 * or reporting. Results take the format shown below, with values in [ALL CAPS] or [#] showing
	 * fields that would be replaced with the actual Patient's data. Patient names and conditions are displayed in
	 * a 25 character wide, left aligned fields. Priorities are displayed in a 3 character wide, left aligned field.
	 * Wait times should be displayed left aligned in a variable width field based on the number of digits in
	 * the number. One additional space should separate all fields and labels.
	 * 
	 * Patient: [LAST, FIRST            ] Condition: [COMPLAINT              ] Priority: [#] Waiting Since: [#]
	 * 
	 * For example:
	 * 
	 * Patient: Darr, Dexter              Condition: Minor Bleeding            Priority: 4   Waiting Since: 9
	 * 
	 * Result strings are not terminated with a new line.
	 */
	@Override
	public String toString()
	{
		return "";
	}
	
	/**
	 * Compares this Patient to the one specified in the other parameter based on a two-tier priority ordering
	 * of Patients. Patient A is considered "less than" Patient B when A's priority a smaller number than B's
	 * (i.e. they have a more urgent emergency and should be seen first). Should Patient A and Patient B have
	 * the same priority health condition, then the one who has been waiting longer should be seen first.
	 * @param other The Patient to compare to for ordering.
	 * @return -1 if this Patient should be seen before the other Patient. 1 if the other patient should be seen
	 * 		   first. 0 if there is no preference (ie, both Patients have the same priority and wait time).
	 */
	@Override
	public int compareTo(Patient other)
	{
		return 0;
	}
}
