import javax.swing.*;
import java.awt.*;

/** Demo class Box. Comment on constructor
    says how frame is laid out. */
public class BoxDemo extends JFrame {
    
    JButton j0= new JButton("0");
    JButton j1= new JButton("1");
    JButton j2= new JButton("2");
    JButton j3= new JButton("3");
    JButton j4= new JButton("4");
    JLabel je= new JLabel("east");
    JLabel jw= new JLabel("west");
    
    /** Show the GUI  */
    public static void main(String[] pars) {
        BoxDemo gui= new BoxDemo();
    }
 
    
    /** Constructor: frame with title "Box demo",
        labels in the east/west,
        blank label in south,
        horizontal Box with 4 buttons in center. */
    public BoxDemo() {
        super("Box demo");
        
        Box b= new Box(BoxLayout.Y_AXIS);        
        b.add(j0);
        b.add(j1);
        b.add(j2);
        b.add(j3);
        b.add(j4);
        
        add(je, BorderLayout.EAST);
        add(jw, BorderLayout.WEST);
        add(new JLabel(" "), BorderLayout.SOUTH);
        
        add(b, BorderLayout.CENTER);
        
        setFontSizes();
        
        pack();
        setVisible(true);
    }
    
    /** Set font and size for buttons. */
    public void setFontSizes() {
        j0.setFont(new Font("Arial", Font.PLAIN, 22));
        j1.setFont(new Font("Arial", Font.PLAIN, 22));
        j2.setFont(new Font("Arial", Font.PLAIN, 22));
        j3.setFont(new Font("Arial", Font.PLAIN, 22));
        j4.setFont(new Font("Arial", Font.PLAIN, 22));
        je.setFont(new Font("Arial", Font.PLAIN, 22));
        jw.setFont(new Font("Arial", Font.PLAIN, 22));
        
    }
}
