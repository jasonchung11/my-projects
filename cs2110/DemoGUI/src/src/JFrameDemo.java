import java.awt.*;
import javax.swing.*;

/** A JFrame with components using
 a BorderLayout manager */
public class JFrameDemo extends JFrame {
    
    /** Show the GUI  */
    public static void main(String[] pars) {
        JFrameDemo gui= new JFrameDemo();
    }
    
    /** Constructor: A Jframe with 1 button
         and a label*/
    public JFrameDemo() {
        super("JFrameDemo");
        
        JButton jb= new JButton("Click here");
        JLabel jw= new JLabel( "west");
        JLabel js= new JLabel( "south");
        JLabel jc= new JLabel( "  center  ");
        JLabel jn= new JLabel( "north");
        
        add(jb, BorderLayout.EAST);
        add(jw, BorderLayout.WEST);
        add(js, BorderLayout.SOUTH);
        add(jc, BorderLayout.CENTER);
        add(jn, BorderLayout.NORTH);

        jb.setFont(new Font("Arial", Font.PLAIN, 22));
        jw.setFont(new Font("Arial", Font.PLAIN, 22));
        js.setFont(new Font("Arial", Font.PLAIN, 22));
        jc.setFont(new Font("Arial", Font.PLAIN, 22));
        jn.setFont(new Font("Arial", Font.PLAIN, 22));
        
        pack();
        setVisible(true);
        
    }
}