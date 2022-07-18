import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;

/** Contains a method that responds to a mouse click in
    a Square */
public class MouseEvents extends MouseInputAdapter {
    // Complement the "has pink disk" property
    public void mouseClicked(MouseEvent e) {
        Object ob= e.getSource();
        if (ob instanceof Square) {
            ((Square)ob).complementDisk();
        }
    }
    
    public void mouseEntered(MouseEvent e) {
        System.out.println("mouse entered");
    }
    public void mouseExited(MouseEvent e) {
        System.out.println("mouse exited");
    }
}