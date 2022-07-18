package DemoAnonymous;

/** Demo of an anonymous function */
public class Check {
    public static void main(String[] pars) {
        int[] c1= { 3, 5, 7, -9 };
        int[] c2= { 3, 5, 7, 10 };
        int[] c3= { 1, 2, 4, 16, 64 };

        System.out.println("All elements c1 are odd: " + check(c1, v -> v % 2 == 1));
        System.out.println("All elements of c2 are odd: " + check(c2, v -> v % 2 == 1));
        System.out.println("All elements of c1 are positive: " + check(c1, v -> v > 0));
        System.out.println("All elements of c2 are positive: " + check(c2, v -> v > 0));
        System.out.println("All elements of c2 are powers of 2: " + check(c2, v -> isPowerOf2(v)));
        System.out.println("All elements of c3 are powers of 2: " + check(c3, v -> isPowerOf2(v)));
    }

    /** Return true iff every element b[k] satisfies p, <br>
     * i.e. p(b[k]) is true. */
    public static boolean check(int[] b, Pred p) {
        for (int k= 0; k < b.length; k= k + 1) {
            if (!p.test(b[k])) return false;
        }
        return true;
    }

    /** Return true iff v is a power of 2. */
    public static boolean isPowerOf2(int b) {
        if (b <= 0) return false;
        // invariant: The original b is a power of 2 iff the current b is.
        while (b % 2 == 0) b= b / 2;
        return b == 1;
    }

}

@FunctionalInterface   // An annotation, like @Override
/** An interface with one abstract method. */
interface Pred {
    boolean test(int k);
}

// String toString();
// boolean test1(int k);
