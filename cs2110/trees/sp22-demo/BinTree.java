/** An instance is a (node of) a binary tree */
public class BinTree<T> {
    /** Value in the node. */
    private T value;
    /** The node's left and right children (null if none) */
    private BinTree<T> left, right;

    /** Constructor: A one-node tree with value v */
    public BinTree(T v) {
        value= v;
    }

    /** Constructor: a tree with root value v, left child<br>
     * left, and right child right. */
    public BinTree(T v, BinTree<T> left, BinTree<T> right) {
        value= v;
        this.left= left;
        this.right= right;
    }

    /** = the value of the root of this tree. */
    public T value() {
        return value;
    }

    /** = the left subtree of this tree <br>
     * --- null if empty. */
    public BinTree<T> left() {
        return left;
    }

    /** = the right subtree of this tree <br>
     * --- null if empty. */
    public BinTree<T> right() {
        return right;
    }

    /** = the size (number of nodes) of this tree. */
    public int size() {
        return 1 + (left == null ? 0 : left.size()) +
            (right == null ? 0 : right.size());
    }

    /** = "v is the value of some node of this tree. */
    public boolean contains(T v) {
        return value == v ||
            left != null && left.contains(v) ||
            right != null && right.contains(v);
    }

}
