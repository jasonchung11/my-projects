
/** Jonathon Diamond developed the basic solution to
    tiling Eaine's kitchen. With 2 or three revisions by
    Gries and Diamond, the following version was created.

    Example use case:
    KitchenTurtle t= new KitchenTurtle();
    t.tileKitchen(3, 12, 4, 300);

    will tile a 2^4x2^4 kitchen with fridge at (3,4),
    pausing 300ms between tile placements
 */
import java.awt.Color;
import java.awt.Point;
import java.awt.Rectangle;

/** An instance contains methods to tile Elaine's kitchen. */
public class KitchenTurtle extends Turtle {
	/** We explain how a 2^n by 2^n kitchen is mapped onto the graphics panel.<br>
	 *
	 * 1. The upper left corner of the kitchen is at<br>
	 * pixel (100, 100) of the graphics panel.<br>
	 * 2. Each square of the kitchen occupies a 10x10 square<br>
	 * of pixels in the graphics panel. This means that<br>
	 * square (x, y) of the kitchen has (100 + i*10, 100 + j*10)<br>
	 * as its top-left pixel on the panel.
	 *
	 * All specifications are written in terms of the 2^n x 2^n<br>
	 * kitchen, and the method bodies have to translate coordinates<br>
	 * of kitchen squares into coordinates of pixels on the panel. */
	private int number;

	public static void main(String[] args) {
		KitchenTurtle kt= new KitchenTurtle();

		// (x-coord of fridge, y-coord of fridge,
		// power of kitchen size, milliseconds to pause after placing a tile)
		// kt.tileKitchen(0, 0, 3, 500);
		// kt.tileKitchen(20, 30, 5, 60);
		kt.tileKitchen(63, 0, 6, 0);
	}

	/** = b ^ c, i.e. b multiplied by itself c times.<br>
	 * Precondition: c >= 0. */
	public static int exp(int b, int c) {
		if (c == 0) { return 1; }

		if (c % 2 == 0) {// Note: for even c, b^c = (b*b)^(c/2)
			return exp(b * b, c / 2);
		}

		return b * exp(b, c - 1); // Note: b^c = b * b^(c-1)
	}

	/** Draw a 2^n by 2^n kitchen, <br>
	 * put a refrigerator (or other object) on square (x, y) <br>
	 * --that square does not have to be tiled-- and tile the kitchen. <br>
	 * If x or y is not in the range 0..2^n-1, use 0 for it. <br>
	 * Pause msecs after putting each tile down. <br>
	 * Precondition: n >= 0. */
	public void tileKitchen(int x, int y, int n, int msec) {
		int p2n= exp(2, n);  // 2 to the power n.
		if (x < 0 || x >= p2n)
			x= 0;
		if (y < 0 || y >= p2n)
			y= 0;
		Point in= new Point(x, y); // This is where the fridge is

		setPanelSize();
		clear();

		// Draw a square around the kitchen.
		setColor(Color.black);
		Rectangle rec= new Rectangle(0, 0, p2n, p2n);

		// Remember: for drawRectangle, place the turtle at its center.
		// moveTo(100 + 5 * p2n, 100 + 5 * p2n, 0);
		// drawRectangle(10 * p2n, 10 * p2n);
		moveTo(100 + 5 * p2n - 1, 100 + 5 * p2n - 1, 0);
		drawRectangle(10 * p2n + 1, 10 * p2n + 1);

		// Place a red refrigerator (or other object) at (x, y).
		moveTo(105 + x * 10, y * 10 + 105, 0);
		Color orig= getColor();
		setColor(Color.red);
		fillRectangle(10, 10);

		setColor(orig);

		// Place the tiles
		number= 0;
		putTiles(rec, in, msec);

	}

	/** Draw a 2^n by 2^n kitchen, put a refrigerator (or other object) on square (x, y) <br>
	 * -- square does not have to be tiled-- and tile the kitchen. <br>
	 * If x or y is not in the range 0..2^n-1, use 0 for it. <br>
	 * Pause 100 after putting each tile down. <br>
	 * Precondition: n >= 0. */
	public void tileKitchen(int x, int y, int n) {
		tileKitchen(x, y, n, 100);
	}

	/** Tile the square kitchen given by rec. <br>
	 * Its side length is a power of 2. <br>
	 * The position of the refrigerator (or other object) is given by Point in. <br>
	 * Pause msec microseconds after placing each tile. */
	public void putTiles(Rectangle rec, Point in, int msec) {
		// base case
		if (rec.getWidth() == 1) { return; }

		// (mx, my) is the position of upper lefthand corner of
		// lower right quadrant.
		int side= (int) rec.getWidth() / 2;// half the width (or height)
		int mx= rec.x + side;
		int my= rec.y + side;

		// fridgei will contain the position of fridge in quadrant i
		// 1 = upper left, 2 = upper right,
		// 3 = lower left, 4 = upper right quadrant.
		Point fridge1= new Point(mx - 1, my - 1);
		Point fridge2= new Point(mx, my - 1);
		Point fridge3= new Point(mx - 1, my);
		Point fridge4= new Point(mx, my);

		// Lay one tile in the three quadrants that do not contain
		// an already filled tile and set fridgei for the other
		// quadrant to in (the real refrigerator).
		setColor(tColor(number % 13 + 1));

		// Fix upper left quadrant
		if (in.x < mx && in.y < my) {
			fridge1= in;
		} else {
			moveTo(105 + (mx - 1) * 10, 105 + (my - 1) * 10, 0);
			fillRectangle(10, 10); // lay 1/3 of a tile
		}

		// Fix upper right quadrant
		if (in.x >= mx && in.y < my) {
			fridge2= in;
		} else {
			moveTo(105 + mx * 10, 105 + (my - 1) * 10, 0);
			fillRectangle(10, 10); // lay 1/3 of a tile
		}

		// Fix lower left quadrant
		if (in.x < mx && in.y >= my) {
			fridge3= in;
		} else {
			moveTo(105 + (mx - 1) * 10, 105 + my * 10, 0);
			fillRectangle(10, 10); // lay 1/3 of a tile
		}

		// Fix lower right quadrant
		if (in.x >= mx && in.y >= my) {
			fridge4= in;
		} else {
			moveTo(105 + mx * 10, 105 + my * 10, 0);
			fillRectangle(10, 10); // lay 1/3 of a tile
		}
		number= number + 1;

		// Pause for msec microseconds
		pause(msec);

		// Place tiles in the four quadrants
		putTiles(new Rectangle(rec.x, rec.y, side, side), fridge1, msec);
		putTiles(new Rectangle(mx, rec.y, side, side), fridge2, msec);
		putTiles(new Rectangle(rec.x, my, side, side), fridge3, msec);
		putTiles(new Rectangle(mx, my, side, side), fridge4, msec);
	}
}
