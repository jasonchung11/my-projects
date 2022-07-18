import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class ButtonDemo3 extends JFrame {
    private JButton wB= new JButton("west");
    private JButton eB= new JButton("east");

    /** Show the GUI  */
    public static void main(String[] pars) {
        ButtonDemo3 gui= new ButtonDemo3();
    }

    /** Constructor: inv frame two buttons */
    public ButtonDemo3() {
        super("ButtonDemo3");
        add(wB,BorderLayout.WEST);
        add(eB,BorderLayout.EAST);
        add(new JLabel("   "), BorderLayout.SOUTH);
        add(new JLabel("   "), BorderLayout.CENTER);
        add(new JLabel("   "), BorderLayout.NORTH);
        wB.setEnabled(false);
        eB.setEnabled(true);

        wB.addActionListener(e -> {
            eB.setEnabled(true); wB.setEnabled(false);
            System.out.println("west button clicked");}
                );
        eB.addActionListener(e -> {
            eB.setEnabled(false); wB.setEnabled(true);
            System.out.println("east button clicked");}
                );

        wB.setFont(new Font("Arial", Font.PLAIN, 22));
        eB.setFont(new Font("Arial", Font.PLAIN, 22));
        pack();
        setVisible(true);
    }


}
