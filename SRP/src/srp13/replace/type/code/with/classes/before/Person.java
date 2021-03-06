/*
 * SMELL: Primitive Obsession
 *   -- A class has a field that contains type code. 
 *      The values of this type are not used in operator conditions 
 *      and do not affect the behavior of the program.
 * 
 * TREATMENT: Replace Type Code with Object
 *   -- Create a new class and use its objects instead of the type code values.
  */
package srp13.replace.type.code.with.classes.before;

public class Person
{
	/*
	 * Create a new BloodGroup class encapsulating a code, 
	 * and make clients use its instances instead of code directly.
	 */
	public static final int O = 0;
	public static final int A = 1;
	public static final int B = 2;
	public static final int AB = 3;

	private int bloodGroup;

	public Person()
	{
	}

	public Person(int code)
	{
		bloodGroup = code;
	}

	public void setBloodGroup(int code)
	{
		bloodGroup = code;
	}

	public int getBloodGroup()
	{
		return bloodGroup;
	}

	public static void main(String[] args)
	{
		// Somewhere in client code.
		Person parent = new Person(Person.O);
		if (parent.getBloodGroup() == Person.AB)
		{
			// ...
		}

		Person child = new Person();
		child.setBloodGroup(parent.getBloodGroup());
	}
}
