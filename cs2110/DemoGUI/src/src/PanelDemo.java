import java.awt.*;
import javax.swing.*;

/** Instance has labels in east/west, JPanel with four 
 buttons in center.  */
public class PanelDemo extends JFrame {
    JPanel p= new JPanel();
    JButton j0= new JButton("0");
    JButton j1= new JButton("1");
    JButton j2= new JButton("2");
    JButton j3= new JButton("3");
    JButton j4= new JButton("4");
    JLabel je= new JLabel("east");
    JLabel jw= new JLabel("west");
    
    /** Show the GUI  */
    public static void main(String[] pars) {
        PanelDemo gui= new PanelDemo();
    }
    
    /** Constructor: a frame with title "Panel demo",
        labels in east/west,
        blank label in south,
        JPanel of 4 buttons in the center */
    public PanelDemo() {
        super("PanelDemo");
        p.add(j0);
        p.add(j1);
        p.add(j2);
        p.add(j3);
        p.add(j4);
        
        add(je, BorderLayout.EAST);
        add(jw, BorderLayout.WEST);
        add(new JLabel("    "), BorderLayout.SOUTH);
        
        add(p, BorderLayout.CENTER);
        
        setFontAndSizes();
        
        pack();  
        setVisible(true);
    }
    /** Set the font and font size for all field components. */
    public void setFontAndSizes() {
        j0.setFont(new Font("Arial", Font.PLAIN, 22));
        j1.setFont(new Font("Arial", Font.PLAIN, 22));
        j2.setFont(new Font("Arial", Font.PLAIN, 22));
        j3.setFont(new Font("Arial", Font.PLAIN, 22));
        j4.setFont(new Font("Arial", Font.PLAIN, 22));
        je.setFont(new Font("Arial", Font.PLAIN, 22));
        jw.setFont(new Font("Arial", Font.PLAIN, 22));
    }
}