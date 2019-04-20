package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import molecule.Molecule;

public class MoleculeTests
{

	@Test
	public void moleculeConstructorTest()
	{
		Molecule test = new Molecule("H2O");
		Molecule test1 = new Molecule("C2O2");
		Molecule test2 = new Molecule("H12O2");
		Molecule test3 = new Molecule("C2(OH)2");
		Molecule test4 = new Molecule("C2(OH)2");
		
		
		assertEquals(18, test.getWeight());
		assertEquals(56, test1.getWeight());
		assertEquals(44, test2.getWeight());
		assertEquals(58, test3.getWeight());
	}

}
