package linkedList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class DLListTest {

    @Test
    public void testConstructor() {
        DLList<Integer> d= new DLList<>();
        assertEquals("[]", d.toString());
        assertEquals("[]", d.toStringRev());
        assertEquals(0, d.size());
    }

    @Test
    public void testAppendAndToStringRev() {
        DLList<String> dl= new DLList<>();
        dl.append("2110");
        assertEquals("[2110]", dl.toString());
        assertEquals("[2110]", dl.toStringRev());
        assertEquals(1, dl.size());
        dl.append("CS");
        assertEquals("[2110, CS]", dl.toString());
        assertEquals("[CS, 2110]", dl.toStringRev());
        assertEquals(2, dl.size());
        dl.append("Computer Science");
        assertEquals("[2110, CS, Computer Science]", dl.toString());
        assertEquals("[Computer Science, CS, 2110]", dl.toStringRev());
        assertEquals(3, dl.size());
        dl.append("Sick");
        assertEquals("[2110, CS, Computer Science, Sick]", dl.toString());
        assertEquals("[Sick, Computer Science, CS, 2110]", dl.toStringRev());
        assertEquals(4, dl.size());
        dl.append("");
        assertEquals("[2110, CS, Computer Science, Sick, ]", dl.toString());
        assertEquals("[, Sick, Computer Science, CS, 2110]", dl.toStringRev());
        assertEquals(5, dl.size());
        DLList<String> dl1= new DLList<>();
        dl1.append("");
        assertEquals("[]", dl1.toString());
        assertEquals("[]", dl1.toStringRev());
        assertEquals(1, dl1.size());
    }

    @Test
    public void testPrepend() {
        DLList<String> dl= new DLList<>();
        dl.prepend("Jason");
        assertEquals("[Jason]", dl.toString());
        assertEquals("[Jason]", dl.toStringRev());
        assertEquals(1, dl.size());
        dl.prepend("Chung");
        assertEquals("[Chung, Jason]", dl.toString());
        assertEquals("[Jason, Chung]", dl.toStringRev());
        assertEquals(2, dl.size());
        dl.prepend("Student");
        assertEquals("[Student, Chung, Jason]", dl.toString());
        assertEquals("[Jason, Chung, Student]", dl.toStringRev());
        assertEquals(3, dl.size());
        dl.prepend("The");
        assertEquals("[The, Student, Chung, Jason]", dl.toString());
        assertEquals("[Jason, Chung, Student, The]", dl.toStringRev());
        assertEquals(4, dl.size());
        dl.prepend("");
        assertEquals("[, The, Student, Chung, Jason]", dl.toString());
        assertEquals("[Jason, Chung, Student, The, ]", dl.toStringRev());
        assertEquals(5, dl.size());
    }

    @Test
    public void testNode() {
        DLList<String> dl= new DLList<>();
        assertThrows(AssertionError.class, () -> { dl.node(1); });
        assertThrows(AssertionError.class, () -> { dl.node(0); });
        assertThrows(AssertionError.class, () -> { dl.node(-1); });
        dl.append("2110");
        assertEquals("[2110]", dl.toString());
        assertEquals("[2110]", dl.toStringRev());
        assertEquals(1, dl.size());
        dl.append("CS");
        assertEquals("[2110, CS]", dl.toString());
        assertEquals("[CS, 2110]", dl.toStringRev());
        assertEquals(2, dl.size());
        dl.append("Computer Science");
        assertEquals("[2110, CS, Computer Science]", dl.toString());
        assertEquals("[Computer Science, CS, 2110]", dl.toStringRev());
        assertEquals(3, dl.size());
        dl.append("Sick");
        assertEquals("[2110, CS, Computer Science, Sick]", dl.toString());
        assertEquals("[Sick, Computer Science, CS, 2110]", dl.toStringRev());
        assertEquals(4, dl.size());
        DLList<String>.Node node0= dl.head();
        DLList<String>.Node node1= dl.head().next();
        DLList<String>.Node node2= dl.tail().prev();
        DLList<String>.Node node3= dl.tail();
        assertEquals(node0, dl.node(0));
        assertEquals(node1, dl.node(1));
        assertEquals(node2, dl.node(2));
        assertEquals(node3, dl.node(3));
        assertThrows(AssertionError.class, () -> { dl.node(4); });
        assertThrows(AssertionError.class, () -> { dl.node(-1); });

    }

    @Test
    public void testInsertBefore() {
        DLList<String> dl= new DLList<>();
        dl.append("2110");
        assertEquals("[2110]", dl.toString());
        assertEquals("[2110]", dl.toStringRev());
        assertEquals(1, dl.size());
        assertThrows(AssertionError.class, () -> { dl.insertBefore(null, "Hello World"); });
        dl.insertBefore(dl.node(0), "CS");
        assertEquals(2, dl.size());
        assertEquals("[CS, 2110]", dl.toString());
        assertEquals("[2110, CS]", dl.toStringRev());
        dl.insertBefore(dl.node(1), "Computer Science");
        assertEquals(3, dl.size());
        assertEquals("[CS, Computer Science, 2110]", dl.toString());
        assertEquals("[2110, Computer Science, CS]", dl.toStringRev());
        dl.insertBefore(dl.node(2), "Fun");
        assertEquals(4, dl.size());
        assertEquals("[CS, Computer Science, Fun, 2110]", dl.toString());
        assertEquals("[2110, Fun, Computer Science, CS]", dl.toStringRev());
        dl.insertBefore(dl.node(1), "");
        assertEquals(5, dl.size());
        assertEquals("[CS, , Computer Science, Fun, 2110]", dl.toString());
        assertEquals("[2110, Fun, Computer Science, , CS]", dl.toStringRev());
    }

    @Test
    public void testDelete() {
        DLList<String> dl= new DLList<>();
        dl.append("2110");
        assertEquals("[2110]", dl.toString());
        assertEquals("[2110]", dl.toStringRev());
        assertEquals(1, dl.size());
        dl.delete(dl.node(0));
        assertEquals("[]", dl.toString());
        assertEquals("[]", dl.toStringRev());
        assertEquals(0, dl.size());
        dl.append("2110");
        assertEquals("[2110]", dl.toString());
        assertEquals("[2110]", dl.toStringRev());
        assertEquals(1, dl.size());
        dl.append("CS");
        assertEquals("[2110, CS]", dl.toString());
        assertEquals("[CS, 2110]", dl.toStringRev());
        assertEquals(2, dl.size());
        dl.delete(dl.node(1));
        assertEquals("[2110]", dl.toString());
        assertEquals("[2110]", dl.toStringRev());
        assertEquals(1, dl.size());
        dl.append("CS");
        assertEquals("[2110, CS]", dl.toString());
        assertEquals("[CS, 2110]", dl.toStringRev());
        assertEquals(2, dl.size());
        dl.append("Computer Science");
        assertEquals("[2110, CS, Computer Science]", dl.toString());
        assertEquals("[Computer Science, CS, 2110]", dl.toStringRev());
        assertEquals(3, dl.size());
        dl.delete(dl.node(0));
        assertEquals("[CS, Computer Science]", dl.toString());
        assertEquals("[Computer Science, CS]", dl.toStringRev());
        assertEquals(2, dl.size());
        dl.append("2110");
        assertEquals("[CS, Computer Science, 2110]", dl.toString());
        assertEquals("[2110, Computer Science, CS]", dl.toStringRev());
        assertEquals(3, dl.size());
        dl.append("Jason");
        assertEquals("[CS, Computer Science, 2110, Jason]", dl.toString());
        assertEquals("[Jason, 2110, Computer Science, CS]", dl.toStringRev());
        assertEquals(4, dl.size());
        dl.delete(dl.node(1));
        assertEquals("[CS, 2110, Jason]", dl.toString());
        assertEquals("[Jason, 2110, CS]", dl.toStringRev());
        assertEquals(3, dl.size());
        dl.append("Chung");
        assertEquals("[CS, 2110, Jason, Chung]", dl.toString());
        assertEquals("[Chung, Jason, 2110, CS]", dl.toStringRev());
        assertEquals(4, dl.size());
        dl.append("");
        assertEquals("[CS, 2110, Jason, Chung, ]", dl.toString());
        assertEquals("[, Chung, Jason, 2110, CS]", dl.toStringRev());
        assertEquals(5, dl.size());
        dl.delete(dl.node(4));
        assertEquals("[CS, 2110, Jason, Chung]", dl.toString());
        assertEquals("[Chung, Jason, 2110, CS]", dl.toStringRev());
        assertEquals(4, dl.size());
        assertThrows(AssertionError.class, () -> { dl.delete(null); });
    }

}
