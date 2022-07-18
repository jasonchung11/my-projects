import javax.swing.*;
import java.awt.*;
import java.util.*;
import javax.swing.event.*;

/** This class demos listening to a JColorChooser.
    An instance is an (invisible) JFrame with title t, a color
    chooser in the center, and a label in the south. The class
    listens to the color chooser; whenever the user changes the
    color in the color chooser, the label is changed to a
   description of the color. This lets you see the rgb values
   for the color.
 */
public class ColorChooserListener extends JFrame {
    private JLabel colorLabel= 
             new JLabel(Color.black.toString() + "       ");
    private JColorChooser jcc= new JColorChooser();
    
    /** Show the GUI  */
    public static void main(String[] pars) {
        ColorChooserListener gui= new ColorChooserListener();
    }
    
    /* Constructor: */
    public ColorChooserListener() {
        super("ColorChooserListener");
        ChangeListener cl= e -> changeColor(e);
        jcc.getSelectionModel().addChangeListener(cl);
        
        Container cp= getContentPane();
        cp.add(jcc, BorderLayout.CENTER);
        cp.add(colorLabel, BorderLayout.SOUTH);
        colorLabel.setFont(new Font("Arial", Font.PLAIN, 22));
        
        pack();
        setVisible(true);
    }
    
    /** Called when user changes a color in component jcc. Retrieve
       the color and change the label to a description of the color.
       */
    public void changeColor(ChangeEvent e) {
        Color newColor= jcc.getColor();
        colorLabel.setText(newColor.toString());
    }
    
    private class ColorListener implements ChangeListener {
     public void stateChanged(ChangeEvent e) {
         Color newColor= jcc.getColor();
         colorLabel.setText(newColor.toString());
     }
    }    


    
    
 }
