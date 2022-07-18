import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

/** An instance of this class is a frame with four sets of buttons.
    The upper left set has no border. The sets of buttons in the
    upper right, lower left, and upper right all have borders, which
    were produced by calls on static methods in class BorderFactory.

    Each of the four sets of buttons is a JPanel.
    The top row of two JPanels is a JPanel pTop.
    The bottom row of two JPanels is a JPanel pBot.
    pTop and pBot are placed in a Box, with a vertical strut
      between them to separate them a bit.
    Finally, that Box is placed in the CENTER of the JFrame.
 */
public class BorderDemo extends JFrame {

    private JRadioButton jTL1= new JRadioButton("one");
    private JRadioButton jTL2= new JRadioButton("two");
    private JRadioButton jTL3= new JRadioButton("tee");
    
    private JRadioButton jBL1= new JRadioButton("one");
    private JRadioButton jBL2= new JRadioButton("two");
    private JRadioButton jBL3= new JRadioButton("tee");
    
    private JRadioButton jTR1= new JRadioButton("one");
    private JRadioButton jTR2= new JRadioButton("two");
    private JRadioButton jTR3= new JRadioButton("tee");
    
    private JRadioButton jBR1= new JRadioButton("one");
    private JRadioButton jBR2= new JRadioButton("two");
    private JRadioButton jBR3= new JRadioButton("tee");
    /** Show the GUI  */
    public static void main(String[] pars) {
        BorderDemo gui= new BorderDemo();
    }


    public BorderDemo() {
        super("BorderDemo");

        JPanel bTopLeft= new JPanel();
        bTopLeft.add(jTL1);
        bTopLeft.add(jTL2);
        bTopLeft.add(jTL3);

        JPanel bTopRight= new JPanel();
        bTopRight.add(jTR1);
        bTopRight.add(jTR2);
        bTopRight.add(jTR3);

        JPanel pTop= new JPanel();
        pTop.add(bTopLeft);
        pTop.add(bTopRight);

        JPanel bBotLeft= new JPanel();
        bBotLeft.add(jBL1);
        bBotLeft.add(jBL2);
        bBotLeft.add(jBL3);
        
        JPanel bBotRight= makeButtonGroup();

        JPanel pBot= new JPanel();
        pBot.add(bBotLeft);
        pBot.add(bBotRight);

        bTopRight.setBorder(BorderFactory.createBevelBorder(
                BevelBorder.LOWERED));
        bBotLeft.setBorder(BorderFactory.createBevelBorder(
                BevelBorder.LOWERED, Color.pink, Color.red));
        bBotRight.setBorder(BorderFactory.createMatteBorder(
                3, 5, 6, 5, Color.green));

        Box b= new Box(BoxLayout.Y_AXIS);
        b.add(pTop);
        b.add(Box.createVerticalStrut(10));
        b.add(pBot);

        add(b, BorderLayout.CENTER);
        add(new JLabel(" "), BorderLayout.SOUTH);
        add(new JLabel("    "), BorderLayout.EAST);
        add(new JLabel("    "), BorderLayout.WEST);
        setResizable(false);
        setFontSizes();
        pack();
        setVisible(true);
    }
    
    /** Set font and size for buttons. */
    public void setFontSizes() {
        jTL1.setFont(new Font("Arial", Font.PLAIN, 22));
        jTL2.setFont(new Font("Arial", Font.PLAIN, 22));
        jTL3.setFont(new Font("Arial", Font.PLAIN, 22));
        jBL1.setFont(new Font("Arial", Font.PLAIN, 22));
        jBL2.setFont(new Font("Arial", Font.PLAIN, 22));
        jBL3.setFont(new Font("Arial", Font.PLAIN, 22));
        jTR1.setFont(new Font("Arial", Font.PLAIN, 22));
        jTR2.setFont(new Font("Arial", Font.PLAIN, 22));
        jTR3.setFont(new Font("Arial", Font.PLAIN, 22));
        jBR1.setFont(new Font("Arial", Font.PLAIN, 22));
        jBR2.setFont(new Font("Arial", Font.PLAIN, 22));
        jBR3.setFont(new Font("Arial", Font.PLAIN, 22));
        
    }
    
    /** Return a JPanel that contains three buttons
      * "ONE", "TWO", and "THR"
        that are in a button group. */
    private JPanel makeButtonGroup() {
        JPanel jp= new JPanel();
        jp.add(jBR1); jp.add(jBR2); jp.add(jBR3);
        ButtonGroup bg= new ButtonGroup();
        bg.add(jBR1); bg.add(jBR2); bg.add(jBR3);
        return jp;
    }
}

