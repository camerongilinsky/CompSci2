package hospital.test;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import hospital.exceptions.EmptyWaitingRoomException;
import hospital.exceptions.InvalidConditionException;
import hospital.exceptions.InvalidPriorityException;
import hospital.model.EmergencyConditions;
import hospital.model.Patient;
import hospital.model.WaitingRoom;

public class EmergencyConditionsTests {

	@Test
	public void constructorTest()
	{
		try
		{
			EmergencyConditions a = new EmergencyConditions("conditions.cfg");
			assertEquals(a.lookup("Stomach Pain"), 3);
		}
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
		
		assertEquals(EmergencyConditions.timeThreshold(1), 0);
		assertEquals(EmergencyConditions.timeThreshold(2), 10);
		assertEquals(EmergencyConditions.timeThreshold(3), 60);
		assertEquals(EmergencyConditions.timeThreshold(4), 120);
		assertEquals(EmergencyConditions.timeThreshold(5), 240);
		
		
		
		
	}
	
	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	@Test
	public void invalidTimeThreshold()
	{
		thrown.expect(InvalidPriorityException.class);
		EmergencyConditions.timeThreshold(6);
	
	}
	
	@Rule
	public ExpectedException thrown1 = ExpectedException.none();
	
	@Test
	public void invalidConditionExceptionTest()
	{
		try
		{
			EmergencyConditions a = new EmergencyConditions("conditions.cfg");
			assertEquals(a.lookup("asdfjkl"), 3);
			thrown1.expect(InvalidConditionException.class);
		}
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch (InvalidConditionException ice)
		{
			System.out.println("Unsuccess");
		}
		
	}
	
	

}
