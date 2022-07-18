import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JComponent;
import javax.swing.JFrame;

/** An instance provides a JFrame on which one can scribble with the mouse
  * This class contains some things you cannot understand yet, so we do not
   fully annotate the program. We will do this when you know enough.*/
public class Scribble {
   
   /** Create a new JFrame and add a Scribbler to it (to its ContentPane). */
   public static void main(String[] args) {
      JFrame w = new JFrame("Scribble");
      Container cp= w.getContentPane();
      cp.add(new Scribbler(), BorderLayout.CENTER); // add a new instance of Scribbler,
                                                    // which is a JComponent, to the JFrame.
      w.setSize(500, 500);
      w.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
      w.setVisible(true);
   }

   /** An instance of this is added to the JFrame's content pane.
     * This instance contains what is needed to listen to mouse movement and
     * draw. */
   public static class Scribbler extends JComponent {
      /** Each element of segments is a segment, i.e. list of Points. */
      List<List<Point>> segments= new ArrayList<List<Point>>();

      /** Constructor: an instance with no segments. */
      Scribbler() {
         segments.add(new ArrayList<Point>());
         
         addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent me) {
               addNextPoint(me);
            }
            
            public void mouseReleased(MouseEvent me) {
               segments.add(new ArrayList<Point>());
               repaint();
            }
         });
         
         
         addMouseMotionListener(new MouseMotionAdapter() {
            public void mouseDragged(MouseEvent me) {
               addNextPoint(me);
            }
         });
      }
      
      void addNextPoint(MouseEvent me) {
         segments.get(segments.size() - 1).add(me.getPoint());
         repaint();
      }

      /** The system calls paint, giving it a Graphics object with drawing methods,
        * whenever it feels the component needs redrawing or when repaint() is called.
        * For each segment, draw lines between successive points of the segment.
        */
      public @Override void paint(Graphics g) {
         g.setColor(Color.WHITE);
         Rectangle b = g.getClip().getBounds();
         g.fillRect(b.x, b.y, b.width, b.height);
         g.setColor(Color.BLUE);
         for (List<Point> segment : segments) {
            if (segment.isEmpty()) continue;
            Point last= null;
            for (Point p : segment) {
               if (last != null) g.drawLine(last.x, last.y, p.x, p.y);                  
               last= p;
            }
         }
      }
   }
}
