package linkedList;

import java.util.Iterator;
import java.util.NoSuchElementException;

/** An instance is a doubly linked list. */
public class DLList<E> implements Iterable<E> {
    /** Replace "-1" by the time you spent on A3 in hours.<br>
     * Example: for 3 hours 15 minutes, use 3.25<br>
     * Example: for 4 hours 30 minutes, use 4.50<br>
     * Example: for 5 hours, use 5 or 5.0 */
    public static double timeSpent= 1;

    /** Number of values in the linked list. */
    private int size;
    /** First and last nodes of the linked list (null if size is 0) */
    private Node head, tail;

    /** Constructor: an empty linked list. Do need to change this. */
    public DLList() {}

    /** = the number of values in this list. <br>
     * This function takes constant time. */
    public int size() {
        return size;
    }

    /** = the first node of the list (null if the list is empty). */
    public Node head() {
        return head;
    }

    /** = the last node of the list (null if the list is empty). */
    public Node tail() {
        return tail;
    }

    /** Return the value in node n of this list. <br>
     * Precondition: n is a node of this list; it may not be null. */
    public E value(Node n) {
        assert n != null;
        return n.val;
    }

    /** Return a representation of this list: its values, with<br>
     * "[" at the beginning, "]" at the end, and adjacent ones separated by ", " . <br>
     * Takes time proportional to the length of this list.<br>
     * E.g. for the list containing 4 7 8 in that order, the result it "[4, 7, 8]". <br>
     * E.g. for the list containing two empty strings, the result is "[, ]" */
    @Override
    public String toString() {
        var res= new StringBuilder("[");
        var n= head;
        // inv: res contains values of nodes before node n (all of them if n = null),
        // with ", " after each (except for the last value)
        while (n != null) {
            res.append(n.val);
            n= n.next;
            if (n != null) res.append(", ");
        }

        return res + "]";
    }

    /** Return a representation of this list: its values in reverse, with<br>
     * "[" at the beginning, "]" at the end, and adjacent ones separated by ", " . <br>
     * Note that toStringRev is the reverse of toString. <br>
     * Takes time proportional to the length of this list. <br>
     * E.g. for the list containing 4 7 8 in that order, the result is "[8, 7, 4]". <br>
     * E.g. for the list containing two empty strings, the result is "[, ]". */
    public String toStringRev() { // Note:
        // TODO 1. Look at toString to see how that was written.
        // Use the same scheme. Extreme case to watch out for:
        // E is String and values are the empty string.
        // You can't test this fully until #2, append, is written.
        var res= new StringBuilder("[");
        var n= tail;
        // inv: res contains values of nodes after node n (all of them if n = null),
        // with ", " after each (except for the last value)
        while (n != null) {
            res.append(n.val);
            n= n.prev;
            if (n != null) res.append(", ");
        }

        return res + "]";
    }

    /** Add v to the end of this list. <br>
     * This operation takes constant time.<br>
     * E.g. if the list is [8, 7, 4], append(2) changes this list to [8, 7, 4, 2]. */
    public void append(E v) {
        // TODO 2. After writing append, test append and toStringRev
        // thoroughly before starting on the next. These two must be correct
        // in order to be able to write and test all the others.
        tail= new Node(tail, v, null);
        if (size == 0) head= tail;
        else tail.prev.next= tail;
        size= size + 1;
    }

    /** Insert v at the beginning of the list. <br>
     * This operation takes constant time.<br>
     * E.g. if the list is [8, 7, 4], prepend(2) changes this list to [2, 8, 7, 4]. */
    public void prepend(E v) {
        // TODO 3. Write and test prepend thoroughly before moving on to TODO 4
        head= new Node(null, v, head);
        if (size == 0) tail= head;
        else head.next.prev= head;
        size= size + 1;
    }

    /** = node number k. <br>
     * Precondition: 0 <= k < size of the list. <br>
     * Note: If k is 0, return first node; if k = 1, return second node, ... */
    public Node node(int k) {
        // TODO 4. This method should take time proportional to min(k, size-h).
        // For example, if k < size/2, search from the beginning of the
        // list, otherwise search from the end of the list. If k = size/2,
        // search from either end; it doesn't matter.
        if (k <= size / 2) {
            var n= head;
            while (k > 0) {
                n= n.next;
                k= k - 1;
            }
            return n;
        }
        // Search from end of list
        var n= tail;
        while (k < size - 1) {
            n= n.prev;
            k= k + 1;
        }
        return n;
    }

    /** Insert value v in a new node after node n. <br>
     * This operation takes constant time. <br>
     * Precondition: n must be a node of this list; it may not be null.<br>
     * E.g. if the list is [3, 8, 2] and n points to the node with 8 in it, <br>
     * and v is 1, the list is changed to [3, 1, 8, 2] */
    public void insertBefore(Node n, E v) {
        // TODO 5. Make sure this method takes constant time.
        assert n != null;
        var no= new Node(n.prev, v, n);
        if (n.prev == null) head= no;
        else n.prev.next= no;
        n.prev= no;
        size= size + 1;
    }

    /** Remove node n from this list. <br>
     * This operation must take constant time. <br>
     * Precondition: n must be a node of this list; it may not be null. <br>
     * E.g. if the list is [3, 8, 2] and n points to the node with 3 in it, <br>
     * the list is changed to [8, 2] */
    public void delete(Node n) {
        // TODO 6. Make sure this method takes constant time.
        assert n != null;
        if (n.prev == null) head= n.next;
        else n.prev.next= n.next;

        if (n.next == null) tail= n.prev;
        else n.next.prev= n.prev;

        n.prev= null;
        n.next= null;
        size= size - 1;
    }

    /*********************/

    /** An instance is a node of this list. */
    class Node {
        /** The value in the node */
        private E val;
        /** Previous node on list (null if this is first node) and<br>
         * Next node on list (null if this is last node). */
        private Node prev, next;

        /** Constructor: an instance with previous node p (can be null), value v,<br>
         * and next node s (can be null). */
        Node(Node p, E v, Node s) {
            prev= p;
            val= v;
            next= s;
        }

        /** = the previous node (null if this is the first node of the list). */
        Node prev() {
            return prev;
        }

        /** = the value of this node. */
        E value() {
            return val;
        }

        /** = the next node in this list (null if this is the last node of this list). */
        Node next() {
            return next;
        }
    }

    /** An instance is an iterator over this list */
    private class DLListIterator implements Iterator<E> {
        Node currNode= head;

        public DLListIterator() {}

        @Override
        public boolean hasNext() {
            return currNode != null;

        }

        @Override
        public E next() {
            if (!hasNext()) throw new NoSuchElementException();
            E temp= currNode.val;
            currNode= currNode.next;
            return temp;
        }
    }

    /** Return an Iterator over the elements of this list. */
    @Override
    public Iterator<E> iterator() {
        return new DLListIterator();
    }

}
