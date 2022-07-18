import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SumsTest {

	@Test
	void testSplit() {
		assertEquals(true, Sums.split(new int[] {}));
		assertEquals(true, Sums.split(new int[] { 0 }));
		assertEquals(false, Sums.split(new int[] { 0, 1 }));
		assertEquals(false, Sums.split(new int[] { 1, 0 }));

		assertEquals(true,
			Sums.split(new int[] { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 }));
		assertEquals(false,
			Sums.split(
				new int[] { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 }));
	}

	@Test
	void testSplitCountFalse() {
		System.out.println("\nCalls for which split returns false. All values in the array are 1.");
		int b[]= new int[] { 1 };
		long r= Sums.splitCount(b);
		assertEquals(-3, r);
		printF(b, Math.abs(r));

		b= new int[] { 1, 1, 1 };
		r= Sums.splitCount(b);
		assertEquals(-15, r);
		printF(b, Math.abs(r));

		b= new int[] { 1, 1, 1, 1, 1 };
		r= Sums.splitCount(b);
		assertEquals(-63, r);
		printF(b, Math.abs(r));

		b= new int[] { 1, 1, 1, 1, 1, 1, 1 };
		r= Sums.splitCount(b);
		assertEquals(-255, r);
		printF(b, Math.abs(r));

		b= new int[] { 1, 1, 1, 1, 1, 1, 1, 1, 1 };
		r= Sums.splitCount(b);
		assertEquals(-1023, r);
		printF(b, Math.abs(r));

		b= new int[] { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 };
		r= Sums.splitCount(b);
		assertEquals(-262143, r);
		printF(b, Math.abs(r));

		b= new int[] { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 };
		r= Sums.splitCount(b);
		assertEquals(-16777215, r);
		printF(b, Math.abs(r));

	}

	/** Print information about a call of splitCount:<br>
	 * (1) the size of array b,<br>
	 * (2) the number r of calls made, and (3) the value 2^(1 +b.length) - 1. */
	static void printF(int b[], long r) {
		int rc= (int) Math.pow(2, 1 + b.length) - 1;
		System.out
			.println("array size n: " + b.length + ". Calls: " + r + ". 2^(1+n) - 1: " + rc);
	}

	/** Print information about a call of splitCount:<br>
	 * (1) the size of array b,<br>
	 * (2) the number r of calls made, and (3) the value 2^(1 +b.length) - 1. */
	static void printT(int b[], long r) {
		int n= b.length;
		int rc= (int) Math.pow(2, n + 1) - 1;
		int rc2= (int) Math.pow(2, n / 2 + 1) + n / 2 - 1;
		System.out
			.println(
				"array size n: " + b.length + ". Calls: " + r + ". 2^(n/2+1) + n/2  - 1: " + rc2);
	}

	@Test
	void testSplitCountTrue() {
		// All these examples consist of b with b.length = n containing n 1's, with n even.
		// The first n/2 array elements are put in bag 1 and stay there.
		// The second n/2 array elements are also put in bag 1 but have to be moved to bag 2.
		// Thus, the first n/2 elements require n/2 recursive calls.
		// The last n/2 elements require 2^(n/2+1) - 1 recursive calls.
		System.out.println("\nCalls for which split returns true. All values in the array are 1.");

		int[] b= new int[] { 1, 1 };
		long r= Sums.splitCount(b);
		assertEquals(4, r);
		printT(b, Math.abs(r));

		b= new int[] { 1, 1, 1, 1 };
		r= Sums.splitCount(b);
		assertEquals(9, r);
		printT(b, Math.abs(r));

		b= new int[] { 1, 1, 1, 1, 1, 1 };
		r= Sums.splitCount(b);
		assertEquals(18, r);
		printT(b, Math.abs(r));

		b= new int[] { 1, 1, 1, 1, 1, 1, 1, 1 };
		r= Sums.splitCount(b);
		assertEquals(35, r);
		printT(b, Math.abs(r));

		b= new int[] { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 };
		r= Sums.splitCount(b);
		assertEquals(68, r);
		printT(b, Math.abs(r));
	}

}
