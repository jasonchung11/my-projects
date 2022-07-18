package otrees;

/** A more object-oriented implementation of trees: <br>
 * Use subclasses to implement different behavior<br>
 * of empty vs. non-empty trees.<br>
 * This interface has been cut to the bare minimum needed <br>
 * to illustrate the more OO approach. */
public interface Tree<T> {
	/** The number of nodes in this tree. */
	int size();

	/** = "This tree contains v. */
	boolean contains(T v);
}
