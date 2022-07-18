
/** Demo of an anonymous function */
public class D {
	/** Method main illustrates that when an anonymous function is<br>
	 * assigned to a Interface with one abstract method, the Java compiler<br>
	 * creates a class for it that contains that anonymous function, made into<br>
	 * a named function. */
	public static void main(String[] pars) {
		// In the statement below, there is no need to give the
		// type of parameter s because it's inferred from F1.
		F1 v1= s -> Integer.valueOf(s);
		int k= v1.m("34");
		System.out.println("v1's class: " + v1.getClass().getName());

		F1 v2= s -> Integer.valueOf(s);
		int h= v2.m("45");
		System.out.println("v2's class: " + v2.getClass().getName());
	}
}

/** An interface with one abstract method. */
interface F1 {
	Integer m(String s);
}
