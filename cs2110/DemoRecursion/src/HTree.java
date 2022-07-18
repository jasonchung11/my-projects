
public class HTree extends Turtle {
	public static void main(String[] args) {
		HTree t= new HTree();
		t.Htree(100, 200, 0, 50);
		t.Htree(200, 200, 1, 50);
		t.Htree(340, 200, 2, 70);
		t.Htree(520, 200, 3, 80);
	}

	/** draw an H-tree of depth d and size s with center (x, y). <br>
	 * Precondition: d >= 0 and s > 0 and pen is down. */
	public void Htree(double x, double y, int d, double s) {
		drawH(x, y, s);
		if (d == 0) return;
		Htree(x + -s / 2, y + -s / 2, d - 1, s / 2);
		Htree(x + s / 2, y + -s / 2, d - 1, s / 2);
		Htree(x + -s / 2, y + s / 2, d - 1, s / 2);
		Htree(x + s / 2, y + s / 2, d - 1, s / 2);

	}

	/** Draw an H at center (x, y) of size s. */
	public void drawH(double x, double y, double s) {
		// Compute the coordinates of the 4 tips of the H
		double x0= x - s / 2;
		double x1= x + s / 2;
		double y0= y - s / 2;
		double y1= y + s / 2;

		// draw the 3 line segments of the H
		drawLine(x0, y0, x0, y1); // left vertical segment of the H
		drawLine(x1, y0, x1, y1); // right vertical segment of the H
		drawLine(x0, y, x1, y);   // connect the two vert

	}
}
