/** A person with a first and last name and age. */
public class Person {
	public final String first;
	public final String last;
	public final int age;

	/** Constructor: a person with first name ft, last name lt, and age a. <br>
	 * Precondition ft and lt are not null, ag >= 0. */
	public Person(String ft, String lt, int ag) {
		first= ft;
		last= lt;
		age= ag;
	}

	/** Return a representation of this Person --their name. */
	@Override
	public String toString() {
		return first + " " + last;
	}

}
