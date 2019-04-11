package hospital.test;

import static org.junit.Assert.*;

import org.junit.Test;

import hospital.model.Patient;

public class PatientTests {

	@Test
	public void patientConstructorTest()
	{
		Patient a = new Patient("Gilinsky, Cameron", "Stomach Pain", 0, 3);
		
		assertEquals(a.getTimeArrived(), 0);
		assertEquals(a.getName(), "Gilinsky, Cameron");
		assertEquals(a.getCondition(), "Stomach Pain");
		assertEquals(a.getPriority(), 3);
		assertEquals(a.toString(), "Patient: Gilinsky, Cameron         Condition: Stomach Pain              Priority: 3   Waiting Since: 0");
	}

	@Test
	public void patientCompareToTest()
	{
		Patient a = new Patient("Gilinsky, Cameron", "Stomach Pain", 0, 3);
		Patient b = new Patient("Kennell, Carter", "Minor Burn", 5, 4);
		Patient c = new Patient("Fry, Philip", "Stomach Pain", 0, 3);
		Patient d = new Patient("Farnsworth, Hubert", "Stomach Pain", 5, 3);
		Patient e = new Patient("Rodriguez, Bender", "Stomach Pain", 5, 2);
		Patient f = new Patient("Conrad, Hermes", "Stomach Pain", 5, 3);
		
		
		assertEquals(-1, a.compareTo(b));
		assertEquals(0, a.compareTo(c));
		assertEquals(-1, a.compareTo(d));
		assertEquals(1, a.compareTo(e));
		assertEquals(1, f.compareTo(a));
		
	}
}
