import java.util.Set;

/** Demo recursive methods, Lecture 1 on recursion */
public class D {

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

    /** = the length of s --without using function s.length(). */
    public static int len(String s) {
        if (s.equals("")) return 0;
        return 1 + len(s.substring(1));
    }

    /** = s with every char duplicated.<br>
     * ...e.g. if s is "b#3", return "bb##33" */
    public static String dup(String s) {
        throw new UnsupportedOperationException();
    }

    /** = number of 'e's in s */
    public static int countEm(String s) {
        if (s.equals("")) return 0;
        // s = s[0] + s[1..]
        // return number of e's in s[1..]
        if (s.charAt(0) != 'e') return countEm(s.substring(1));
        // if we get here, s[0] is an e
        return 1 + countEm(s.substring(1));
    }

    /** = "s is a palindrome" --reads the same backward and forward. */
    public static boolean isPal(String s) {
        if (s.length() <= 1) return true;
        int k= s.length() - 1;
        // s[0] + s[1..k-1] + s[k]
        // return s[0] == s[k] and s[1..k-1] is a palindrome
        return s.charAt(0) == s.charAt(k) && isPal(s.substring(1, k));
        // substring includes first value, and ends up into but not including last

    }

    /** = s with adjacent duplicates removed. <br>
     * Example: for s = "abbcccdeaaa", the answer is "abcdea". */
    public static String removeAdjDups(String s) {
        if (s.length() <= 1) return s;
        // s = s[0] + s[1] + s[2..]
        if (s.charAt(0) == s.charAt(1)) return removeAdjDups(s.substring(1));
        // s[0] = s[1]
        return s.charAt(0) + removeAdjDups(s.substring(1));
    }

    /** = the reverse of s */
    public static String rev(String s) {
        throw new UnsupportedOperationException();
    }

    /** = the reverse of s */
    public static String rev1(String s) {
        throw new UnsupportedOperationException();
    }

    /** = number of the digits in the decimal representation of n. <br>
     * e.g. numDigits(0) = 1, numDigits(3) = 1, <br>
     * numDigits(34) = 2. numDigits(1356) = 4. <br>
     * Precondition: n >= 0. */
    public static int numDigits(int n) {
        throw new UnsupportedOperationException();
    }

    /** = b^c. <br>
     * Precondition: c >= 0. <br>
     * Property b^c = b * b^(c-1) <br>
     * Property: c is even, b^c = (b*b)^(c/2) */
    public static double exp(double b, int c) {
        throw new UnsupportedOperationException();
    }

    /** n >= 0. Return n with commas placed in it as we do in US. <br>
     * E.g. 6534285743, return "6,534,285,743 */
    public static String commafy(int n) {
        throw new UnsupportedOperationException();
    }

    /** n with 0's prepended to make it at least 3 chars. */
    public static String prep(int n) {
        throw new UnsupportedOperationException();
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

        // s is s[0] + s[1..]
        // The permutations of s are all the permutations of s[1..]
        // but with s[0] inserted in each possible position of each
        // of the permutations of s[1..].

        // Add to ans all permutations resulting from
        // inserting s[0] in all possible places of
        // all strings in p

        throw new UnsupportedOperationException();
    }

}