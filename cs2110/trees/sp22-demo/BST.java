/** AN instance is a node of a BST. */
public class BST {
	/** The value in this node. */
	private int value;

	/** All values in left subtree are less than value. <br>
	 * All values in right subtree are greater than value. */
	private BST left, right;

	/** Constructor: a 1-node BST; it value is v. */
	public BST(int v) {
		value= v;
	}

	/** = the size (number of nodes) of this BST. */
	public int size() {
		return 1 +
			(left == null ? 0 : left.size()) +
			(right == null ? 0 : right.size());
	}

	/** = "this tree contains v" <br>
	 * ---it is the value of some node in this tree. */
	public boolean contains(int v) {
		if (v == value) return true;
		if (v < value) return left != null && left.contains(v);
		// v > value
		return right != null && right.contains(v);
	}

	/** Return number of recursive calls if v in BST,<br>
	 * Return - number of recursive calls if v not in BST */
	public int containsCalls(int v) {
		if (v == value) return 1;
		if (v < value) {
			if (left == null) return -1;
			int b= left.containsCalls(v);
			return b >= 0 ? b + 1 : b - 1;
		}
		// i > 0
		if (right == null) return -1;
		int b= right.containsCalls(v);
		return b >= 0 ? b + 1 : b - 1;
	}

	/** Insert v into this BST if it is not in already. */
	public void insert(int v) {
		if (v == value) return;
		if (v < value) {
			if (left == null) left= new BST(v);
			else left.insert(v);
			return;
		}
		// v > value
		if (right == null) right= new BST(v);
		else right.insert(v);
	}

	/** Return a Balanced BST with values from sorted b[h..k] */
	public static BST sortedArrayToBST(int b[], int h, int k) {
		// Base Case
		if (h > k) return null; // no values to insert

		// Make the root the middle value of b[h..k]
		int mid= (h + k) / 2;
		BST root= new BST(b[mid]);

		// Construct the left subtree, consisting of b[h..mid-1]
		// and make it the left child of root
		root.left= sortedArrayToBST(b, h, mid - 1);

		// Construct the right subtree, consisting of b[mid+1..k]
		// and make it the right child of root
		root.right= sortedArrayToBST(b, mid + 1, k);

		return root;
	}

}
