/*
 * SMELL: Complicated Conditional
 *   -- You have a complex conditional (if-then/else or switch).
 * 
 * TREATMENT: Decompose Conditional
 *   -- Decompose the complicated parts of the conditional 
 *   	into separate methods: the condition, then and else.
 *   -- May apply "Extract Method" (Make code clearer by 
 *   	decomposing it and replacing chunks of code with 
 *   	a method with meaningful name.
 *   
  */
package srp02.decompose.conditional.before;

import java.util.Date;

class Stadium {
	private static final Date SUMMER_START = new Date(2016, 6, 1);
	private static final Date SUMMER_END = new Date(2016, 7, 31);
	// ...
	public double summerRate;
	public double winterRate;
	public double winterServiceCharge;

	public double getTicketPrice(Date date, int quantity) {
		double charge;
		if (date.before(SUMMER_START) || date.after(SUMMER_END)) { // not summer
			charge = quantity * winterRate + winterServiceCharge;
		} else {
			charge = quantity * summerRate;
		}
		return charge;
	}
}
