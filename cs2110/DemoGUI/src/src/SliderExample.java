import javax.swing.*;
import java.awt.*;

/** This class demos the layout of Sliders */
public class SliderExample extends JFrame {
    private JSlider slSouth= new JSlider(JSlider.HORIZONTAL, -40, 40, 20);
    private JSlider slWest= new JSlider(JSlider.VERTICAL, 0, 100, 0);
    private JTextArea c= new JTextArea("one\ntwo\nthree\nfour\nfive", 5, 20);

    /** Show the GUI  */
    public static void main(String[] args) {
        SliderExample fd= new SliderExample();
    }

    /** Constructor: an invisible JFrame with two sliders and a text area.
        The horizontal slider has range -40..+40. It has major tick marks at
        intervals of 20, minor tick marks at intervals of 5, and labels at
        intervals of 20. The vertical slider has no tick marks or labels. */
    public SliderExample() { 
        super("SliderExample");

        add(slWest, BorderLayout.WEST);
        add(slSouth, BorderLayout.SOUTH);
        add(c, BorderLayout.CENTER);

        slSouth.setMajorTickSpacing(20);
        slSouth.setMinorTickSpacing(5);
        slSouth.setPaintTicks(true);

        slSouth.createStandardLabels(20);
        slSouth.setPaintLabels(true);        

        int w= slWest.getPreferredSize().width;
        int h= c.getPreferredSize().height;
        Dimension d= new Dimension(w,h);
        slWest.setPreferredSize(d);


        slWest.setFont(new Font("Arial", Font.PLAIN, 22));
        slSouth.setFont(new Font("Arial", Font.PLAIN, 22));
        c.setFont(new Font("Arial", Font.PLAIN, 22));
        pack();
        setVisible(true);
    }
}
