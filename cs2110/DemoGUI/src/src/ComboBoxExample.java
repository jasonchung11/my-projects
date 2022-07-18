import javax.swing.*;
import java.awt.*;

/** This class demos the layout of JComboBoxes */
public class ComboBoxExample extends JFrame {
    private JLabel emptyLabel= new JLabel(" ");
    private JComboBox cb= new JComboBox();
    
    /** Show the GUI  */
    public static void main(String[] pars) {
        ComboBoxExample gui= new ComboBoxExample();
    }
 
    /** Constructor: an invisible JFrame with  a JComboBox
                  and a blank label */
    public ComboBoxExample() {
        super("ComboBoxExample");
        
        Container cp= getContentPane();
        cp.add(cb,BorderLayout.CENTER);
        cp.add(new JLabel(" "),BorderLayout.NORTH);
        cp.add(new JLabel(" "),BorderLayout.EAST);
        cp.add(new JLabel(" "),BorderLayout.WEST);
        cp.add(new JLabel(" "),BorderLayout.SOUTH);
        
        cb.addItem("red");
        cb.addItem("white");
        cb.addItem("blue");

        cb.setFont(new Font("Arial", Font.PLAIN, 22));
        pack();
        setVisible(true);
    }
    
 }
