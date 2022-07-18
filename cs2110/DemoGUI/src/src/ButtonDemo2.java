import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/** This class is used to demonstrate having different listeners for
    different buttons. Button westButton listens to buttonClickWest,
    Button eastButton listens to buttonClickEast.
 */
public class ButtonDemo2 extends JFrame {
    // Class invariant: exactly one of eastButton and westButton is enabled
    private JButton westButton= new JButton("west");
    private JButton eastButton= new JButton("east");

    /** Show the GUI  */
    public static void main(String[] pars) {
        ButtonDemo2 gui= new ButtonDemo2();
    }


    /** Constructor: a frame with  two buttons */
    public ButtonDemo2() {
        super("ButtonDemo2");

        add(westButton,BorderLayout.WEST);
        add(eastButton,BorderLayout.EAST);

        westButton.setEnabled(false);
        eastButton.setEnabled(true);

        westButton.addActionListener(e -> buttonClickWest(e));
        eastButton.addActionListener(e -> buttonClickEast(e));


        westButton.setFont(new Font("Arial", Font.PLAIN, 22));
        eastButton.setFont(new Font("Arial", Font.PLAIN, 22));
        pack();
        setVisible(true);
    }

    /** Process a click of a button */
    public void buttonClickWest(ActionEvent e) {
        System.out.println("buttonClickWest called");
        boolean b= eastButton.isEnabled();
        eastButton.setEnabled(!b);
        westButton.setEnabled(b);
    }

    /** Process a click of a button */
    public void buttonClickEast(ActionEvent e) {
        System.out.println("buttonClickEast called");
        boolean b= eastButton.isEnabled();
        eastButton.setEnabled(!b);
        westButton.setEnabled(b);
    }

}
