package linkedList;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class DLListTest {

    @Test
    public void testConstructor() {
        var c= new DLList<Integer>();
        assertEquals("[]", c.toString());
        assertEquals("[]", c.toStringRev());
        assertEquals(0, c.size());
    }

    @Test
    public void testAppendAndToStringRev() {
        var dl= new DLList<String>();
        dl.append("1");
        assertEquals("[1]", dl.toString());
        assertEquals("[1]", dl.toStringRev());
        assertEquals(1, dl.size());

        dl.append("2");
        assertEquals("[1, 2]", dl.toString());
        assertEquals("[2, 1]", dl.toStringRev());
        assertEquals(2, dl.size());

        dl.append("3");
        assertEquals("[1, 2, 3]", dl.toString());
        assertEquals("[3, 2, 1]", dl.toStringRev());
        assertEquals(3, dl.size());
    }

    @Test
    public void testPrepend() {
        var dl= new DLList<String>();
        dl.prepend("CS2110");
        assertEquals("[CS2110]", dl.toString());
        assertEquals("[CS2110]", dl.toStringRev());
        assertEquals(1, dl.size());

        dl.prepend("ENGRD2110");
        assertEquals("[ENGRD2110, CS2110]", dl.toString());
        assertEquals("[CS2110, ENGRD2110]", dl.toStringRev());
        assertEquals(2, dl.size());

        dl.prepend("ff");
        assertEquals("[ff, ENGRD2110, CS2110]", dl.toString());
        assertEquals("[CS2110, ENGRD2110, ff]", dl.toStringRev());
        assertEquals(3, dl.size());
    }

    @Test
    public void testNode() {
        var dl= new DLList<Integer>();
        for (var k= 20; 0 <= k; k= k - 1) dl.append(k);
        System.out.println(dl);
        for (var k= 0; k <= 20; k= k + 1) {
            assertEquals(20 - k, dl.node(k).value());

        }
    }

    @Test
    public void testinsertBefore() {
        var dl= new DLList<Integer>();
        dl.append(5);
        dl.insertBefore(dl.head(), 7);
        assertEquals("[7, 5]", dl.toString());
        assertEquals("[5, 7]", dl.toStringRev());
        assertEquals(2, dl.size());

        dl= new DLList<>();
        dl.append(5);
        dl.append(7);
        dl.insertBefore(dl.tail(), 6);
        assertEquals("[5, 6, 7]", dl.toString());
        assertEquals("[7, 6, 5]", dl.toStringRev());
        assertEquals(3, dl.size());

        dl= new DLList<>();
        dl.append(5);
        dl.append(6);
        dl.insertBefore(dl.head(), 7);
        assertEquals("[7, 5, 6]", dl.toString());
        assertEquals("[6, 5, 7]", dl.toStringRev());
        assertEquals(3, dl.size());
    }

    @Test
    public void testDelete() {
        var dl= new DLList<Integer>();
        dl.append(5);
        dl.delete(dl.head());
        assertEquals("[]", dl.toString());
        assertEquals("[]", dl.toStringRev());
        assertEquals(0, dl.size());

        dl= new DLList<>();
        dl.append(5);
        dl.append(6);
        dl.delete(dl.head());
        assertEquals("[6]", dl.toString());
        assertEquals("[6]", dl.toStringRev());
        assertEquals(1, dl.size());

        dl= new DLList<>();
        dl.append(5);
        dl.append(6);
        dl.delete(dl.tail());
        assertEquals("[5]", dl.toString());
        assertEquals("[5]", dl.toStringRev());
        assertEquals(1, dl.size());

        dl= new DLList<>();
        dl.append(5);
        dl.append(6);
        dl.append(7);
        dl.delete(dl.head().next());
        assertEquals("[5, 7]", dl.toString());
        assertEquals("[7, 5]", dl.toStringRev());
        assertEquals(2, dl.size());
    }

    @Test
    public void testIterator() {
        // Make a list of the integers in 10..19
        var d= new DLList<Integer>();
        for (var k= 0; k < 10; k= k + 1) {
            d.append(k + 10);
        }

        // Test that the list contains 10..19
        var dit= d.iterator();
        var k= 0;
        while (dit.hasNext()) {
            assertEquals((Integer) (k + 10), dit.next());
            k= k + 1;
        }
        // Test that the loop stopped at the right place

        assertEquals(10, k);
    }

    @Test
    public void testIterable() {
        // Make a list (0, 1, 2, 3, 4, 5, 6, 7, 8, 9)
        var d= new DLList<Integer>();
        for (var k= 0; k < 10; k= k + 1) {
            d.append(k);
        }

        // Check that the foreach loop enumerates the ints in 0..9.
        var tt= 0;
        for (int ob : d) {
            assertEquals(tt, ob);
            tt= tt + 1;
        }
    }

}
