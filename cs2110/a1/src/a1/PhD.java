/** NetId: jkc97, rft38. Time spent: 5 hours, 30 minutes. <br>
* What I thought about this assignment: <br>
* This assignment was extremely useful in helping us understand the basics of Java and OOP, using constructors, methods, mutators, and other functions.
* Following this assignment, I understand significantly more of how to use Java, Eclipse, JUnit Testing, and am very excited for the next one! */

/** An instance maintains info about the PhD of a person. */
package a1;

public class PhD {
    /** name of person with PhD. String of length >1. */
    private String name;
    /** year the PhD was awarded. Can be any number >1 */
    private int year;
    /** month the pHd was awarded. In range 1..12, with 1 meaning January, 2 February, etc. */
    private int month;
    /** The first PhD advisor of the person, null if unknown. */
    private PhD first;
    /** The second PhD advisor of the person, null if unknown, or if the person has less than two
     * advisors. */
    private PhD second;
    /** The number of PhD advisees of the person. Can be any number >1 */
    private int advisees;

    /** Constructor: an instance with name n, PhD year y, and PhD month m.<br>
     * The advisors are unknown, and there are 0 advisees.<br>
     * Precondition: n has at least 2 chars, and m is in 1..12. */
    public PhD(String n, int y, int m) {
        assert n != null && n.length() > 1;
        assert m >= 1;
        assert m <= 12;
        name= n;
        year= y;
        month= m;
        advisees= 0;
    }

    /** Return the name of this person. */
    public String name() {
        return name;
    }

    /** Return the date this person got their PhD in the form "month/<year>" <br>
     * E.g. For February 2022, return "2/2022". */
    public String date() {
        return Integer.toString(month) + "/" + Integer.toString(year);
    }

    /** Return the first advisor of this PhD (null if unknown). */
    public PhD advisor1() {
        return first;
    }

    /** Return the second advisor of this PhD (null if unknown or non-existent). */
    public PhD advisor2() {
        return second;
    }

    /** Return the number of PhD advisees of this person. */
    public int advisees() {
        return advisees;
    }

    /** Add p as the first advisor of this person. <br>
     * Precondition: the first advisor is unknown and p is not null. */
    public void addAdvisor1(PhD p) {
        assert p != null;
        assert first == null;
        assert p != this;
        first= p;
        p.advisees++ ;
    }

    /** Add p as the second advisor of this PhD. <br>
     * Precondition: The first advisor is known, the second advisor is unknown, <br>
     * p is not null, and p is different from the first advisor. */
    public void addAdvisor2(PhD p) {
        assert first != null;
        assert second == null;
        assert p != first;
        assert p != null;
        assert p != this;
        second= p;
        p.advisees++ ;
    }

    /** Constructor: a PhD with name n, PhD year y, PhD month m, first advisor p1, and second
     * advisor p2.<br>
     * Precondition: n has at least 2 chars, m is in 1..12, p1 and p2 are not null, and p1 and p2
     * are different. */
    public PhD(String n, int y, int m, PhD p1, PhD p2) {
        assert n != null && n.length() > 1;
        assert m >= 1;
        assert m <= 12;
        assert p1 != null;
        assert p2 != null;
        assert p1 != p2;
        name= n;
        year= y;
        month= m;
        first= p1;
        second= p2;
        advisees= 0;
    }

    /** Return value of: "p is not null and this PhD got the PhD before p" */
    public boolean gotBefore(PhD p) {
        return p != null && (year < p.year || year == p.year && month < p.month);
    }

    /** Return value of: "this PhD is an intellectual sibling of p".<br>
     * Precondition: p is not null. */
    public boolean isSiblingOf(PhD p) {
        assert p != null;
        return this != p && (p.advisor1() == advisor1() && advisor1() != null ||
            p.advisor1() == advisor2() && advisor1() != null ||
            p.advisor2() == advisor1() && advisor1() != null ||
            p.advisor2() == advisor2() && advisor2() != null);

    }
}
