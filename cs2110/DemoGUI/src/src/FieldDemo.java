import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/** This class is used to demo the listening of a return-key stroke
    and a button to make the text field into upper case letters.
 */
public class FieldDemo extends JFrame {
    private JButton b= new JButton("first");
    private JTextField jTF= new JTextField("type here", 20);

    /** Show the GUI  */
    public static void main(String[] args) {
        FieldDemo fd= new FieldDemo();
    }

    /** Constructor: an invisible frame with a button, 
	              and a text field  */
    public FieldDemo() {
        super("FieldDemo");
        getContentPane().add(b, BorderLayout.WEST);
        b.setEnabled(true);

        getContentPane().add(jTF, BorderLayout.EAST);
        
        ActionListener jtfl= (ActionEvent e) -> makeUpperCaseField(e);

        // Set the actionlistener for components
        b.addActionListener(e -> makeUpperCaseButton(e));
        jTF.addActionListener(jtfl);
        b.setFont(new Font("Arial", Font.PLAIN, 22));
        jTF.setFont(new Font("Arial", Font.PLAIN, 22));
        
        pack();
        setVisible(true);
    }
    /** Change the text in textfield JTF to upper case.
     * This is called when the button is pressed.*/
    public void makeUpperCaseButton(ActionEvent e) {
        String x= jTF.getText();
        jTF.setText(x.toUpperCase());
        System.out.println("Button pressed");
    }

    /** Change the text in textfield JTF to upper case.
     * This is called when return pressed in text field*/
    public void makeUpperCaseField(ActionEvent e) {
        String x= jTF.getText();
        jTF.setText(x.toUpperCase());
        System.out.println("Return pressed");
    }
}
