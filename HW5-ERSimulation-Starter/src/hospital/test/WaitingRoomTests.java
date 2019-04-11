package hospital.test;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import hospital.exceptions.EmptyWaitingRoomException;
import hospital.model.Patient;
import hospital.model.WaitingRoom;

public class WaitingRoomTests {

	@Test
	public void waitingRoomConstructorTest()
	{
		WaitingRoom w = new WaitingRoom();
		Patient a = new Patient("Gilinsky, Cameron", "Stomach Pain", 0, 3);
		Patient b = new Patient("Kennell, Carter", "Minor Burn", 5, 4);
		Patient c = new Patient("Fry, Philip", "Stomach Pain", 0, 3);
		Patient d = new Patient("Farnsworth, Hubert", "Stomach Pain", 5, 3);
		Patient e = new Patient("Rodriguez, Bender", "Stomach Pain", 5, 2);
		Patient f = new Patient("Conrad, Hermes", "Stomach Pain", 5, 3);
		Patient g = new Patient("Wong, Amy", "Stomach Pain", 15, 5);
		
		w.addPatient(a);
		w.addPatient(b);
		
		w.addPatient(c);
		w.addPatient(d);
		w.addPatient(e);
		w.addPatient(f);
		w.addPatient(g);
		
		System.out.println(w);
		
		assertEquals(7, w.getNumWaiting());
		Patient temp = w.getNextPatient();
		
		assertEquals("Rodriguez, Bender", temp.getName());
		assertEquals(6, w.getNumWaiting());
		
		
	}
	
	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	@Test(expected = EmptyWaitingRoomException.class)
	public void getFromEmptyWaitingRoomTestException() throws EmptyWaitingRoomException
	{
		
		
		WaitingRoom w = new WaitingRoom();
		thrown.expect(EmptyWaitingRoomException.class);
		Patient temp = w.getNextPatient();
		
	}
	
	
	@Test
	public void getFromEmptyWaitingRoomToString()
	{
		
		WaitingRoom w = new WaitingRoom();
		assertEquals("Waiting Room Status: EMPTY!", w.toString());
		
	}

}
