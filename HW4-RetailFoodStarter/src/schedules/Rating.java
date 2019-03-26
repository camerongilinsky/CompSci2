// COURSE: CSCI1620
// TERM: Spring 2019
//
// NAME: Cameron Gilinsky and Carter Kennell
// RESOURCES: Piazza discussion board posts by the
//				students and instructors for this class.

package schedules;

/**
 * An enum for the Douglas County Nebraska retail food 
 * inspections ratings. Values are reproduced from: 
 * https://www.douglascountyhealth.com/food-safety/retail-food-establishment-rating-list
 * 
 * @author bdorn
 *
 */
public enum Rating
{
	
	/**
	 * The establishment barely meets minimum standards required by state 
	 * and local food safety codes. Serious and minor sanitation 
	 * deficiencies are found on each inspection. Sanitation deficiencies 
	 * are not corrected on a routine basis and repeat inspections are 
	 * often a necessary part of regulating these establishments to help 
	 * assure minimum food safety conditions.
	 */
	FAIR,
	
	/**
	 * The establishment generally corrects most sanitation deficiencies 
	 * on a routine basis and corrects violations found at the time of 
	 * inspection in the time allowed by the inspecting health officer.
	 */
	STANDARD,
	
	/**
	 * The establishment routinely corrects most sanitation deficiencies and 
	 * immediately corrects the minor violations found at the time of inspection.
	 */
	EXCELLENT,
	
	/**
	 * The establishment understands and routinely corrects sanitation 
	 * deficiencies on a day-to-day basis and does not wait for a health 
	 * inspection before doing so. in addition, at least 75 percent of 
	 * employees and management of a superior food establishment must 
	 * have successfully completed a food safety training course conducted 
	 * by this department, or its equivalent.
	 */
	SUPERIOR
}
