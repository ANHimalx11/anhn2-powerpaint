/*
 * Anh Nguyen TCSS305C - Winter Assignment 5b - Power Paint AbstractTool.java An
 * abstract class that contains methods for tools.
 * 
 */

package tools;

import java.awt.Point;


/**
 * This is an abstract class for all tools to extend from.
 * 
 * @author Anh Nguyen
 * @version 1.3
 */
public abstract class AbstractTool implements Toolable {

    // Instance fields
    /**
     * myStartPoint for all tools to use.
     */
    protected Point myStartPoint;

    /**
     * myEndPoint for all tools to use.
     */
    protected Point myEndPoint;

    /**
     * This method gets myStartPoint.
     * @return myStartPoint
     */
    public Point getMyStartPoint() {
        return myStartPoint;
    }

    /**
     * This method sets the starting point.
     * @param theStartPoint the beginning point
     */
    public void setMyStartPoint(final Point theStartPoint) {
        myStartPoint = theStartPoint;
    }

    /**
     * This method retrieves a Point.
     * @return myEndPoint a point object.
     */
    public Point getMyEndPoint() {
        return myEndPoint;
    }
    /**
     * This methods sets the end point.
     * @param theEndPoint a point object.
     */
    public void setMyEndPoint(final Point theEndPoint) {
        myEndPoint = theEndPoint;
    }

}
