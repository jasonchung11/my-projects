public class SierpinskiTriangle extends Turtle {
	static double sin60degrees= Math.sqrt(3.0) / 2;

	/** Draw some Sierpinski triangles */
	public static void main(String[] args) {
		SierpinskiTriangle t= new SierpinskiTriangle();
		t.drawSierpinski(100, 300, 125, 0);
		t.drawSierpinski(250, 300, 125, 1);
		t.drawSierpinski(400, 300, 125, 2);
		t.drawSierpinski(550, 300, 125, 3);
		t.drawSierpinski(325, 450, 200, 6);
	}

	/** draw a Sierpinski triangle of depth d and side length s <br>
	 * with the top point at (x, y) */
	public void drawSierpinski(double x, double y, double s, int d) {
		if (d == 0) {
			drawTriangle(x, y, s);
			return;
		}
		double yl= y + s * sin60degrees / 2;
		drawSierpinski(x, y, s / 2, d - 1); // top triangle
		drawSierpinski(x - s / 4, yl, s / 2, d - 1); // bottom left triangle
		drawSierpinski(x + s / 4, yl, s / 2, d - 1); // bottom right triangle
	}

}