/*
 * SMELL: Long Parameter List
 *   -- Before a method call, a second method is run and its 
 *      result is sent back to the first method as an argument. 
 *      But the parameter value could have been obtained inside 
 *      the method being called.
 * 
 * TREATMENT: Replace Parameter with Method Call
 *   -- Instead of passing the value through a parameter, place 
 *      the value-getting code inside the method.
 */
package coupling03.replace.parameter.with.method.call.before;

class Order {
	private int quantity;
	private int itemPrice;

	// ...
	public double getPrice() {
		int basePrice = quantity * itemPrice;
		int discountLevel;
		if (quantity > 100) {
			discountLevel = 2;
		} else {
			discountLevel = 1;
		}
		double finalPrice = discountedPrice(basePrice, discountLevel);
		return finalPrice;
	}

	// We cannot reuse "discountPrice" anone
	private double discountedPrice(int basePrice, int discountLevel) {
		if (discountLevel == 2) {
			return basePrice * 0.1;
		} else {
			return basePrice * 0.05;
		}
	}
}
