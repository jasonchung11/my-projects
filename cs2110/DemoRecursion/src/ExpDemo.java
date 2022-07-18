
/** Demo of recursive slow and fast exponentiation. */
public class ExpDemo {

    /** = b^n. <br>
     * Precondition n >= 0. <br>
     * Properties: b^0 = 1. <br>
     * b^n = b*b^(n-1) for n > 0. */
    public static double expSlow(double b, int n) {
        // base case
        if (n == 0) return 1;
        // recursive case
        return b * expSlow(b, n - 1);
    }

    /*  The algorithm given below to calculate b^n use the binary representation
     *  of n in the following way. Consider
     *     2^4   = 16: in binary:  1000
     *     2^4-1 = 15: in binary:   111
     *
     *  A recursive call look at the last bit of n
     *  If that bit is 0, n is even, and the next recursive call uses
     *     n/2 --that's n with the last bit thrown away.
     *  If that bit is 1, n is odd, and the next recursive call uses
     *     n-1  --that's n with its last bit changed from 1 to 0.
     *  So, the number of recursive calls is at most 2 times the
     *     number of bits needed to represent n in binary.
     */
    /** = b^n. Precondition n >= 0. <br>
     * Properties: b^0 = 1. <br>
     * b^n = b*b^(n-1) for c > 0. <br>
     * b^n = (b*b)^(n/2) for even n. <br>
     * <br>
     * 3*8 = 3*3*3*3*3*3*3*3 = (3*3) * (3*3) * (3*3) * (3*3) = (3*3)^4 */
    public static double expFast(double b, int n) {
        if (n == 0) return 1;
        // recursive case
        if (n % 2 == 0) return expFast(b * b, n / 2);
        // make the number even (called once)
        return b * expFast(b, n - 1);
    }

    // The following two methods produce a pair
    // (value of b^n, number of calls made to produce the value)
    // They use class PairDi to wrap the two values in an object.

    /** = the pair (b^n, no. of calls made). <br>
     * Precondition: n ≥ 0. */
    public static PairDI exp2Slow(double b, int n) {
        if (n == 0) return new PairDI(1.0, 1);

        // n > 0
        PairDI p= exp2Slow(b, n - 1);
        return new PairDI(b * p.d, p.i + 1);
    }

    /** = the pair (b^n, no. of calls made). <br>
     * Precondition: n ≥ 0 */
    public static PairDI exp2Fast(double b, int n) {
        if (n == 0) return new PairDI(1.0, 1);

        // n > 0
        if (n % 2 == 0) {
            PairDI p= exp2Fast(b * b, n / 2);
            return new PairDI(p.d, p.i + 1);
        }

        // n is odd
        PairDI p= exp2Fast(b, n - 1);
        return new PairDI(b * p.d, p.i + 1);
    }

    /** Print how big the call-stack can get, using exp2Slow .<br>
     * Then print how big the call stack is for ex2Fast. */
    public static void main(String[] args) {
        int k= 1;
        PairDI slow;
        try {
            while (true) {
                slow= exp2Slow(.9999, k);
                k= 2 * k;
            }

        } catch (StackOverflowError re) {}

        System.out.println("exp2Slow(.9999, " + k + ") overflowed the call stack.");

        slow= exp2Slow(.9999, k / 2);
        System.out.println("\nexp2Slow(.9999, " + k / 2 + ") was " + slow.d +
            ". Recursion depth: " + slow.i);

        PairDI fast= exp2Fast(.9999, k / 2);
        System.out.println("\nexp2Fast(.9999, " + k / 2 + ") was " + fast.d +
            ". Recursion depth: " + fast.i);

        fast= exp2Fast(.9999, k);
        System.out.println("\nexp2Fast(.9999, " + k + ") was " + fast.d +
            ". Recursion depth: " + fast.i);

        fast= exp2Fast(.9999, k - 1);
        System.out.println("\nexp2Fast(.9999, " + (k - 1) + ") was " + fast.d +
            ". Recursion depth: " + fast.i);
    }
}

/** An instance is a pair of values, one double and one int */
class PairDI {
    public double d;
    public int i;

    /** Constructor: an instance with double value d and int value i. */
    public PairDI(double d, int i) {
        this.d= d;
        this.i= i;
    }
}
