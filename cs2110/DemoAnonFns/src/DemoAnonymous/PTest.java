import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import org.junit.jupiter.api.Test;

public class PTest {

	/** An array of Person's to process.<br >
	 * Person's have a first name, last name, and age. */
	public static Person[] p= {
			new Person("Mary", "Ito", 5),
			new Person("Sage", "Hop", 4),
			new Person("Dani", "Dee", 9),
			new Person("Jack", "Doe", 3),
			new Person("Dani", "Web", 7),
	};

	/** If b's and c's first names are the same, return b's age - c's age. <br>
	 * Otherwise, return -1 (or 1) if b's first name comes before (or after) c's last name. */
	public static int before(Person b, Person c) {
		int n= b.first.compareTo(c.first);
		if (n != 0) return n;
		return b.age - c.age;
	}

	public static String pInitial= "[Jack Doe, Sage Hop, Mary Ito, Dani Web, Dani Dee]";

	public static String pSortByLast= "[Dani Dee, Jack Doe, Sage Hop, Mary Ito, Dani Web]";

	public static String pSortByFirstLast= "[Dani Dee, Dani Web, Jack Doe, Mary Ito, Sage Hop]";

	public static String pSortByFirstAge= "[Dani Web, Dani Dee, Jack Doe, Mary Ito, Sage Hop]";

	/** Return a string representation of p: [value, value, ..., value] */
	public static <E> String toString(E[] p) {
		String res= "[";
		for (int k= 0; k < p.length; k= k + 1) {
			if (0 < k) res= res + ", ";
			res= res + p[k];
		}
		return res + "]";
	}

	@Test
	/** lst.remove(bool-function) removes all elements from lst for which<br>
	 * the bool-function is true.<br>
	 * In this example, all empty strings are removed from the list. */
	void testUseOfRemoveIf() {
		List<String> lst= new ArrayList<>();
		lst.add("Gries");
		lst.add("");
		lst.add("Clarkson");
		lst.add("");
		lst.add("");
		lst.add("");

		lst.removeIf(s -> s.isEmpty());

		assertEquals("[Gries, Clarkson]", lst.toString());
	}

	@Test
	/** This is another test of removeIf. <br>
	 * Given is an a List of ArrayLists!<br>
	 * We test the removal of those that are non-increasing.<br>
	 * Thus, an ArrayList that contains [9, 4, 8] is removed.<br>
	 * This example is used to show a complicated anonymous function. <br>
	 */
	void testFilter() {
		// Build three ArrayLists.
		List<Integer> one= new ArrayList<>();
		one.add(3);
		one.add(4);
		one.add(8);

		List<Integer> two= new ArrayList<>();
		two.add(9);
		two.add(4);
		two.add(8);

		List<Integer> three= new ArrayList<>();
		three.add(3);

		// Build a List ls of the three ArrayLists.
		List<List<Integer>> ls= new ArrayList<>();
		ls.add(one);
		ls.add(two);
		ls.add(three);

		// Build the same list as ls but with nonincreasing ArrayLists removed.
		List<List<Integer>> lsExpected= new ArrayList<>();
		lsExpected.add(one);
		lsExpected.add(three);

		ls.removeIf(
			// Below is the anonymous function. Given an arg that is
			// an ArrayList<Integer>, it returns true if the ArrayList
			// is non-increasing and false it is is increasing.
			(arg) -> {
				int prev= Integer.MIN_VALUE;
				// invariant: prev is the list value before k (
				for (int k : arg) {
					if (k < prev) return true;
					prev= k;
				}
				return false;

			});

		// Check whether the expected answer is the same as the computed one.
		assertEquals(lsExpected, ls);
	}

	@Test
	/** lst.replaceAll(function) replaces all elements of lst using<br>
	 * the function.<br>
	 * In this example, all elements are replaced by lower-case versions. */
	void testLowerCase() {
		List<String> lst= new ArrayList<>();
		lst.add("GRIES");
		lst.add("");
		lst.add("Clarkson");
		lst.replaceAll(s -> s.toLowerCase());
		assertEquals("[gries, , clarkson]", lst.toString());
	}

