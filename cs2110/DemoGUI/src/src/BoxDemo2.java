import javax.swing.*;
import java.awt.*;

/** Demo class Box. Comment on constructor
    says how frame is laid out. */
public class BoxDemo2 extends JFrame {
    JButton j00= new JButton("0 0");
    JButton j10= new JButton("1 0");
    JButton j20= new JButton("2 0");
    JButton j01= new JButton("0 1");
    JButton j11= new JButton("1 1");
    JButton j21= new JButton("2 1");
    JButton j31= new JButton("3 1");
    JLabel jn= new JLabel("north");
    JLabel je= new JLabel("east");
    JLabel jw= new JLabel("west");
    JLabel js= new JLabel("south");
    /** Show the GUI  */
    public static void main(String[] pars) {
        BoxDemo2 gui= new BoxDemo2();
    }
    
    /** Constructor: frame with title "Box demo 2",
        labels in the east/west,
        blank label in south,
        Two columns of boxes in center. */
    public BoxDemo2() {
        super("Box demo 2");
        
        Box b= new Box(BoxLayout.X_AXIS);        
        
        Box col1= new Box(BoxLayout.Y_AXIS);
        col1.add(j00);
        col1.add(j10);
        col1.add(j20);
        
        Box col2= new Box(BoxLayout.Y_AXIS);
        col2.add(j01);
        col2.add(j11);
        col2.add(j21);
        col2.add(j31);
        b.add(col2);
        b.add(col1);
        
        add(jn, BorderLayout.NORTH);
        add(je, BorderLayout.EAST);
        add(jw, BorderLayout.WEST);
        add(js, BorderLayout.SOUTH);
        
        add(b, BorderLayout.CENTER);
        
        setFontAndSizes();
        
        pack();
        setResizable(true);
        setVisible(true);
    }
    
    /** Set the font and font size for all field components. */
    public void setFontAndSizes() {
        j00.setFont(new Font("Arial", Font.PLAIN, 22));
        j10.setFont(new Font("Arial", Font.PLAIN, 22));
        j20.setFont(new Font("Arial", Font.PLAIN, 22));
        j01.setFont(new Font("Arial", Font.PLAIN, 22));
        j11.setFont(new Font("Arial", Font.PLAIN, 22));
        j21.setFont(new Font("Arial", Font.PLAIN, 22));
        j31.setFont(new Font("Arial", Font.PLAIN, 22));
        jn.setFont(new Font("Arial", Font.PLAIN, 22));
        je.setFont(new Font("Arial", Font.PLAIN, 22));
        jw.setFont(new Font("Arial", Font.PLAIN, 22));
        js.setFont(new Font("Arial", Font.PLAIN, 22));
    }
}
