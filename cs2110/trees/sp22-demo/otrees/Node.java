package otrees;

/** A tree with a root and left and right subtrees. */
public class Node<T> implements Tree<T> {
	private T value;
	private Tree<T> left, right; // not null

	/** Constructor: Tree with root value v, left tree l, and right tree r.<br>
	 * Precondition: l and r are not null. */
	Node(T v, Tree<T> l, Tree<T> r) {
		assert l != null && r != null;
		value= v;
		left= l;
		right= r;
	}

	/** = value in this node. */
	public T value() {
		return value;
	}

	/** = left subtree of this node. */
	public Tree<T> left() {
		return left;
	}

	/** = right subtree of this node. */
	public Tree<T> right() {
		return right;
	}

	@Override
	/** The number of nodes in this tree. */
	public int size() {
		return 1 + left.size() + right.size();
	}

	@Override
	/** = "This tree contains v. */
	public boolean contains(T v) {
		return value.equals(v) || left.contains(v) || right.contains(v);
	}
}
