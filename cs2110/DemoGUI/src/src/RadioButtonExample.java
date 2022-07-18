import javax.swing.*;
import java.awt.*;

/** This class demos the layout of radio buttons */
public class RadioButtonExample extends JFrame {
    private JLabel emptyLabel= new JLabel(" ");
    private JRadioButton button1= new JRadioButton("one");
    private JRadioButton button2= new JRadioButton("two");
    private JRadioButton button3= new JRadioButton("three");
    
    /** Show the GUI  */
    public static void main(String[] args) {
        RadioButtonExample fd= new RadioButtonExample();
    }
     
    /** Constructor: an invisible JFrame with
                 three radio buttons and a blank label */
    public RadioButtonExample() {
        super("RadioButtonExample");
        
        Container cp= getContentPane();
        cp.add(button1,BorderLayout.WEST);
        cp.add(button2,BorderLayout.CENTER);
        cp.add(button3,BorderLayout.EAST);
        cp.add(emptyLabel,BorderLayout.SOUTH);
        
        // Group the radio buttons
        ButtonGroup group= new ButtonGroup();
        group.add(button1);
        group.add(button2);
        group.add(button3);
        
        button3.setSelected(true);
        button2.setSelected(true);
        
        setFontAndSizes();
        pack();
        setVisible(true);
    }
    
    /** Set the font and font size for all field components. */
    public void setFontAndSizes() {
        emptyLabel.setFont(new Font("Arial", Font.PLAIN, 22));
        button1.setFont(new Font("Arial", Font.PLAIN, 22));
        button2.setFont(new Font("Arial", Font.PLAIN, 22));
        button3.setFont(new Font("Arial", Font.PLAIN, 22));
    }
    

 }
 
