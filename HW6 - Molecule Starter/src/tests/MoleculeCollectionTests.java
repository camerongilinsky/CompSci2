package tests;

import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.Test;

import molecule.Molecule;
import molecule.MoleculeCollection;

public class MoleculeCollectionTests {

	@Test
	public void moleculeCollectionTest()
	{
		Molecule test = new Molecule("H2O");
		Molecule test1 = new Molecule("C2O2");
		Molecule test2 = new Molecule("H12O2");
		
		MoleculeCollection a = new MoleculeCollection();
		
		a.addMolecule(0, test);
		a.addMolecule(1, test1);
		a.addMolecule(2, test2);
		
		a.sort();
		
		//System.out.println(a.toString());
		LinkedList<Molecule> b = new LinkedList<Molecule>();
		b.add(test);
		b.add(test1);
		b.add(test2);
		
		MoleculeCollection c = new MoleculeCollection(b);
		MoleculeCollection d = new MoleculeCollection(null);
		
		System.out.println(c.getMoleculeList().toString());
		c.sort();
		//System.out.println(c.getMoleculeList().toString());
		c.changeSequence(1, "H3O");
		
		assertEquals(93, c.moleculeWeights());
		
	}

}
