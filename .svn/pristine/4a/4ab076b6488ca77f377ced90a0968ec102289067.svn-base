/*
 * Anh Nguyen 
 * TCSS305C - Winter 
 * Assignment 5b - Power Paint 
 * Rectangle.java This
 * tool creates a rectangle.
 * 
 */

package tools;


import java.awt.Shape;
import java.awt.event.MouseEvent;
import java.awt.geom.Rectangle2D;

/**
 * This is a tool that creates rectangles.
 * 
 * @author Anh Nguyen
 * @version 1.0
 *
 */
public class Rectangle extends AbstractTool {
    
    //instance field
    /**
     * This is a Rectangle2D object.
     */
    private Rectangle2D myRect;

    /**
     * This is the constructor for Rectangle tool.
     */
    public Rectangle() {
        super();
        myRect = new Rectangle2D.Double();
    }

    @Override
    public Shape getShapeInstance() {
        // TODO Auto-generated method stub
        return myRect;
    }

    @Override
    public Shape getCopy() {
        final Rectangle2D tempRect = (Rectangle2D) myRect.clone();
        myRect = new Rectangle2D.Double(OFF_SET, 0, 0, 0);
        return tempRect;
    }

    @Override
    public Shape getShape() {
        // make a defensive copy
        final Rectangle2D tempRect = (Rectangle2D) myRect.clone();

        return tempRect;
    }

    @Override
    public void mousePressing(final MouseEvent theEvent) {

        setMyStartPoint(theEvent.getPoint());
        myRect.setFrameFromDiagonal(myStartPoint, theEvent.getPoint());

    }

    @Override
    public void mouseReleasing(final MouseEvent theEvent) {
        setMyEndPoint(theEvent.getPoint());
        myRect.setFrameFromDiagonal(myStartPoint, myEndPoint);
        
    }

    @Override
    public void mouseDragging(final MouseEvent theEvent) {
        setMyEndPoint(theEvent.getPoint());
        myRect.setFrameFromDiagonal(myStartPoint, myEndPoint);

    }
}
