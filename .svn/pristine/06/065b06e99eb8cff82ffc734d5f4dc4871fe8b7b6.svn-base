/*
 * Anh Nguyen 
 * TCSS305C - Winter 
 * Assignment 5b - Power Paint 
 * Ellipse.java This
 * tool creates an Ellipse.
 * 
 */

package tools;

import java.awt.Shape;
import java.awt.event.MouseEvent;
import java.awt.geom.Ellipse2D;


/**
 * 
 * @author Anh Nguyen
 * @version 1.0
 *
 */
public class Ellipse extends AbstractTool {
    
    /**
     * This is an Ellipse object.
     */
    private Ellipse2D myEllipse;

    /**
     * This is the constructor for an ellipse tool.
     */
    public Ellipse() {
        super();
        myEllipse = new Ellipse2D.Double();
    }

    @Override
    public Shape getShapeInstance() {
        return myEllipse;
    }

    @Override
    public Shape getCopy() {
        final Ellipse2D tempEllipse = (Ellipse2D) myEllipse.clone();
        myEllipse = new Ellipse2D.Double(OFF_SET, 0, 0, 0);
        return tempEllipse;
    }

    @Override
    public Shape getShape() {
        final Ellipse2D tempEllipse = (Ellipse2D) myEllipse.clone();

        return tempEllipse;
    }

    @Override
    public void mousePressing(final MouseEvent theEvent) {

        setMyStartPoint(theEvent.getPoint());
        myEllipse.setFrameFromDiagonal(myStartPoint, theEvent.getPoint());

    }

    @Override
    public void mouseReleasing(final MouseEvent theEvent) {
        setMyEndPoint(theEvent.getPoint());
        myEllipse.setFrameFromDiagonal(myStartPoint, myEndPoint);
        
        //if the box is checked
        
        
    }

    @Override
    public void mouseDragging(final MouseEvent theEvent) {
        setMyEndPoint(theEvent.getPoint());
        myEllipse.setFrameFromDiagonal(myStartPoint, myEndPoint);

    }

}
