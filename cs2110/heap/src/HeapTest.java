import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

class HeapTest {

    @Test
    /** Test the constructor */
    public void testConstructorAndOneAdd() {
        Heap mh= new Heap();
        assertEquals("[]", mh.toString());
        assertEquals(0, mh.size());

        mh.add(5, 5.0);
        assertEquals("[(5, 5.0)]", mh.toString());
        assertEquals(1, mh.size());
    }

    @Test
    /** Test add with no duplicate priorities. */
    public void testAddAndBubbleUp() {
        Heap mh= new Heap();
        mh.add(5, 5.0);
        assertEquals("[5.0]", mh.toStringPriorities());
        assertEquals(1, mh.size());

        mh.add(7, 6.0);
        assertEquals("[5.0, 6.0]", mh.toStringPriorities());
        assertEquals(2, mh.size());

        mh.add(5, 3.5);
        assertEquals("[3.5, 6.0, 5.0]", mh.toStringPriorities());
        assertEquals(3, mh.size());

        mh.add(10, 0.5);
        assertEquals("[0.5, 3.5, 5.0, 6.0]", mh.toStringPriorities());
        assertEquals(4, mh.size());

        mh.add(1, 9.2);
        assertEquals("[0.5, 3.5, 5.0, 6.0, 9.2]", mh.toStringPriorities());
        assertEquals(5, mh.size());

        mh.add(8, 2.0);
        assertEquals("[0.5, 3.5, 2.0, 6.0, 9.2, 5.0]",
            mh.toStringPriorities());
        assertEquals(6, mh.size());

        mh.add(0, 0.0);
        assertEquals("[0.0, 3.5, 0.5, 6.0, 9.2, 5.0, 2.0]",
            mh.toStringPriorities());
        assertEquals(7, mh.size());
    }

    @Test
    /** Test bubbleDown all 0-step or 1-step bubbles. In these tests, we allow ourselves to change
     * the priority of an item. Note that class Item and its fields have default access modifier
     * "protected" to allow this. */
    public void testBubbleDown01() {
        Heap mh= new Heap();
        mh.add(1, 1.0); /*        1.0      */
        mh.add(3, 3.0); /*   3.0           */
        mh.bubbleDown(0);
        assertEquals("[1.0, 3.0]", mh.toStringPriorities());

        mh= new Heap();
        mh.add(1, 1.0); /*        1.0      */
        mh.add(3, 3.0); /*   3.0           */
        mh.b[0].priority= 6.0;
        mh.bubbleDown(0);
        assertEquals("[3.0, 6.0]", mh.toStringPriorities());

        mh= new Heap();
        mh.add(1, 1.0); /*        1.0      */
        mh.add(3, 3.0); /*   3.0      5.0 */
        mh.add(5, 5.0);
        mh.b[0].priority= 6.0;
        mh.bubbleDown(0);
        assertEquals("[3.0, 6.0, 5.0]", mh.toStringPriorities());

        mh= new Heap();
        mh.add(1, 1.0); /*        1.0      */
        mh.add(5, 5.0); /*   5.0      3.0 */
        mh.add(3, 3.0);
        mh.b[0].priority= 6.0;
        mh.bubbleDown(0);
        assertEquals("[3.0, 5.0, 6.0]", mh.toStringPriorities());

        mh= new Heap();
        mh.add(1, 1.0); /*          1.0      */
        mh.add(3, 3.0); /*      3.0      3.0  */
        mh.add(3, 3.0);
        mh.b[0].priority= 6.0;
        mh.bubbleDown(0);
        assertEquals("[3.0, 6.0, 3.0]", mh.toStringPriorities());

        // The following test makes sure that no swap occurs if priorities are equal.
        mh= new Heap();
        mh.add(1, 1.0); /*           1,1.0      */
        mh.add(3, 3.0); /*      3,3.0      4,4.0  */
        mh.add(4, 4.0);
        mh.b[0].priority= 3.0;
        mh.bubbleDown(0);
        assertEquals("[(1, 3.0) (3, 3.0) (4, 4.0)]", mh.toString());
    }

    @Test
    /** Test longer bubbleDown. In these tests, we allow ourselves to <br>
     * change the priority of an item. Note that class Item and its fields have <br>
     * default access modifier "protected" to allow this. */
    public void testBubbleDown() {
        Heap mh= new Heap();
        mh.add(1, 1.0); /*            1.0      */
        mh.add(3, 3.0); /*      3.0          5.0   */
        mh.add(5, 5.0); /*   5.1   6.0    5.0   7.0  */
        mh.add(5, 5.1); /* 8.0                        */
        mh.add(6, 6.0);
        mh.add(5, 5.0);
        mh.add(7, 7.0);
        mh.add(8, 8.0);
        mh.b[0].priority= 6.3;
        mh.bubbleDown(0);
        assertEquals("[3.0, 5.1, 5.0, 6.3, 6.0, 5.0, 7.0, 8.0]", mh.toStringPriorities());

    }

    @Test
    /** Test peek. */
    public void testPeek() {
        Heap mh= new Heap();
        mh.add(3, 3.0);
        assertEquals(3, mh.peek());
        mh.add(1, 1.0);
        assertEquals(1, mh.peek());
        mh.add(-5, -5.0);
        assertEquals(-5, mh.peek());
    }

    @Test
    /** Test poll with no duplicates. */
    public void testPoll() {
        Heap<Integer> mh= new Heap<>();
        mh.add(5, 5.0);
        int res= mh.poll();
        assertEquals(5, res);
        assertEquals("[]", mh.toStringPriorities());
        assertEquals(0, mh.size());

        mh= new Heap();
        mh.add(3, 3.0);
        mh.add(5, 5.0);
        res= mh.poll();
        assertEquals(3, res);
        assertEquals("[5.0]", mh.toStringPriorities());
        assertEquals(1, mh.size());

        mh= new Heap();
        mh.add(3, 3.0);
        mh.add(5, 5.0);
        mh.add(7, 7.0);
        res= mh.poll();
        assertEquals(3, res);
        assertEquals("[5.0, 7.0]", mh.toStringPriorities());
        assertEquals(2, mh.size());

        mh= new Heap();
        mh.add(3, 3.0);
        mh.add(7, 7.0);
        mh.add(5, 5.0);
        res= mh.poll();
        assertEquals(3, res);
        assertEquals("[5.0, 7.0]", mh.toStringPriorities());
        assertEquals(2, mh.size());

        int[] b= new int[] { 0, 1, 2, 3, 7, 6, 4, 5, 8, 9, 10, 11, 15, 14, 13, 12 };
        mh= new Heap();
        for (int k= 0; k < b.length; k= k + 1) {
            mh.add(b[k], b[k]);
        }

        for (int k= 0; k < b.length; k= k + 1) {
            int val= mh.poll();
            assertEquals(k, val);
        }
    }

}
