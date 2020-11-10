package tools;

import java.awt.Shape;
import java.awt.event.MouseEvent;


/**
 * This is an interface that has undefined methods for tools.
 * @author Anh Nguyen
 * @version 1.0
 */
public interface Toolable {
    //static variable
    /**
     * This int is to move the dot to the side.
     */
    int OFF_SET = -10;
 
    /**
     * Allows tools to get the shape.
     * @return A shape that the tool produces.
     */
    Shape getShape();
    
    /**
     * This method allows g2D to have access and draw the shape.
     * @return a shape.
     */
    Shape getShapeInstance();
    
    /**
     * Make a deep copy.
     * @return a deep copy.
     */
    Shape getCopy();

    
    /**
     * What happens when the mouse is pressed.
     * @param theEvent a mouse event to access Point information.
    */
    void mousePressing(MouseEvent theEvent);
    
    /**
     * What happens when the mouse is releasing.
     * @param theEvent a mouse event to access Point information.
     */
    void mouseReleasing(MouseEvent theEvent);
    
    /**
     * What happens when the mouse is dragging.
     * @param theEvent a mouse event to access Point information.
     */
    void mouseDragging(MouseEvent theEvent);

}
