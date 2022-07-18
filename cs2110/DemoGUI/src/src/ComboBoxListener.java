import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.*;

/** This class demos listening to a JComboBox cb. It registers with cb
    both a listener that listens only to selections and a listener
    that listens also to deselections. Each time one of these listeners
    is called, it prints out what kind of listener it is and
    what the item is that caused the event. You can comment out one
    of these listeners to listen only to the other one.
 */
public class ComboBoxListener extends JFrame {
    private JLabel emptyLabel= new JLabel(" ");
    private JComboBox cb= new JComboBox();

    /** Show the GUI  */
    public static void main(String[] pars) {
        ComboBoxListener gui= new ComboBoxListener();
    }


    /** Constructor: a JFrame with  a JComboBox
                  and a blank label */
    public ComboBoxListener() {
        super("ComboBoxListener");

        Container cp= getContentPane();
        cp.add(cb,BorderLayout.CENTER);
        cp.add(emptyLabel,BorderLayout.SOUTH);

        cb.addActionListener(e -> {System.out.println("SelectionHearer: " + 
                              cb.getSelectedItem());});
        cb.addItemListener(e -> {itemStateChanged(e);});

        cb.addItem("white");
        cb.addItem("blue");
        cb.addItem("green");
        cb.addItem("pink");
        cb.setFont(new Font("Arial", Font.PLAIN, 22));
        
        pack();
        setVisible(true);
    }

    /** Print out "ItemHearer" followed by 
        the changed item and the kind of change (as an integer)*/
   public void itemStateChanged(ItemEvent e) {
            System.out.println("ItemHearer:" + 
                    e.getItem() + " " + 
                    e.getStateChange());
        }


}
