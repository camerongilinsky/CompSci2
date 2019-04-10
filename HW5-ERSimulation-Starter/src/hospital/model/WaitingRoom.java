// COURSE: CSCI1620
// TERM: Spring 2019
//
// NAME: Cameron Gilinsky and Carter Kennell
// RESOURCES: Piazza discussion board posts by the
//				students and instructors for this class.

package hospital.model;

import java.io.Serializable;
import java.util.ArrayList;

import hospital.exceptions.EmptyWaitingRoomException;

/**
 * This class abstracts details of an ER waiting room consisting of a list of Patients.
 * WaitingRoom objects provide an urgency-ordered view of the Patients consistent with
 * medical triage principles. More urgent patients will be placed in the list ahead
 * of less urgent patients.
 * @author ckgilinsky and ckennell
 */
public class WaitingRoom implements Serializable
{
	/**
	 * The ArrayList to be used to store Patient objects.
	 */
	private ArrayList<Patient> patients;
	
	/**
	 * Builds a new empty waiting room with no Patients.
	 */
	public WaitingRoom()
	{
		patients = new ArrayList<Patient>();
		
		//numPatients = 0 OR initialize empty array or ArrayList?
	}
	
	/**
	 * Adds a specified Patient to the waiting room while preserving the urgency-ordering
	 * of Patients based on the triage rules described by Patient.compareTo.
	 * @param sickPerson The newly arrived Patient to place in this WaitingRoom.
	 */
	public void addPatient(Patient sickPerson)
	{	
		for (int i = 0; i < patients.size(); i++)
		{
			if (sickPerson.compareTo(patients.get(i)) == 1
					|| sickPerson.compareTo(patients.get(i)) == 0)
			{
				continue;
			}
			
			if (sickPerson.compareTo(patients.get(i)) == -1)
			{
				patients.add(i, sickPerson);
				break;
			}
			else
			{
				patients.add(sickPerson);
				break;
			}
		}
	}
	
	/**
	 * Retrieves the next most-urgent person from the WaitingRoom. This method also removes the
	 * Patient from the WaitingRoom as they are now being seen by a physician.
	 * @return The most-urgent Patient object that was in the WaitingRoom.
	 * @throws EmptyWaitingRoomException when there are no patients waiting to be seen.
	 */
	public Patient getNextPatient() throws EmptyWaitingRoomException
	{
		if (patients.size() == 0)
		{
			throw new EmptyWaitingRoomException();
		}
		else
		{
			return patients.get(0);
		}
	}
	
	/**
	 * Retrieves the current total number of patients waiting in the WaitingRoom.
	 * @return The number of patients waiting.
	 */
	public int getNumWaiting()
	{
		return patients.size();
	}
	
	/**
	 * Produces a String containing details about the current status of this WaitingRoom. Data is formatted
	 * as shown below. Fields to be replaced with actual values are shown in [VALUE] notation.
	 * When no patients are waiting 
	 * 
	 * Waiting Room Status: EMPTY! 
	 * 
	 * When one or more patients are waiting 
	 * 
	 * Waiting Room Status: 
	 * [  #]) [FIRST PATIENT INFORMATION]
	 * [  #]) [SECOND PATIENT INFOMRATION]
	 * 
	 * Waiting room positions should be displayed in a 5 character wide,
	 * right aligned field followed by a right parenthesis and a
	 * single space character. Patient information is then presented
	 * per the toString format described in the Patient class. For example:
	 * 
	 * Waiting Room Status: 
	 *     1) Patient: Levy, Thomasine           Condition: Asthma                    Priority: 3   Waiting Since: 5
	 *     2) Patient: Figueroa, Francesco       Condition: High Fever                Priority: 3   Waiting Since: 8
	 *     3) Patient: Rakes, Raye               Condition: Minor Allergic Reaction   Priority: 3   Waiting Since: 9
	 *     4) Patient: Noles, Oliver             Condition: Low-grade Fever           Priority: 4   Waiting Since: 4
	 * 
	 * When one or more patients are shown in the status, the patient listed
	 * as #1 corresponds to thePatient that would be served next (assuming
	 * no additional Patients were added subsequently).
	 */
	@Override
	public String toString()
	{
		if (patients.size() == 0)
		{
			return "Waiting Room Status: EMPTY!";
		}
		else
		{
			String output = "";
			
			for (int i = 0; i < patients.size(); i++)
			{
				output += String.format("%5d) %s\n", i, patients.get(i).toString());
			}
			
			return output;
		}
	}
}
