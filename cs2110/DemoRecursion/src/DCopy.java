import java.util.HashSet;
import java.util.Set;

/** Demo recursive methods, Lecture 1 on recursion */
public class DCopy {

	/** Implicit precondition of all String parameters: they are not null. */

	/** = sum of digits in the decimal representation of n. <br>
	 * e.g. sum(0) = 0, <br>
	 * sum(3) = 3 <br>
	 * sum(34) = 7. <br>
	 * sum(1356) = 15. 6 + sum of the digits in 135 <br>
	 * Precondition: n >= 0. */
	public static int sumDigs(int n) {
		if (n < 10) return n;
		return n % 10 + sumDigs(n / 10);
	}

	/** = the length of s --without using function s.length. */
	public static int len(String s) {
		if (s.equals("")) return 0;

		// s = s[0] + s[1..]
		// return 1 + length of s[1..]
		return 1 + len(s.substring(1));
	}

	/** = number of 'e's in s */
	public static int countEm(String s) {
		if (len(s) == 0) return 0;

		// s = s[0] + s[1..]
		return (s.charAt(0) == 'e' ? 1 : 0) + countEm(s.substring(1));
	}

	/** = "s is a palindrome" --reads the same backward and forward. */
	public static boolean isPal(String s) {
		if (s.length() <= 1) return true;
		int n= s.length() - 1;
		// s = s[0] + s[1..n-1] + s[n]
		return s.charAt(0) == s.charAt(n) &&
			isPal(s.substring(1, n));
	}

	/** = number of the digits in the decimal representation of n. <br>
	 * e.g. numDigits(0) = 1, numDigits(3) = 1, <br>
	 * numDigits(34) = 2. numDigits(1356) = 4. <br>
	 * Precondition: n >= 0. */
	public static int numDigits(int n) {
		if (n < 10) return 1;
		// n = number of digitis in (n/10) followed by the digit n%10
		return numDigits(n / 10) + 1;
	}

	/** = s with adjacent duplicates removed. <br>
	 * Example: for s = "abbcccdeaaa", the answer is "abcdea". */
	public static String removeDups(String s) {
		if (s.length() <= 1) return s;
		// s = s[0] + s[1] + s[2..]
		if (s.charAt(0) == s.charAt(1)) return s.substring(1);
		// s[0] != s[1]
		return s.charAt(0) + removeDups(s.substring(1));
	}

	/** = s with every char duplicated. */
	public static String dup(String s) {
		if (s.length() == 0) return s;

		// s = s[0] + s[1..]
		return s.charAt(0) + (s.charAt(0) + dup(s.substring(1)));
	}

	/** = b^c. <br>
	 * Precondition: c >= 0. <br>
	 * Property b^c = b * b^(c-1) <br>
	 * Property: c is even, b^c = (b*b)^(c/2) */
	public static double exp(double b, int c) {
		if (c == 0) return 1;
		if (c % 2 == 0) return exp(b * b, c / 2);
		return b * exp(b, c - 1);
	}

	/** = the reverse of s */
	public static String rev(String s) {
		if (s.length() <= 1) return s;
		// s = s[0] + s[1..]
		return rev(s.substring(1)) + s.charAt(0);
	}

	/** = the reverse of s */
	public static String rev1(String s) {
		if (s.length() <= 1) return s;
		int n= s.length() - 1;
		// s = s[0] + s[1..n-1] + s[n]
		return s.substring(n) + rev1(s.substring(1, n)) + s.charAt(0);
	}

	/** n >= 0. Return n with commas placed in it as we do in US. E.g. 6534285743, return
	 * "6,534,285,743 */
	public static String commafy(int n) {
		if (n < 1000) return "" + n;

		return commafy(n / 1000) + "," + prep(n % 1000);
	}

	/** n with 0's prepended to make it at least 3 chars. */
	public static String prep(int n) {
		if (n < 10) return "00" + n;
		if (n < 100) return "0" + n;
		return "" + n;
	}

	/** /** = the permutations of s. <br>
	 * e.g. the permutations of "abc" are <br>
	 * "abc", "acb", "bac", "bca", "cab", "cba" <br>
	 *
	 * Permutations of "bc" are bc and cb.<br>
	 * Insert a in all possible places in bc: abc, bac, bca.<br>
	 * Insert a in all possible places in bc: acb, cab, cba
	 *
	 * s[0] + s[1..] Find all permutations of s[1..] In each of them, insert s[0] in all possible
	 * places in each of them
	 *
	 * Precondition: the chars of s are all different. */
	public static Set<String> perms(String s) {
		// We store the permutations in a HashSet. All you have to know
		// is that a HashSet maintains a set. But we cast the set up
		// abstract class Set so only set operations will be used on it.
		// Take a look at how this method is tested in the JUnit testing class.
		if (s.length() <= 1) {
			Set<String> ans= new HashSet<>();
			ans.add(s);
			return ans;
		}

		// s is s[0] + s[1..]
		// The permutations of s are all the permutations of s[1..]
		// but with s[0] inserted in each possible position of each
		// of the permutations of s[1..].
		Set<String> p= perms(s.substring(1));

		Set<String> ans= new HashSet<>();
		// Add to ans all permutations resulting from
		// inserting s[0] in all possible places of
		// all strings in p
		for (String r : p) {
			for (int k= 0; k <= r.length(); k= k + 1) {
				ans.add(r.substring(0, k) + s.charAt(0) + r.substring(k));
			}
		}

		return ans;
	}

}