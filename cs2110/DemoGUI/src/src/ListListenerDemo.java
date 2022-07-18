import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.util.*;

/** This class demos the the use of a listener for a JList
    An instance is a window that contains:
    (1) A Jlist with a scroll bar in the east. The list contains 
        colors for which constants exist in class Color.
    (2) A label in the south. It lists the RGB values for the
        currently selected item of the list
    (3) A JPanel in the west. It is colored with the color
        that is the currently selected item of the list.
 */
public class ListListenerDemo extends JFrame {
    private String[] names= {"white", "black", "blue", "cyan", 
                             "dark gray", "gray", "green",
                             "light gray", "magenta", "orange",
                             "pink", "red", "yellow"};
                             
    private Color[] colors= {Color.white, Color.black, Color.blue, Color.cyan,
                              Color.darkGray, Color.gray, Color.green,
                              Color.lightGray, Color.magenta, Color.orange,
                              Color.pink, Color.red, Color.yellow};
                              
    private JLabel southLabel= new JLabel("    " + Color.white.toString() + " ");
    private JList nameList= new JList(names);
    private JScrollPane sp= new JScrollPane(nameList);
    private JPanel colorPanel= new JPanel();
    
    /** Show the GUI  */
    public static void main(String[] pars) {
        ListListenerDemo gui= new ListListenerDemo();
    }

    /** Constructor: a visible JFrame, as explained
                    in the spec of this class */
    public ListListenerDemo() {
        super("ListListenerDemo");
        
        // Add a listener, ensure only single selections, and select the first item
            nameList.addListSelectionListener(e -> processSelection(e));
            nameList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            nameList.setSelectedIndex(0);
          
        colorPanel.setPreferredSize(new Dimension(155,50));
        colorPanel.setOpaque(true);
        colorPanel.setBackground(Color.white);
        
        Container cp= getContentPane();
        cp.add(sp, BorderLayout.EAST);
        cp.add(southLabel, BorderLayout.SOUTH);
        cp.add(colorPanel, BorderLayout.WEST);
        

        southLabel.setFont(new Font("Arial", Font.PLAIN, 22));
        nameList.setFont(new Font("Arial", Font.PLAIN, 22));
        setResizable(false);
        pack();
        setVisible(true);
    }
    
    /** Process selection of an item in a JList. That is, change the color
     * of the west panel to the new selection and place a description
     * of the color in the south label. */
    public void processSelection(ListSelectionEvent e) {
        if (e.getValueIsAdjusting()) return;
        JList jl= (JList)e.getSource();
        int index= jl.getSelectedIndex();
        Color c= colors[index];
        southLabel.setText(" " + c.toString());
        colorPanel.setBackground(c);
    }

 }
