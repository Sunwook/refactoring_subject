/*
 * SMELL: DD-Anomaly (by PMD)
 *   -- You have a local variable that is used to store various 
 *      intermediate values inside a method.
 *      (except for loop or accumulator variables).
 * 
 * TREATMENT: Split Temporary Variables
 *   -- Use different variables for different values. 
 *      Each variable should be responsible for only one particular 
 *      thing (cohesion).
  */
package scp03.split.temporary.variable.before;

public class Demo {

	public void printInfo(int width, int height) {
		
		double temp = 2 * (width + height); 
		System.out.println(temp);
		
		temp = width * height;
		System.out.println(temp);
	}
}
