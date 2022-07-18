
/** Example of recursion with backtracking. */
public class Sums {

	/** Return true iff the elements of b can be placed into two bags that<br>
	 * sum to the same value.<br>
	 * E.g. b = {3, 4}, false<br>
	 * E.g. b = {3, 4, 1}, true: {3, 1} and {4}<br>
	 * E.g. b = {4, 6, 3, 2, 8}, false: one bag sum odd, the other even<br>
	 * E.g. b = {4, 6, 1, 6, 8, 5}, true: sum is 15< */
	public static boolean split(int[] b) {
		return split(b, 0, 0, 0);
	}

	/** Values in b[0..k-1] have been placed in two bags, whose sums are s1 and s2.<br>
	 * Return true iff b[k..] can be placed in the two bags<br>
	 * so that the bags have the same sum. */
	public static boolean split(int[] b, int k, int s1, int s2) {
		if (k == b.length) return s1 == s2;
		return split(b, k + 1, s1 + b[k], s2) || split(b, k + 1, s1, s2 + b[k]);

	}

	/** If values in b can be placed in the two bags so that the two bags have the same sum,<br>
	 * return the number of recursive calls made on splitCount.<br>
	 * Otherwise, return -(number of recursive calls made).<br>
	 * E.g. b = {3, 4}, false<br>
	 * E.g. b = {3, 4, 1}, true: {3, 1} and {4}<br>
	 * E.g. b = {4, 6, 3, 2, 8}, false: one bag sum odd, the other even<br>
	 * E.g. b = {4, 6, 1, 6, 8, 5}, true: sum is 15< */
	public static long splitCount(int[] b) {
		return splitCount(b, 0, 0, 0);
	}

	/** Values in b[0..k-1] have been placed in two bags, whose sums are s1 and s2.<br>
	 * If b[k..] can be placed in the two bags so that the two bags have the same sum,<br>
	 * return the number of recursive calls made on splitCount.<br>
	 * Otherwise, return -(number of recursive calls made). */
	private static long splitCount(int[] b, int k, int s1, int s2) {
		if (k == b.length) return s1 == s2 ? 1 : -1;
		// Try b[k] in the first bag
		long r1= splitCount(b, k + 1, s1 + b[k], s2);
		if (r1 > 0) return r1 + 1;
		// Can't do it with b[k] in the first bag
		long r2= splitCount(b, k + 1, s1, s2 + b[k]);
		if (r2 > 0) return -r1 + r2 + 1;
		return r1 + r2 - 1;
	}
}
