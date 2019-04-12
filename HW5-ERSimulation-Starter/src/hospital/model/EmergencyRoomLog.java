// COURSE: CSCI1620
// TERM: Spring 2019
//
// NAME: Cameron Gilinsky and Carter Kennell
// RESOURCES: Piazza discussion board posts by the
//				students and instructors for this class.

package hospital.model;

import java.io.Serializable;
import java.util.ArrayList;

import hospital.exceptions.EmptyLogException;
import hospital.exceptions.InvalidPriorityException;

/**
 * This class stores log information about Patients served by the EmergencyRoom
 * doctors. The log maintains state information about the current time
 * in the hospital and records time stamped patient activity. This class also
 * provides methods to compute performance data about the ER's wait times and
 * overall compliance with hospital-policy thresholds.
 * @author ckgilinsky and ckennell
 */
public class EmergencyRoomLog implements Serializable
{
	/**
	 * The clock to keep track of patient wait times.
	 */
	private int clock;
	
	/**
	 * The ArrayList to store patients in the log.
	 */
	private ArrayList<Patient> patients;
	
	/**
	 * The ArrayList to store the corresponding physicians when patients are entered.
	 */
	private ArrayList<String> physicians;
	
	/**
	 * The ArrayList to store the corresponding wait time when patients are entered.
	 */
	private ArrayList<Integer> waitTimes;
	
	/**
	 * Creates an empty ER Log. The log will initialize the ER
	 * clock to 0.
	 */
	public EmergencyRoomLog()
	{
		patients = new ArrayList<>();
		physicians = new ArrayList<>();
		waitTimes = new ArrayList<>();
		clock = 0;
	}
	
	/**
	 * Retrieves the current ER clock time, in minutes.
	 * @return The current time in the ER.
	 */
	public int getERClock()
	{
		return clock;
	}
	
	/**
	 * Increments the ER clock by one minute.
	 */
	public void incrementERClock()
	{
		clock++;
	}
	
	/**
	 * Enters a Patient into the EmergencyRoomLog when they have left the WaitingRoom.
	 * This method records the patient seen, the doctor that saw them, and internally
	 * records the time when this patient was seen based on the current ER clock time.
	 * @param thePatient The Patient being seen by the physician.
	 * @param seenBy The name of the physician treating the Patient in "Last, First" format.
	 */
	public void treatPatient(Patient thePatient, String seenBy)
	{
		patients.add(thePatient);
		physicians.add(seenBy);
		waitTimes.add(clock); // is this calculated some other way?
	}
	
	/**
	 * Retrieves the number of patients seen by a given physician since this EmergencyRoomLog
	 * was created.
	 * @param treatingPhysician The name of the doctor of interest in "Last, First" format.
	 * @return The total number of patients seen so far by the treatingPhysican in the log.
	 * Physicians are identified in a case sensitive manner.
	 * When null is specified as the treatingPhysician the total number of patients seen by all
	 * doctors will be returned.
	 */
	public int numPatientsSeenBy(String treatingPhysician)
	{
		int count = 0;
		
		if (treatingPhysician == null || treatingPhysician.equals(""))
		{
			count = patients.size();
		}
		else
		{
			for (int i = 0; i < physicians.size(); i++)
			{
				if (physicians.get(i).equals(treatingPhysician))
				{
					count++;
				}
			}
		}
		
		return count;
	}
	
	/**
	 * Retrieves the number of patients seen at a given priority level.
	 * @param priority The priority on which to filter results. If 0 the total will be for
	 * all patients seen. Priorities of 1-5 will retrieve the total for only
	 * patients with conditions matching the specified provided priority.
	 * @return The number of patients seen at the specified priority.
	 * @throws EmptyLogException when no data is present in the ER Log.
	 * @throws InvalidPriorityException when the specified priority is outside the range 0-5, inclusive
	 */
	public int numPatientsSeen(int priority)
	{
		try
		{
			if (priority < 0 || priority > 5)
			{
				throw new InvalidPriorityException();
			}
			else if (patients.size() == 0)
			{
				throw new EmptyLogException();
			}
			else
			{
			
				int count = 0;
				
				if (priority == 0)
				{
					count = physicians.size();
				}
				else
				{
					for (int i = 0; i < physicians.size(); i++)
					{
						if (patients.get(i).getPriority() == priority)
						{
							count++;
						}
					}
				}
				
				return count;
			}
		}
		catch (EmptyLogException ele)
		{
			throw new EmptyLogException();
		}
		catch (InvalidPriorityException ipe)
		{
			throw new InvalidPriorityException();
		}
	}
	
	/**
	 * Retrieves the average wait time patients seen thus far since opening the EmergencyRoomLog.
	 * The data may be optionally filtered based on the triage priority level.
	 * 
	 * Note: Patients still in a WaitingRoom do not factor into the these statistics.
	 * 
	 * @param priority The priority on which to filter results. If 0 the average will be for
	 * 		  all patients seen. Priorities of 1-5 will retrieve the average for only
	 * 		  patients with conditions matching the specified provided priority.
	 * @return The average wait time for the data specified.
	 * @throws EmptyLogException when no data is present in the ER Log.
	 * @throws InvalidPriorityException when the specified priority is outside the range 0-5, inclusive
	 */
	public double getAverageWaitTime(int priority)
	{
		try
		{
			if (priority < 0 || priority > 5)
			{
				throw new InvalidPriorityException();
			}
			else if (patients.size() == 0)
			{
				throw new EmptyLogException();
			}
			else
			{
				int total = 0;
				int count = 0;
				
				for (int i = 0; i < patients.size(); i++)
				{
					if (patients.get(i).getPriority() == priority || priority == 0)
					{
						total += waitTimes.get(i);
						count++;
					}
				}
				
				return (double) total / (double) count;
			}
		}
		catch (EmptyLogException ele)
		{
			throw new EmptyLogException();
		}
		catch (InvalidPriorityException ipe)
		{
			throw new InvalidPriorityException();
		}
	}
	
	/**
	 * Computes the number of patients in the EmergencyRoomLog whose total wait time prior to
	 * being seen exceeds the hospital specified thresholds for their priority level.
	 * @param priority The priority level of interest (1-5, inclusive)
	 * @return The total number of patients who waited more than the number of minutes specified
	 * 		   by the hospital's response threshold.
	 * @throws EmptyLogException when no data is present in the ER Log.
	 * @throws InvalidPriorityException when the specified priority is outside the range 1-5, inclusive
	 */
	public int numPatientsOverThreshold(int priority)
	{
		try
		{
			if (priority < 1 || priority > 5)
			{
				throw new InvalidPriorityException();
			}
			else if (patients.size() == 0)
			{
				throw new EmptyLogException();
			}
			else
			{
				int count = 0;
				
				for (int i = 0; i < patients.size(); i++)
				{
					if (priority == patients.get(i).getPriority()
						&& waitTimes.get(i) > EmergencyConditions.timeThreshold(priority))
					{
						count++;
					}
				}
				
				return count;
			}
		}
		catch (EmptyLogException ele)
		{
			throw new EmptyLogException();
		}
		catch (InvalidPriorityException ipe)
		{
			throw new InvalidPriorityException();
		}
	}
}