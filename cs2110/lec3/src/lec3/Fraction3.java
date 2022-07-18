package lec3;

public class Fraction3 {
    /** The numerator */
    private int num;
    
    /**
     *  The denominator. May not be 0.
     *  The GCD of num and den must be 1, i.e. the fraction must be in reduced form.
     */
    private int den;
    
    /**
     * Constructor: a fraction with numerator n and denominator d.
     * Precondition: d may not be 0
     */
    public Fraction3(int n, int d) {
        assert d != 0;
        num= n;
        den= d;
        reduce();
    }
    
    /** Constructor: a fraction with numerator n and denominator 1. */
    public Fraction3(int n) {
        this(n, 1);
    }
    
    /** Make this fraction to be in reduced form. */
    private void reduce() {
        int g= gcd(num, den);
        num= num / g;
        den= den / g;
    }
    
    /** Return a representation of this fraction as a double. */
    public double toDouble() {
        return (double) num / den;
    }
    
    /** Print this function to standard out. */
    public void print() {
        System.out.println(num + "/" + den);
    }
    
    /** Add f into this fraction. */
    public void add(Fraction3 f) {
        num= num * f.den + f.num * den;
        den = den * f.den;
        reduce();
    }
    
    /** Return the GCD of a and b. */
    private int gcd(int a, int b) {
        while (b != 0) {
            int c= b;
            b= a % b;
            a= c;
        }
        return a;
    }
}
