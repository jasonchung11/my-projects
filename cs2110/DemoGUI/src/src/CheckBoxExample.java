import javax.swing.*;
import java.awt.*;

/** This class demos the layout of check boxes */
public class CheckBoxExample extends JFrame {
    private JLabel emptyLabel= new JLabel(" ");
    private JCheckBox cb1= new JCheckBox("cat");
    private JCheckBox cb2= new JCheckBox("dog");
    
    /** Show the GUI  */
    public static void main(String[] pars) {
        CheckBoxExample gui= new CheckBoxExample();
    }
     
    /** Constructor: an invisible JFrame with two checkboxes
                 and a blank label */
    public CheckBoxExample() {
        super("CheckBoxExample");
        
        add(cb1,BorderLayout.EAST);
        add(cb2,BorderLayout.WEST);
        add(emptyLabel,BorderLayout.SOUTH);
        
        cb1.setSelected(true);
        emptyLabel.setFont(new Font("Arial", Font.PLAIN, 22));
        cb1.setFont(new Font("Arial", Font.PLAIN, 22));
        cb2.setFont(new Font("Arial", Font.PLAIN, 22));
        pack();
        setVisible(true);
    }
    

 }
