
package otrees;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class TreeTest {

	@Test
	/** Example of building a tree */
	void testTree() {
		/*<pre>
		           5
		         /   \
		        3     8
		       / \     \
		      7   2     6
		</pre>*/
		Tree<Integer> t7= new Node<>(7, new Empty<>(), new Empty<>());
		Tree<Integer> t2= new Node<>(2, new Empty<>(), new Empty<>());
		Tree<Integer> t6= new Node<>(6, new Empty<>(), new Empty<>());

		Tree<Integer> t3= new Node<>(3, t7, t2);
		Tree<Integer> t8= new Node<>(8, new Empty<>(), t6);

		Tree<Integer> t5= new Node<>(5, t3, t8);

		int[] b= { 5, 3, 8, 7, 2, 6 };
		int[] c= { 1, 4, 9, 10, 11 };
		for (int k= 0; k < b.length; k= k + 1) {
			assertEquals(true, t5.contains(b[k]));
		}

		for (Integer v : c) {
			assertEquals(false, t5.contains(v));
		}
		assertEquals(6, t5.size());

	}

}
