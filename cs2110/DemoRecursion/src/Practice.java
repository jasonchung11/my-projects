/** Contains static functions to be implemented recursively. You may assume that calls with null
 * arguments will not be used. */
public class Practice {
	/** = s but with all occurrences of "pi" replaced by "3.14". */
	public static String piRep(String s) {
		return null;
	}

	/** = the number of occurrences of "abc" and "cba" in s.<br>
	 * E.g. noc("abccba") = 1<br>
	 * E.g. noc("abcba") = 2 */
	public static int noc(String s) {
		return 0;
	}

	/** = a copy of s in which each '$' has been moved to the end.<br>
	 * E.g. if s = "a$b$$c", the result is "abc$$$" */
	public static String move$(String s) {
		return null;
	}

	/** = the number of digits 8 that appear in the decimal <br>
	 * representation of n.<br>
	 * Precondition: n is >= 0.<br>
	 * E.g. n9(532) = 0<br>
	 * E.g. n9(083618) = 2 */
	public static int n9(int n) {
		return 0;
	}

	/** = true iff if s consists of nested parentheses <br>
	 * representation of n.<br>
	 * E.g. nested("") is true<br>
	 * E.g. nested("((()))") is true<br>
	 * E.g. nested("(((y)))") is false<br>
	 * E.g. nested("((())) ") is false<br>
	 * E.g. nested("(([)))") is false */
	public static boolean nested(String s) {
		return false;
	}

	/** A "pair" is two occurrences of a character separated by a character.<br>
	 * E.g. "bxbcccc" contains the pair "bxb"<br>
	 * E.g. "bxbx" contains the two pairs "bxb" and "xbx"<br>
	 * E.g. "bxbbb" contains the two pairs "bxb" and "bbb"<br>
	 * Return the number of pairs in s. */
	public static int nPairs(String s) {
		return 0;
	}

	/** Return true iff b[k..] contains an 8. Once the answer is found, don't continue looking. */
	public static boolean has8(int[] b, int k) {
		return false;
	}

	/** Return true iff a group of the values in b[k..] sums to n.<br>
	 * E.g. groupSum({2, 7, 3}, 0, 0) is true. (the empty group)<br>
	 * E.g. groupSum({2, 7, 3}, 0, 9) is true.<br>
	 * E.g. groupSum({2, 7, 3}, 1, 9) is false.<br>
	 * E.g. groupSum({2, 7, 3}, 1, 7) is true.<br>
	 * E.g. groupSum({2, 7, 3}, 1, 3) is true. */
	public static boolean groupSum(int[] b, int k, int n) {
		return false;
	}

}
