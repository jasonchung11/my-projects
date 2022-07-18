import java.util.*;

/** Demo complexity issues */
public class Complexity {
    
    /** Print the time it takes to add the numbers 1..n together. */
    public static void add(int n) {
        long begin= new Date().getTime();
        long sum= 0;
        for (int k= 1; k <= n; k= k+1) {
            sum= sum + k;
        }
        long end= new Date().getTime();
        System.out.println("time is: " + (end - begin) + " milliseconds");
    }
    
        /** Print the time it takes to catenate 'c' to itself n times,
          * the number of array elements create, andthe value n(n+1)/2. */
    public static void cat(int n) {
        long begin= new Date().getTime();
        String s= "";
        int m= 0;
        // invariant: k = number of catenations done to s,
        //            m = number of array elements created.
        for (int k= 1; k <= n; k= k+1) {
            s= s + 'c';
            m= m + s.length();
        }
        long end= new Date().getTime();
        System.out.println("time is: " + (end - begin) + " milliseconds");
        System.out.println("Array elements created: " + m);
        System.out.println("n: " + n + ", n*(n+1)/2: " + (n*(n+1)/2));
    }
}
