// COURSE: CSCI1620
// TERM: Spring 2019
//
// NAME: Cameron Gilinsky and Carter Kennell
// RESOURCES: Piazza discussion board posts by the
//				students and instructors for this class.

package schedules;

/**
 * An enum for the Douglas County Nebraska retail food 
 * risk assessments. Values are reproduced from: 
 * https://www.douglascountyhealth.com/food-safety/retail-food-establishment-rating-list
 * 
 * 
 * @author bdorn
 *
 */
public enum Risk
{
	
	/**
	 * Establishment sells prepackaged foods that require no food 
	 * preparation.  For example, a "convenience store, mini-mart, 
	 * or bodega" is a "low" risk establishment 
	 */
	LOW,
	
	/**
	 * Establishment sells limited preparation, processed foods.  
	 * For example, a "fast food restaurant" is a "medium" risk establishment.
	 */
	MEDIUM,
	
	/**
	 * Establishment prepares foods to cook, cool 
	 * and reheat before sell.  For example, a "full 
	 * service restaurant" is a "high" risk establishment
	 */
	HIGH
}
