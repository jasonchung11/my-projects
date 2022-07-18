package cs2110;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class DemoMain {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {

            JFrame frame= new JFrame("Checkerboard demo");

            JPanel panel= new JPanel(new GridLayout(2, 2));
            panel.add(new CheckerSquare(0, 0));
            panel.add(new CheckerSquare(0, 1));
            panel.add(new CheckerSquare(1, 0));
            panel.add(new CheckerSquare(1, 1));
            frame.add(panel);

            JButton button= new JButton("Reset");
            button.addActionListener(e -> {
                for (Component c : panel.getComponents()) {
                    ((CheckerSquare) c).deselect();
                }
            });
            frame.add(button, BorderLayout.SOUTH);

            frame.pack();
            frame.setVisible(true);

        });
    }
}
