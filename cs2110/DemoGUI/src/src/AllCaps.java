package src;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

/** In the window that appears, you can type any keystroke, it is printed --capitalized if it is a
 * letter. */
public class AllCaps extends KeyAdapter {

    JFrame capsFrame= new JFrame("KeyAdaptor Example");
    JLabel capsLabel= new JLabel();

    /** Create a GUI with a window in which you type a keystroke, which is printed, capitalized if
     * it is a letter. */
    public static void main(String[] pars) {
        AllCaps gui= new AllCaps();
    }

    public AllCaps() {
        capsLabel.setHorizontalAlignment(SwingConstants.CENTER);
        capsLabel.setText(":)");
        capsFrame.setSize(200, 200);
        capsFrame.add(capsLabel, BorderLayout.CENTER);
        capsFrame.add(new JLabel("  "), BorderLayout.NORTH);
        capsFrame.add(new JLabel("            "), BorderLayout.EAST);
        capsFrame.add(new JLabel("            "), BorderLayout.WEST);
        capsFrame.add(new JLabel("  "), BorderLayout.SOUTH);
        // capsFrame.addKeyListener(this);
        capsFrame.addKeyListener(this);
        capsLabel.setFont(new Font("Arial", Font.PLAIN, 22));
        capsFrame.pack();
        capsFrame.setVisible(true);

    }

    /** Process a keystroke */
    @Override
    public void keyPressed(KeyEvent e) {
        char typedChar= e.getKeyChar();
        capsLabel.setText(("'" + typedChar + "'").toUpperCase());
    }

}