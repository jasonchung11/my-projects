import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class BSTTest {

	@Test
	/** Construct a BST of n nodes that is really only a linked list.<br>
	 * Check that all n values are in it and that one value is not in it.<br>
	 * Then call a contains method with a value that is not in the BST<br>
	 * and see how many recursive calls it makes --it's about n! */
	void testBST() {
		int n= 1000;
		// Build a BST t with values 0..n
		BST t= new BST(0);
		for (int k= 1; k <= n; k= k + 1) {
			t.insert(k);
		}

		assertEquals(n + 1, t.size());
		// Check that t contains the values 0..n
		for (int k= 0; k <= n; k= k + 1) {
			assertEquals(true, t.contains(k));
		}
		assertEquals(false, t.contains(n + 20));

		// We wrote a method containsCalls that is like contains but it also
		// returns the number of recursive calls.
		// Example: if it returns 20, that means the value is in the BST and it
		// took 20 recursive calls to find it
		// Example: if it returns -60, that means the value is NOT in the BST and it
		// took 60 recursive calls to find out that the value is not in,
		// Above, change n to 1000, and you see that the number of recursive calls
		// is 1001 to find out that the value is not in. This is an indicate
		// that the constructed BST is really like a linked list, with number of values
		// 1000.
		System.out.println("Number of recursive calls unbalanced BST: of size " +
			n + ": " + Math.abs(t.containsCalls(n + 2)));
	}

	@Test
	/** Construct a balanced BST of n nodes and <br>
	 * check that all n values are in it, check the trees size, and<br>
	 * check that one value is not in the BST. To create the balanced tree, we use a recursive
	 * method BST.sortedArrayToBST. Study it.
	 *
	 * We wrote a method containsCalls that is like contains but it also<br>
	 * returns the number of recursive calls. <br>
	 * Example: if it returns 20, that means the value is in the BST and it <br>
	 * took 20 recursive calls to find it <br>
	 * Example: if it returns -60, that means the value is NOT in the BST and it <br>
	 * took 60 recursive calls to find out that the value is not in. */
	void testBST2() {
		int n= 30000;
		int[] b= new int[n];
		for (int k= 0; k < n; k= k + 1) {
			b[k]= k;
		}

		BST t= BST.sortedArrayToBST(b, 0, n - 1);

		for (int k= 0; k < n; k= k + 1) {
			assertEquals(true, t.contains(k));
		}

		assertEquals(n, t.size());
		assertEquals(false, t.contains(n + 2));

		// Look at the number of recursive calls for a blanced BST!
		System.out.println("Number of recursive calls balanced BST: of size " +
			n + ": " + Math.abs(t.containsCalls(n + 2)));
	}

}
