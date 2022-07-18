
import java.util.ArrayList;
import java.util.Stack;
import java.util.TreeSet;

/** Demo ArrayList and HashSet. */
public class Rec3 {

	/** Return an array of all the negative numbers in b.<br>
	 * Precondition: b is not null. */
	public static Object[] findNegs1(int[] b) {
		ArrayList negs= new ArrayList();
		for (int i= 0; i < b.length; i++ ) {
			if (b[i] < 0) negs.add(b[i]);
		}

		return negs.toArray();
	}

	/** Return an array of all the negative numbers in b.<br>
	 * Precondition: b is not null. */
	public static Integer[] findNegs2(int[] b) {
		ArrayList<Integer> negs= new ArrayList<>();
		for (int i= 0; i < b.length; i++ ) {
			if (b[i] < 0) {
				negs.add(b[i]);
			}
		}

		return negs.toArray(new Integer[0]);
	}

	/** Return a copy of b with duplicates removed. <br>
	 * Precondition: b is not null */
	public static Integer[] removeDups(int[] b) {
		TreeSet<Integer> ints= new TreeSet<>();
		for (int i= 0; i < b.length; i++ ) {
			ints.add(b[i]); // if b[i] is already in, it is not added again!
		}

		return ints.toArray(new Integer[0]);
	}

	/** Return true iff parentheses () and brackets [] are properly paired in s.<br>
	 * Precondition: s is not null and it contains only characters ( ) [ ]<br>
	 * E.g. These are properly paired "(([][])[])" */
	public static boolean checkParens(String s) {
		Stack<Character> parens= new Stack<>();
		for (int i= 0; i < s.length(); i++ ) {
			char c= s.charAt(i);
			if (c == '(' || c == '[') parens.push(c);
			else { // c is either ')' or ']'
				if (parens.isEmpty()) return false;
				char c1= parens.pop();
				if (c1 == '(' && c == ']' || c1 == '[' && c == ')') return false;
			}
		}
		return parens.isEmpty();
	}

}
