package cs2110;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

/**
 * A square widget whose color depends on its row and column<br>
 * number and which shows when it has been selected by a mouse click.
 */
public class CheckerSquare extends JPanel implements MouseListener {
    /** Row number of this square on the board. */
    int row;

    /** Column number of this square on the board. */
    int col;

    boolean isSelected;

    /** Construct a new CheckerSquare at row r, column c. */
    public CheckerSquare(int r, int c) {
        row = r;
        col = c;

        setPreferredSize(new Dimension(96, 96));
        addMouseListener(this);
    }

    /** Inverts selection state. Requests a repaint to update appearance. */
    public void toggleSelected() {
        isSelected = !isSelected;
        repaint();
    }

    /** Clear selection state. Requests a repaint to update appearance. */
    public void deselect() {
        isSelected = false;
        repaint();
    }

    /**
     * Fill square green if sum of row and column numbers are even, red if odd.<br>
     * Fill pink circle if selected.<br>
     * Draw a black border, and draw text with row and column coordinates.
     */
    @Override
    public void paintComponent(Graphics g) {
        g.setColor((row + col) % 2 == 0 ? Color.GREEN : Color.RED);
        g.fillRect(0, 0, getWidth(), getHeight());
        if (isSelected) {
            g.setColor(Color.PINK);
            g.fillOval(8, 8, getWidth() - 16, getHeight() - 16);
        }
        g.setColor(Color.BLACK);
        g.drawRect(0, 0, getWidth() - 1, getHeight() - 1);
        g.drawString(row + ", " + col, 24, 24);
    }

    /** Invert selection state when mouse is clicked. */
    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println("Mouse click at " + e.getX() + ", " + e.getY());
        toggleSelected();
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }
}
