import javax.swing.*;
import java.awt.*;
import java.util.*;

/** This class demos the layout of a JColorChooser */
public class ColorChooserExample extends JFrame {
    private JLabel emptyLabel= new JLabel(" ");
    
    private JColorChooser jcc= new JColorChooser();
    
    /** Show the GUI  */
    public static void main(String[] pars) {
        ColorChooserExample gui= new ColorChooserExample();
    }
    
    /** Constructor: an invisible JFrame with 
        a color chooser in the center */
    public ColorChooserExample() {
        super("ColorChooserExample");
        
        add(jcc, BorderLayout.CENTER);
        add(new JLabel("    "), BorderLayout.SOUTH);
        

        emptyLabel.setFont(new Font("Arial", Font.PLAIN, 22));
        pack();
        setVisible(true);
   
    }
    
    
 }
