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
		Molecule test4 = new Molecule("H120");
		Molecule test5 = new Molecule("HCOOH");
		Molecule test6 = new Molecule("(CH)(CH)(CH)");
		Molecule test7 = new Molecule("(CH)3");
		Molecule test8 = new Molecule("H((OH)2C3H)2");
		
		
		assertEquals(18, test.getWeight());
		assertEquals(56, test1.getWeight());
		assertEquals(44, test2.getWeight());
		assertEquals(58, test3.getWeight());
		assertEquals(120, test4.getWeight());
		assertEquals(46, test5.getWeight());
		assertEquals(39, test6.getWeight());
		assertEquals(39, test7.getWeight());
		assertEquals(143, test8.getWeight());
	}

}
