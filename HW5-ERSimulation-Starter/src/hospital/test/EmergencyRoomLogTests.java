package hospital.test;

import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import hospital.exceptions.EmptyLogException;
import hospital.exceptions.InvalidPriorityException;
import hospital.model.EmergencyConditions;
import hospital.model.EmergencyRoomLog;
import hospital.model.Patient;

public class EmergencyRoomLogTests {

	@Test
	public void constructorTest()
	{
		EmergencyRoomLog a = new EmergencyRoomLog();
		a.incrementERClock();
		assertEquals(1, a.getERClock());
		
		Patient b = new Patient("Gilinsky, Cameron", "Stomach Pain", 0, 3);
		a.treatPatient(b, "Kennell, Carter");
		
		assertEquals(1, a.numPatientsSeenBy("Kennell, Carter"));
		assertEquals(1, a.numPatientsSeenBy(null));
		
		assertEquals(1, a.numPatientsSeen(3));
		assertEquals(1, a.numPatientsSeen(0));
		assertEquals(1, a.getAverageWaitTime(3), 0.001);
		assertEquals(0, a.numPatientsOverThreshold(3));
	}
	
	@Test
	public void overThresholdTest()
	{
		EmergencyRoomLog a = new EmergencyRoomLog();
		Patient b = new Patient("Gilinsky, Cameron", "Stomach Pain", 0, 1);
		a.incrementERClock();
		a.incrementERClock();
		a.incrementERClock();
		a.treatPatient(b, "Kennell, Carter");
		assertEquals(1, a.numPatientsOverThreshold(1));
		
	}
	
	
	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	@Test
	public void priorityOutsideOfRangeTest()
	{
		thrown.expect(InvalidPriorityException.class);
		EmergencyRoomLog a = new EmergencyRoomLog();
		Patient b = new Patient("Gilinsky, Cameron", "Stomach Pain", 0, 3);
		a.treatPatient(b, "Kennell, Carter");
		a.numPatientsSeen(6);
	
	}

	
	@Rule
	public ExpectedException thrown1 = ExpectedException.none();
	
	@Test
	public void emptyLogTest()
	{
		thrown1.expect(EmptyLogException.class);
		EmergencyRoomLog a = new EmergencyRoomLog();
		a.numPatientsSeen(3);
	
	}
	
	@Rule
	public ExpectedException thrown2 = ExpectedException.none();
	
	@Test
	public void priorityOutsideOfRangeTest2()
	{
		thrown2.expect(InvalidPriorityException.class);
		EmergencyRoomLog a = new EmergencyRoomLog();
		Patient b = new Patient("Gilinsky, Cameron", "Stomach Pain", 0, 3);
		a.treatPatient(b, "Kennell, Carter");
		a.getAverageWaitTime(6);
	
	}
	
	@Rule
	public ExpectedException thrown3 = ExpectedException.none();
	
	@Test
	public void emptyLogTest2()
	{
		thrown3.expect(EmptyLogException.class);
		EmergencyRoomLog a = new EmergencyRoomLog();
		a.getAverageWaitTime(3);
	
	}
	
	@Rule
	public ExpectedException thrown4 = ExpectedException.none();
	
	@Test
	public void priorityOutsideOfRangeTest3()
	{
		thrown4.expect(InvalidPriorityException.class);
		EmergencyRoomLog a = new EmergencyRoomLog();
		Patient b = new Patient("Gilinsky, Cameron", "Stomach Pain", 0, 3);
		a.treatPatient(b, "Kennell, Carter");
		a.numPatientsOverThreshold(6);
	
	}
	
	@Rule
	public ExpectedException thrown5 = ExpectedException.none();
	
	@Test
	public void emptyLogTest3()
	{
		thrown5.expect(EmptyLogException.class);
		EmergencyRoomLog a = new EmergencyRoomLog();
		a.numPatientsOverThreshold(3);
	
	}
}
