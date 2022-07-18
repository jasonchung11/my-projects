/** An instance a pair of values, one boolean and one int */
public class PairBi {
	public boolean b;
	public int i;

	public PairBi(boolean b, int i) {
		this.b= b;
		this.i= i;
	}

	@Override
	/** Return the pair in form .. */
	public String toString() {
		return "result: " + b + ", " + i + " recursive calls";
	}
}