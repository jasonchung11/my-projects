import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;


/** An instance is a JPanel of size (WIDTH,HEIGHT), which
  is green or red depending on whether the sum of the
  parameters of the constructor is even or not. Clicking
  on the square creates a pink disk on it; clicking again
  removes the pink disk. The JPanel is used only
  as a graphics pane; no components are added to it.
  */
public class Square extends JPanel {
    public static final int HEIGHT= 70;  // height and 
    public static final int WIDTH= 70;   // width of square
    
    private int x, y; // Coordinates of square on board
    private boolean hasDisk= false; // = "the square has a pink disk"
    
    /** Constructor: a square at (x,y) */
    public Square(int x, int y) {
        this.x= x;
        this.y= y;
        setPreferredSize(new Dimension(WIDTH,HEIGHT));
    }
    
    /* paint this square using g. The system calls
     paint whenever the square has to be redrawn.*/
    public void paint(Graphics g) {
        if ((x+y)%2 == 0) {
            g.setColor(Color.green);
        } else {
            g.setColor(Color.red);
        }
        g.fillRect(0, 0, WIDTH-1, HEIGHT-1);
        
        if (hasDisk) {
            g.setColor(Color.pink);
            g.fillOval(7, 7, WIDTH-14, HEIGHT-14);
        }
        
        g.setColor(Color.black);
        g.drawRect(0, 0, WIDTH-1,HEIGHT-1);
        g.drawString("("+x+", "+y+")", 10, 5+HEIGHT/2);
    }
    
    /** Complement the "has pink disk" property */
    public void complementDisk() {  
        hasDisk= !hasDisk;
        repaint(); // Ask the system to repaint the square
    }
    
    /** Remove pink disk (if present) */
    public void clearDisk() {
        hasDisk= false;
        repaint(); // Ask the system to repaint the square
    }
}