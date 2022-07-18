import java.awt.*;
import javax.swing.*;

/** Demonstrate placement of components in a JFrame. Use BorderLayout.
    It places five components in the five possible areas:
       (1) a JButton in the east, 
       (2) a JLabel in the west,
       (3) a JCheckBox in the south,
       (4) a JTextField in the north, and
       (5) a JTextArea in the center.*/
public class ComponentExample extends JFrame {
    JButton je= new JButton("click me");
    JTextField jn= new JTextField("type here", 22);
    JCheckBox js= new JCheckBox("I will vote in November");
    JLabel jw= new JLabel("label 2");
    JTextArea jc= new JTextArea("type\nhere", 4, 10);
    /** Show the GUI  */
    public static void main(String[] pars) {
        ComponentExample gui= new ComponentExample();
    }
    
    /** Constructor: a JFrame with  5 components */
    public ComponentExample() {
        super("ComponentExample");  
        add(je, BorderLayout.EAST);
        add(jn, BorderLayout.NORTH);
        add(js, BorderLayout.SOUTH);
        add(jw, BorderLayout.WEST);
        add(jc, BorderLayout.CENTER);
        je.setFont(new Font("Arial", Font.PLAIN, 22));
        jn.setFont(new Font("Arial", Font.PLAIN, 22));
        js.setFont(new Font("Arial", Font.PLAIN, 22));
        jw.setFont(new Font("Arial", Font.PLAIN, 22));
        jc.setFont(new Font("Arial", Font.PLAIN, 22));
        pack();
        setVisible(true);
    }
}


//textArea = new JTextArea(5, 30);

//JScrollPane scrollPane = new JScrollPane(textArea);
