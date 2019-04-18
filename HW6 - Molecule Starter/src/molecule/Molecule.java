// COURSE: CSCI1620
// TERM: Spring 2019
//
// NAME: Cameron Gilinsky and Carter Kennell
// RESOURCES: Piazza discussion board posts by the
//				students and instructors for this class.

package molecule;

import molecule.exceptions.InvalidAtomException;

//public class Molecule<E extends java.lang.Comparable<E>> implements Cloneable
/**
 * Objects of the Molecule class represent a single chemical molecule made
 * up of any number of hydrogen, carbon, and oxygen atoms. The class
 * provides functionality to compute the atomic weight of the molecule.
 * @author ckgilinsky and ckennell
 */
public class Molecule implements Comparable<Molecule>, Cloneable
{
	/**
	 * Creates a new Molecule made up of the H, C, and O atoms in the configuration
	 * specified by sequenceIn.
	 * @param sequenceIn The sequence of atoms for this Molecule.
	 * @throws InvalidAtomException if any non C, H, O atom exists in sequenceIn
	 * @throws InvalidSequenceException if unmatched parentheses exist in sequenceIn or
	 * 		   incoming sequence is null or empty String.
	 */
	public Molecule(String sequenceIn)
	{
		//somehow split into how many C, how many H, how many O
	}
	
	/**
	 * Updates the sequence of atoms represented by this Molecule.
	 * @param sequenceIn The new molecular sequence to be used for this Molecule.
	 * @throws InvalidAtomException if any non C, H, O atom exists in sequenceIn
	 * @throws InvalidSequenceException if unmatched parentheses exist in sequenceIn
	 */
	public void setSequence(String sequenceIn)
	{
		
	}
	
	/**
	 * Retrieves a String containing this Molecule's sequence of atoms.
	 * @return Molecular sequence of the Molecule.
	 */
	public String getSequence()
	{
		return "";
	}
	
	/**
	 * Retrieves this Molecule's weight, which is calculated based on the Molecule's
	 * sequence per the algorithm specified.
	 * @return Weight of the Molecule.
	 */
	public int getWeight()
	{
		return 0;
	}
	
	/**
	 * Generates and returns a String with the Molecule's sequence and weight.
	 * The format of the String is
	 * 
	 * [SEQUENCE               ]: WEIGHT
	 * 
	 * Where SEQUENCE has a field width of 25 and is left justified (square brackets
	 * are just placeholders and will not appear in actual return values.
	 * WEIGHT should be left-justified. There is no space following the SEQUENCE field and the
	 * colon.
	 */
	@Override
	public String toString()
	{
		return "";
	}
	
	/**
	 * Static utility method to return the atomic weight of a given atom.
	 * Supported atoms are Carbon (C), Hydrogen (H), and Oxygen (O), and
	 * the value of the atom parameter corresponds to the single letter
	 * abbreviation for these atoms (case insensitive). Atomic weights
	 * are given in their nearest whole number:
	 * 
	 * Hydrogen - 1
	 * Carbon - 12
	 * Oxygen - 16
	 * 
	 * @param atom Character for atom abbreviation
	 * @return Atomic weight of passed atom
	 * @throws InvalidAtomException Thrown if an unsupported atom is passed
	 */
	public static int atomWeight(char atom) throws InvalidAtomException
	{
		return 0;
	}
	
	
	/**
	 * Compares this Molecule to a passed Molecule, determining natural order. Molecules with the same
	 * weight (regardless of sequence) are considered equal. All others are ordered
	 * relative to the magnitude of their weights.
	 * @param other Incoming Molecule to be compared with this (local) Molecule.
	 * @return Returns an int less than 0 if the local Molecule is less than the
	 * 		   passed Molecule, an int greater than 0 if the local Molecule is
	 * 		   greater than the passed Molecule, and a 0 if the Molecules are equal.
	 */
	@Override
	public int compareTo(Molecule other)
	{
		return 0;
	}
	
	/**
	 * Returns a deep copy of the Molecule. The reference returned should refer to a
	 * completely separate molecule with no direct or indirect aliasing of any
	 * instance data in the originalMolecule.
	 * 
	 * NOTE: This method should NOT throw a CloneNotSupportedException.
	 * 
	 * @return Deep copy of the calling Molecule.
	 */
	@Override
	public Object clone()
	{
		return null;
	}

}