	@Test
	/** lst.sort(comparator) sorts the array using the argument to indicate<br>
	 * order: the argument is a function that returns a negative, 0, or positive<br>
	 * number depending on whether its first argument comes before, equals,<br>
	 * or comes after the segment.<br>
	 * This method tests sorting on the string lengths. */
	void testSortOnLength() {
		List<String> lst= new ArrayList<>();
		lst.add("Anne Bracy");
		lst.add("Gries");
		lst.add("Clarkson");
		lst.add("R Tate");

		lst.sort((s1, s2) -> s1.length() - s2.length());

		assertEquals("[Gries, R Tate, Clarkson, Anne Bracy]", lst.toString());
	}

	@Test
	/** lst.sort(comparator) sorts the array using the argument to indicate<br>
	 * order: the argument is a function that returns a negative, 0, or positive<br>
	 * number depending on whether its first argument comes before, equals,<br>
	 * or comes after the segment.<br>
	 * This method tests sorting on the the first character of each string. */
	void testSortOnFirst() {
		List<String> lst= new ArrayList<>();
		lst.add("David Gries");
		lst.add("Ross Tate");
		lst.add("Michael Clarkson");
		lst.add("Anne Bracy");

		lst.sort((s1, s2) -> s1.charAt(0) - s2.charAt(0));

		assertEquals("[Anne Bracy, David Gries, Michael Clarkson, Ross Tate]", lst.toString());
	}

	@Test
	/** lst.forEach(anonymous function) process each element of list lst by calling<br>
	 * the anonymous function with the element as an argument. We use this to<br>
	 * show how we can create a list like the initial list by with each element duplicated. */
	void testDoubleAList1() {
		List<String> lst= new ArrayList<>();
		lst.add("Clarkson");
		lst.add("Gries");
		lst.add("Tate");

		List<String> d= new ArrayList<>();
		lst.forEach(t -> {
			d.add(t);
			d.add(t);
		});

		assertEquals("[Clarkson, Clarkson, Gries, Gries, Tate, Tate]", d.toString());
	}

	@Test
	/** lst.forEach(anonymous function) process each element of list lst by calling<br>
	 * the anonymous function with the element as an argument. We use this to<br>
	 * show how we can create a list like the initial list by with each element duplicated. */
	void testaDoubleList2() {
		List<Integer> lst= new ArrayList<>();
		lst.add(1);
		lst.add(10);
		lst.add(100);

		List<Integer> d= new ArrayList<>();
		lst.forEach(t -> {
			d.add(t);
			d.add(t);
		});

		assertEquals("[1, 1, 10, 10, 100, 100]", d.toString());
	}

	@Test
	public void testArraySort() {

		Arrays.sort(p, (b, c) -> b.last.compareTo(c.last));
		assertEquals(pSortByLast, toString(p));

		Arrays.sort(p, (Person b, Person c) -> b.age - c.age);
		Arrays.sort(p, (b, c) -> b.age - c.age);
		assertEquals(pInitial, toString(p));

		Arrays.sort(p, (b, c) -> before(b, c));
		assertEquals(pSortByFirstAge, toString(p));

		Arrays.sort(p, 1, 5, (b, c) -> before(b, c));
		assertEquals(pSortByFirstAge, toString(p));

		Arrays.sort(p, 1, 2, (Person b, Person c) -> b.age - c.age);
	}

	@Test
	public void testListSort() {
		List<Person> al= new ArrayList<>();
		al.add(new Person("Mary", "Ito", 5));
		al.add(new Person("Sage", "Hop", 4));
		al.add(new Person("Dani", "Dee", 9));
		al.add(new Person("Jack", "Doe", 3));
		al.add(new Person("Dani", "Web", 7));
		Collections.sort(al, (b, c) -> b.age - c.age);
		assertEquals(pInitial, al.toString());

		al.sort((b, c) -> b.age - c.age);
	}

	@Test
	public void testLinkedListSort() {
		LinkedList<Person> al= new LinkedList<>();
		al.add(new Person("Mary", "Ito", 5));
		al.add(new Person("Sage", "Hop", 4));
		al.add(new Person("Dani", "Dee", 9));
		al.add(new Person("Jack", "Doe", 3));
		al.add(new Person("Dani", "Web", 7));
		Collections.sort(al, (b, c) -> b.age - c.age);
		assertEquals(pInitial, al.toString());

		al.sort((b, c) -> b.age - c.age);
		al.sort((b, c) -> before(b, c));
	}

}
