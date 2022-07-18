import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;

/** This class demonstrates the use of a mouse listener. 
    An instance is a JFrame that is a 2x2 grid of squares,
  each of class Square,
  and a button with title "reset". Clicking an empty square
  draws a pink disk on it. Clicking again removes it.
  Clicking button "reset" removes all pink disks.
  
  Class MouseDemo2 listens to clicks of the button and to clicks on an
  instance of class Square.
  */
public class MouseDemo2 extends JFrame {
    /* Note the following. Class MouseEvents listens
     to mouse events on instances of Square (only).
     One instance of it is created and store in field me,
     when an instance of the class is first created. This
     single instance is then registered as the mouse
     listener for all three squares: b00, b01, b10, and b11. */
    
    Box b= new Box(BoxLayout.X_AXIS);
    
    Box leftColumn= new Box(BoxLayout.Y_AXIS);
    Square b00= new Square(0,0);
    Square b01= new Square(0,1);
    
    Box rightColumn= new Box(BoxLayout.Y_AXIS);
    Square b10= new Square(1,0);
    Square b11= new Square(1,1);
    
    JButton jb= new JButton("reset");
    
    MouseEvents me= new MouseEvents();
    
    /** Show the GUI  */
    public static void main(String[] pars) {
        MouseDemo2 gui= new MouseDemo2();
    }
 
    
    /** Constructor: a JFrame */
    public MouseDemo2() {
        super("MouseDemo2");
        leftColumn.add(b00);
        leftColumn.add(b01);
        rightColumn.add(b10);
        rightColumn.add(b11);
        b.add(leftColumn);
        b.add(rightColumn);
        
        add(b, BorderLayout.NORTH);
        add(jb, BorderLayout.SOUTH);
        
        jb.addActionListener(e -> clearDisks(e));
        
        b00.addMouseListener(me);
        b01.addMouseListener(me);
        b10.addMouseListener(me);
        b11.addMouseListener(me);
        
        jb.setFont(new Font("Arial", Font.PLAIN, 22));
        
        pack(); 
        setVisible(true);
        setResizable(false);
    }
    
    /** Clear all four disks. */
    public void clearDisks(ActionEvent e) {
        b00.clearDisk();
        b01.clearDisk();
        b10.clearDisk();
        b11.clearDisk(); 
    }
}
