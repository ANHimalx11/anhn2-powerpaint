/*
 * Anh Nguyen TCSS305C - Winter Assignment 5b - Power Paint Line.java This is a
 * tool that draws a line.
 * 
 */

package tools;

import java.awt.Shape;
import java.awt.event.MouseEvent;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;

/**
 * This is a tool that draws a line.
 * 
 * @author Anh Nguyen
 * @version 1.0
 *
 */
public class Line extends AbstractTool {
    // Instance fields
    /**
     * myLine is line2D object.
     */
    private Line2D myLine;

    /**
     * This is the constructor for the Line tool.
     */
    public Line() {
        super();
        myLine = new Line2D.Double(OFF_SET, 0, OFF_SET, 0);
    }

    @Override
    public Shape getShape() {
        // make a defensive copy
        final Line2D tempLine = (Line2D) myLine.clone();

        return tempLine;
    }

    @Override
    public void mousePressing(final MouseEvent theEvent) {
        myStartPoint = theEvent.getPoint();

    }

    @Override
    public void mouseReleasing(final MouseEvent theEvent) {
        myEndPoint = theEvent.getPoint();
        myLine.setLine(myStartPoint, myEndPoint);

    }

    @Override
    public void mouseDragging(final MouseEvent theEvent) {
        final Point2D middlePoint = theEvent.getPoint();
        myLine.setLine(myStartPoint, middlePoint);

    }

    @Override
    public Shape getShapeInstance() {
        // TODO Auto-generated method stub
        return myLine;
    }

    @Override
    public Shape getCopy() {
        final Line2D tempLine = (Line2D) myLine.clone();
        myLine = new Line2D.Double(OFF_SET, 0, OFF_SET, 0);
        return tempLine;
    }

}
