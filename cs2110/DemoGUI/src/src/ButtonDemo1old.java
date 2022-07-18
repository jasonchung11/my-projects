import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


/** An instance has two buttons, exactly one of which is always
 enabled. Click the enabled one and the other one becomes
 enabled. */
public class ButtonDemo1old extends JFrame 
    implements ActionListener {
    
    /** Class invariant: exactly one of eastButton
     and westButton is enabled */
    private JButton westB= new JButton("west");
    private JButton eastB= new JButton("east");
    
    /** Show the GUI  */
    public static void main(String[] pars) {
        ButtonDemo1old gui= new ButtonDemo1old();
    }
    
    /** Constructor: a frame with two buttons */
    public ButtonDemo1old() {
        super("ButtonDemo1old");
        
        add(westB,BorderLayout.WEST);
        add(eastB,BorderLayout.EAST);
        
        westB.setEnabled(false);
        eastB.setEnabled(true);
        
        westB.addActionListener(this);
        eastB.addActionListener(this);
        westB.setFont(new Font("Arial", Font.PLAIN, 22));
        eastB.setFont(new Font("Arial", Font.PLAIN, 22));
        
        pack();
        setVisible(true);
    }
    
    /** Process a click of a button */
    public void actionPerformed(ActionEvent e) {
        boolean b= eastB.isEnabled();
        eastB.setEnabled(!b);
        westB.setEnabled(b);
    }
    
    /** Process a click of a button */
    public void buttonClick(ActionEvent e) {
        boolean b= eastB.isEnabled();
        eastB.setEnabled(!b);
        westB.setEnabled(b);
    }
    
}