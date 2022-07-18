
public class GrislySnowflake extends Turtle {

	public static void main(String[] args) {
		GrislySnowflake t= new GrislySnowflake();
		t.grislySnowflake(150, 200, 0, 60);
		t.grislySnowflake(250, 200, 1, 60);
		t.grislySnowflake(400, 200, 2, 60);
		t.grislySnowflake(550, 200, 3, 60);
		t.grislySnowflake(300, 600, 5, 200);

	}

	/** Draw a Grisly snowflake of depth d with side length s<br>
	 * and left point of base line at (x, y). <br>
	 * Precondition: d >= 0 and s > 0. <br>
	 * Note: "Grisly comes from the names of the authors of this method: <br>
	 * ...... David Gries and Lillian Lee, */
	public void grislySnowflake(double x, double y, int d, double s) {
		// double h= s * Math.sinDegrees(60); // vertical midpt of a hexagon of side length s
		double h= s * sin60degrees;
		if (d == 0) {
			fillHex(s, x + s / 2.0, y - h);
			return;
		}

		double y1= y - 2 * h / 3; // vertical position of base line of three middle hexes

		grislySnowflake(x, y, d - 1, s / 3); // bottom left hex
		grislySnowflake(x + s - s / 3, y, d - 1, s / 3); // bottom right hex
		grislySnowflake(x, y - 4 * h / 3, d - 1, s / 3); // top left hex
		grislySnowflake(x + s - s / 3, y - 4 * h / 3, d - 1, s / 3); // top right hex

		grislySnowflake(x - s / 3, y1, d - 1, s / 3); // middle left hex
		grislySnowflake(x + s / 3, y1, d - 1, s / 3);// middle middle hex
		grislySnowflake(x + s, y1, d - 1, s / 3); // middle right hex
	}

	/** Fill a hexagon of side length s, with middle (x, y). */
	public void fillHex(double s, double x, double y) {
		// Put into arrays xd and yd the vertices of the hexagon
		double dx= s * cos60degrees;// GMath.cosDegrees(60);
		double dy= s * sin60degrees;// GMath.sinDegrees(60);
		double[] xd= new double[6];
		double[] yd= new double[6];
		xd[0]= x - s / 2;
		yd[0]= y;
		xd[1]= xd[0] - dx;
		yd[1]= yd[0] + dy;
		xd[2]= xd[1] - s;
		yd[2]= yd[1] + 0;
		xd[3]= xd[2] - dx;
		yd[3]= yd[2] - dy;
		xd[4]= xd[3] + dx;
		yd[4]= yd[3] - dy;
		xd[5]= xd[4] + s;
		yd[5]= yd[4] + 0;

		// Move the arrays dx and dy into int arrays xi and yi
		int[] xi= new int[6];
		int[] yi= new int[6];
		for (int k= 0; k < 6; k= k + 1) {
			xi[k]= (int) xd[k];
			yi[k]= (int) yd[k];
		}

		fillPolygon(xi, yi, 6);
	}
}
