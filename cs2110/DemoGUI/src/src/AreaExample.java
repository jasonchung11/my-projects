package src;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/** This class is used to demo the placement of components. It places one JTextArea, with
 * scrollbars, in the center.
 * 
 * Experiment with it, typing characters, resizing it, etc. */
public class AreaExample extends JFrame {

    private JTextArea area= new JTextArea("012345678\nabc", 5, 11);
    private JScrollPane sc= new JScrollPane(area);

    /** Show the GUI */
    public static void main(String[] pars) {
        AreaExample gui= new AreaExample();
    }

    /** Constructor: an invisible JFrame */
    public AreaExample() {
        super("AreaExample");
        area.setFont(new Font("Arial", Font.PLAIN, 22));
        add(sc, BorderLayout.CENTER);

        pack();
        setVisible(true);
    }

}
