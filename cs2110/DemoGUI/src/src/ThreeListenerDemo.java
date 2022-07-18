import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;

/** 
 * An instance of this class is a frame that is associated with an
   output file and that contains
     (1) A text field
     (2) A text area
     (3) An enter button
     (4) A quit button

   Whenever the enter button is clicked or the enter key is stroked
   when in the text field, three things happen:
     (1) The text in the text field is appended to the text area, in
         upper case form;
     (2) The text in the text field is appended to the output file;
     (3) The text field is set to the empty string and given the focus.

   The above three tasks are handled by three individual listeners,
   which are registered for the text field and for the enter button.

   The class contains a method main that creates one instance of the
   class, obtaining the output file from the user using a dialog box.
   The output file is APPENDED to, not overwritten.
 */
public class ThreeListenerDemo extends JFrame {

    JTextField field= new JTextField(15);
    JTextArea area= new JTextArea(5,15);
    JLabel label= new JLabel("  Type input here.");
    JButton buttonLine= new JButton("Enter text");
    JButton buttonQuit= new JButton("Quit");

    PrintStream output;

    /** Constructor, which outputs to ps */
    public ThreeListenerDemo(PrintStream ps) {
        super("ThreeListenerDemo");
        output= ps;

        Box bLeft= new Box(BoxLayout.Y_AXIS);
        bLeft.add(field);
        bLeft.add(new JScrollPane(area));

        Box bRight= new Box(BoxLayout.Y_AXIS);
        bRight.add(label);
        bRight.add(Box.createVerticalGlue());
        bRight.add(buttonLine);
        bRight.add(Box.createVerticalGlue());
        bRight.add(buttonQuit);

        Box b= new Box(BoxLayout.X_AXIS);
        b.add(bLeft);
        b.add(bRight);

        area.setEditable(false);
        
        ActionListener clearField= e -> clearTextField(e);

        buttonLine.addActionListener(clearField);
        buttonLine.addActionListener(e -> appendTextFieldToArea(e));
        buttonLine.addActionListener(e -> appendTextField(e));

        field.addActionListener(clearField);
        field.addActionListener(e -> appendTextFieldToArea(e));
        field.addActionListener(e -> appendTextField(e));

        buttonQuit.addActionListener(e -> quit(e));

        add(b, BorderLayout.CENTER);
        pack();
        setVisible(true);
    }


    /** Close file output, dispose of this JFrame. */
    public void quit(ActionEvent e) {
        output.close();
        dispose();
    }

    /** Append the text field, in upper-case form, to the text area. */
    public void appendTextFieldToArea(ActionEvent e) {
        String x= field.getText();
        area.append(x.toUpperCase() + "\n");
    }

    /** Set text field to "" and give it the focus. */ 
    public void clearTextField(ActionEvent e) {
        field.setText("");
        field.grabFocus();
    }

    /** Append text field to output file if text field is not "". */ 
    public void appendTextField(ActionEvent e) {
        if (!field.getText().equals("")) {
            output.println(field.getText());
        }
    }


    /** Get an output file name f (say) from the user, create
     an instance of ThreeListenerDemo that is attached to it,
     make it visible, and give the text field the focus.
     */
    public static void main(String args[]) {
        JFileChooser jc= new JFileChooser();
        jc.setDialogTitle("Choose an outputfile");
        jc.showDialog(null, "OK");
        File f= jc.getSelectedFile();
        if (f == null)
        {  System.exit(0);  }
        String fileName= f.getName();
        System.out.println("Output will be appended to file " + fileName);
        PrintStream file= null;
        try {
            file= new PrintStream(
                    new FileOutputStream(fileName, true));
        }
        catch (IOException e) {
            System.out.println("IO error in creating output file.");
            System.exit(0);
        }
        ThreeListenerDemo frame= new ThreeListenerDemo(file);
        frame.setFontAndSizes();
        frame.setVisible(true);
        frame.field.grabFocus();
    }
    
    /** Set the font and font size for all field components. */
    public void setFontAndSizes() {
        field.setFont(new Font("Arial", Font.PLAIN, 22));
        area.setFont(new Font("Arial", Font.PLAIN, 22));
        label.setFont(new Font("Arial", Font.PLAIN, 22));
        buttonLine.setFont(new Font("Arial", Font.PLAIN, 22));
        buttonQuit.setFont(new Font("Arial", Font.PLAIN, 22));
    }
}

