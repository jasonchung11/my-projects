package otrees;

public class Empty<T> implements Tree<T> {

	@Override
	/** The number of nodes in this tree. */
	public int size() {
		return 0;
	}

	@Override
	/** = "This tree contains v. */
	public boolean contains(T v) {
		return false;
	}
}