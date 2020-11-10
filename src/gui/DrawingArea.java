/*
 * Anh Nguyen TCSS305C - Winter Assignment 5b - Power Paint DrawingArea.java
 * This class will create a drawing area for the user to draw.
 */

package gui;

import java.awt.BasicStroke;
import java.awt.Color;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.swing.JPanel;
import javax.swing.event.MouseInputAdapter;

import model.Shapes;

import tools.Toolable;

/**
 * This class creates a drawing area for PowerPaint.
 * 
 * @author Anh Nguyen
 * @version 1.5
 */
public class DrawingArea extends JPanel {

    // Class constant

    /**
     * An int value representing the width for the window.
     */
    private static final int PREF_WIDTH = 500;

    /**
     * An int value representing the height for the window.
     */
    private static final int PREF_HEIGHT = 400;

    /**
     * A constant for the preferred size for the drawing area.
     */
    private static final Dimension PREF_SIZE = new Dimension(PREF_WIDTH, PREF_HEIGHT);

    /**
     * This is an auto-generated Serial number for DrawingArea.
     */
    private static final long serialVersionUID = -6299431629309349243L;

    // Instance fields
    /**
     * The current tool selected.
     */
    private Toolable myCurrentTool;

    /**
     * The current stroke width.
     */
    private int myCurrentStroke;

    /**
     * The current color of what is being drawn.
     */
    private Color myCurrentColor;

    /**
     * A List of shapes.
     */
    private final List<Shapes> myShapesList;

    //    /**
    //     * A boolean value for whether squares and circles is checked.
    //     */
    //    private boolean myCheckBox;

    /**
     * This is a constructor to create a drawing area.
     */
    public DrawingArea() {
        super();
        setBackground(Color.WHITE);
        setOpaque(true);

        myShapesList = new ArrayList<Shapes>();

        setPreferredSize(PREF_SIZE);

        setUpComponent();


    }

    /**
     * This method helps to set up the mouse/listener adapter.
     */
    private void setUpComponent() {
        final MouseInputAdapter mIA = new MyMouseInputAdapter();

        // add mouse listeners to the JPanel.
        addMouseListener(mIA);
        addMouseMotionListener(mIA);

    }

    // Override paintComponent
    @Override
    public void paintComponent(final Graphics theG) {
        super.paintComponent(theG);
        final Graphics2D g2D = (Graphics2D) theG;

        // make the drawings look better.
        g2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                             RenderingHints.VALUE_ANTIALIAS_ON);
        // setting current shape
        for (final Shapes s : myShapesList) {
            g2D.setPaint(s.getColor());
            g2D.setStroke(new BasicStroke(s.getStroke()));
            g2D.draw(s.getShape());

        }

        if (Objects.nonNull(myCurrentTool)) {

            // reset the g2D to the current settings
            g2D.setPaint(myCurrentColor);
            g2D.setStroke(new BasicStroke(myCurrentStroke));
            g2D.draw(myCurrentTool.getShapeInstance());

        }

    }

    /**
     * A method that retrieves the stroke value from JSlider.
     * 
     * @param theStroke an int value for the width of the stroke.
     */
    public void setStrokeThick(final int theStroke) {
        myCurrentStroke = theStroke;
    }

    /**
     * A method the gets the stroke of the object.
     * 
     * @return myCurrentStroke an int value that represents the stroke
     */
    public int getStrokeThick() {

        return myCurrentStroke;
    }

    /**
     * This method gets the current tool.
     * 
     * @return myCurrentTool the current tool being used.
     */
    public Toolable getTool() {
        return myCurrentTool;

    }

    /**
     * This method sets the current tool.
     * 
     * @param theTool is a tool object being passed as an argument.
     */
    public void setTool(final Toolable theTool) {
        myCurrentTool = theTool;

    }

    /**
     * This getter gets the current color.
     * 
     * @return myCurrentColor the current color.
     */
    public Color getColor() {
        return myCurrentColor;
    }

    /**
     * This sets the current color to the new color.
     * 
     * @param theColor setting the new color.
     */
    public void setColor(final Color theColor) {
        myCurrentColor = theColor;
    }

    /**
     * This method gets the size of the list.
     * 
     * @return an int value of the size of the list.
     */
    public int getListSize() {
        return myShapesList.size();

    }

    /**
     * This method clears the list of shapes.
     */
    public void clearList() {
        myShapesList.clear();
        updateUI();
        repaint();
    }

    //    /**
    //     * This method gets a boolean value.
    //     * 
    //     * @return whether the box is checked.
    //     */
    //    public boolean isCheckBox() {
    //        return myCheckBox;
    //    }

    //    /**
    //     * This method sets the box as checked.
    //     * 
    //     * @param theBox a boolean value.
    //     */
    //    public void setCheckBox(final boolean theBox) {
    //        myCheckBox = theBox;
    //    }

    /**
     * This is an inner class that creates a mouse adapter.
     * 
     * @author Anh Nguyen
     * @version 1.0
     */
    class MyMouseInputAdapter extends MouseInputAdapter {

        /**
         * What happens when mouse is pressed.
         * 
         * @param theEvent a mouse event.
         */
        public void mousePressed(final MouseEvent theEvent) {
            if (myCurrentStroke > 0) {
                myCurrentTool.mousePressing(theEvent);

                repaint();
            }
        }

        /**
         * What happens when mouse is dragged.
         * 
         * @param theEvent a mouse event.
         */
        public void mouseDragged(final MouseEvent theEvent) {
            if (myCurrentStroke > 0) {
                myCurrentTool.mouseDragging(theEvent);

                repaint();
            }
        }

        /**
         * What happens when mouse is released.
         * 
         * @param theEvent a mouse event.
         */
        public void mouseReleased(final MouseEvent theEvent) {
            if (myCurrentStroke > 0) {
                myCurrentTool.mouseReleasing(theEvent);

                myShapesList.add(new Shapes(myCurrentTool.getCopy(), myCurrentColor,
                                            myCurrentStroke));
                repaint();
            }
        }
    }
}
