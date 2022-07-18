import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

/** An instance has a text field and a slider, which represents a
    temperature in Fahrenheit. Move the slider and the text field changes
    to contain the corresponding temperature. Change the text field to a
    different temperature and the slider changes accordingly

    There is a second text field and slider that represents the
    temperature in Centigrade. It works the same way.

    Further, the two temperature systems are connected: change one and
    the other changes. All values are truncated to the nearest integer.

    This class has a method main, which creates and shows one instance
    of this class. Change the arguments of the constructor call
    to get sliders with different ranges.
 */

public class TemperatureSlider extends JFrame {
    /* The variable names will tell you what they mean.
       fahr stands for Fahrenheit, cent for Centigrade.
       min for minimum, max for maximum, initial for initial value 
     */
    private int fahrMin;
    private int fahrMax;
    private int fahrInitial;
    private int centMin;
    private int centMax;
    private int centInitial;
    private JTextField fahrField;
    private JTextField centField;
    private JSlider fahrSlider;
    private JSlider centSlider;
    private JLabel fahrLabel= new JLabel("Fahrenheit ", 11);
    private JLabel centLabel= new JLabel("Centigrade ", 11);

    private Box fahrBox=  new Box(BoxLayout.X_AXIS);
    private Box centBox=  new Box(BoxLayout.X_AXIS);
    private Box outerBox= new Box(BoxLayout.Y_AXIS);

    /** Show the GUI
     *  In the call on the constructor of TemperatureSlider, below,
       change the first two arguments 0..50 to get a different
       Fahrenheit scale, e.g. to 32..212. Change the initial
       value 100 accordingly.
     */
    public static void main(String[] pars) {
        TemperatureSlider gui= new TemperatureSlider(0, 50, 32);
    }


    /** Constructor: a window with fahrenheit and centigrade
        sliders and textfields, where the fahrenheit slider is
        in the range fmin..fmax and has initial value finit.
        If finit is not in fmin..fmax, it is set to fmin or fmax.
     */
    public TemperatureSlider(int fmin, int fmax, int finit ) {
        super("TemperatureSlider");
        compute(fmin, fmax, finit);

        // Fix all the Fahrenheit components
        fahrField= new JTextField(String.valueOf(fahrInitial), 5);
        fahrField.addActionListener(e -> reactToFieldChange(e));

        fahrSlider= new JSlider(JSlider.HORIZONTAL, 
                fahrMin, fahrMax, fahrInitial);
        fahrSlider.addChangeListener(e -> reactToSlider(e));

        fahrSlider.setMajorTickSpacing((fahrMax-fahrMin)/5);
        fahrSlider.setMinorTickSpacing((fahrMax-fahrMin)/20);
        fahrSlider.setPaintTicks(true);
        fahrSlider.createStandardLabels((fahrMax-fahrMin)/5);
        fahrSlider.setPaintLabels(true);
        int fahrW= 500;
        int fahrH= fahrSlider.getPreferredSize().height;
        fahrSlider.setPreferredSize(new Dimension(fahrW,fahrH));


        // Fix all the Centigrade components
        centField= new JTextField(String.valueOf(centInitial), 5);
        centField.addActionListener(e -> reactToFieldChange(e));     

        centSlider= new JSlider(JSlider.HORIZONTAL, 
                centMin, centMax, centInitial);
        centSlider.addChangeListener(e -> reactToSlider(e));

        centSlider.setMajorTickSpacing((centMax-centMin)/5);
        centSlider.setMinorTickSpacing((centMax-centMin)/20);
        centSlider.setPaintTicks(true);
        centSlider.createStandardLabels((centMax-centMin)/5);
        centSlider.setPaintLabels(true);
        int centW= 500;
        int centH= centSlider.getPreferredSize().height;
        centSlider.setPreferredSize(new Dimension(centW,centH));

        // Place components in the content pane
        fahrBox.add(fahrField);
        fahrBox.add(fahrSlider);
        fahrBox.add(fahrLabel);
        outerBox.add(fahrBox);

        centBox.add(centField);
        centBox.add(centSlider);
        centBox.add(centLabel);
        outerBox.add(centBox);

        Container cp= getContentPane();
        cp.add(outerBox, BorderLayout.CENTER);
        cp.add(new JLabel(" "), BorderLayout.SOUTH);

        pack();
        setVisible(true);
    }

    /* Compute the fields, based on the range fmin..fmax
       and initial value finit for Fahrenheit */
    private void compute(int fmin, int fmax, int finit) {
        fahrMin= fmin;
        fahrMax= fmax;
        if (finit < fmin) finit= fmin;
        if (finit > fmax) finit= fmax;
        fahrInitial= finit;
        centMin= fahrToCent(fahrMin);
        centMax= fahrToCent(fahrMax);
        centInitial= fahrToCent(fahrInitial);
    }

    /** = fahrenheit temperature f, but in centigrade */
    public static int fahrToCent(int f) {
        return ((f-32)*5)/9;
    }

    /** = centigrade temperature c, but in fahrenheit */
    public static int centToFahr(int c) {
        return 32 + c*9/5;
    }

    /** If the event is on fahrSlider and it is not still
    adjusting, then change the 2 text fields and slider
    centSlider to the value of fahrSlider.
    If the event is on centSlider, do the similar thing. */
    public void reactToSlider(ChangeEvent e) {
        JSlider source= (JSlider)e.getSource();
        if (source.getValueIsAdjusting()) return;

        /* The following statement is needed to ensure that this
           method won't be called a second time while this call is
           doing it's job. Without this, one gets weird behavior.
           Delete it and see --then put it back.
         */
        source.setValueIsAdjusting(true);

        if (source == fahrSlider) {
            int f= fahrSlider.getValue();
            setScales(f, fahrToCent(f));
        }

        if (source == centSlider) {
            int c= centSlider.getValue();
            setScales(centToFahr(c), c);
        }
    }    

    /** Set the Fahrenheit scale to f and the Centigrade scale to c */
    private void setScales(int f, int c) {
        fahrSlider.setValue(f);
        centSlider.setValue(c);
        fahrField.setText(String.valueOf(f));
        centField.setText(String.valueOf(c));
    }

    /** If e is a return key in text field fahrField and the
    value is in the range fahrMin..fahrMax, change the
    other text field and the two sliders to this value.
    If e is a return key in text field centField, do the similar thing. */
    public void reactToFieldChange(ActionEvent e) {
        JTextField source= (JTextField)e.getSource();
        int fahrv= 0;
        int centv= 0;
        if (source == fahrField) {
            int f= getValue(fahrField, fahrSlider);
            setScales(f, fahrToCent(f));
        }

        if (source == centField) {
            int c= getValue(centField, centSlider);
            setScales(centToFahr(c), c);
        }

    }

    /** = the value of text field f in relation to slider s.
          If the text in f is not an integer or is not in the 
          range of s, return s's value. */
    private int getValue(JTextField f, JSlider s) {
        int v= 0;
        try {
            v= Integer.parseInt(f.getText().trim());
        }
        catch (NumberFormatException exception) {
            return s.getValue();
        }
        if (v < s.getMinimum())  return s.getValue();
        if (s.getMaximum() < v)  return s.getValue();
        return v;
    }


}
