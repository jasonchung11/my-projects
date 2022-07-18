import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class BinTreeTest {

    @Test
    void testConstructors() {
        /** Testing is more complicated than for linked list because<br>
         * it takes more work to construct trees with which to test. */
        BinTree<Integer> t1= new BinTree<>(8);
        assertEquals(8, t1.value());
        assertEquals(null, t1.left());
        assertEquals(null, t1.right());

        // We construct this tree: and test its three values and size
        // ... 5
        // .. / \
        // . 8 . 4

        BinTree<Integer> t2= new BinTree<>(4);
        BinTree<Integer> t3= new BinTree<>(5, t1, t2);
        assertEquals(5, t3.value());
        assertEquals(8, t3.left().value());
        assertEquals(4, t3.right().value());
        assertEquals(3, t3.size());
    }

    /** Return a tree that looks like this:
     *
     * <pre>
     *        5
     *      /   \
     *     8     9
     *      \   / \
     *       4 2   7
     * </pre>
     */
    private BinTree<Integer> makeTree() {
        BinTree<Integer> t4= new BinTree<>(4);
        BinTree<Integer> t2= new BinTree<>(2);
        BinTree<Integer> t7= new BinTree<>(7);
        BinTree<Integer> t8= new BinTree<>(8, null, t4);
        BinTree<Integer> t9= new BinTree<>(9, t2, t7);
        BinTree<Integer> t5= new BinTree<>(5, t8, t9);
        return t5;
    }

    @Test
    void testSize() {
        BinTree<Integer> t= makeTree();
        // Test that all values in b are in t.
        assertEquals(6, t.size());
    }

    @Test
    void testContains() {
        // The following code checks that the tree t made using makeTree()
        // contains all the values that it should. It really can't have
        // any others since t's size is 6 --we check that. This checks
        // contains and gives us a good indication that the contructors are correct
        BinTree<Integer> t= makeTree();
        Integer[] b= { 5, 8, 9, 4, 2, 7 };
        for (Integer v : b) {
            assertTrue(t.contains(v));
        }
        assertFalse(t.contains(0));
        assertFalse(t.contains(10));
    }

}
