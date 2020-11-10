/*
 * Anh Nguyen TCSS305C - Winter Assignment 5b - Power Paint Pencil.java This
 * class is a tool that acts as a pencil.
 * 
 */

package tools;

import java.awt.Shape;
import java.awt.event.MouseEvent;
import java.awt.geom.GeneralPath;
import java.awt.geom.Path2D;

/**
 * This is a tool that acts as a pencil.
 * 
 * @author Anh Nguyen
 * @version 1.0
 *
 */
public class Pencil extends AbstractTool {
    // Class Instance Field
    /**
     * myPencilpath is a Path2D object.
     */
    private Path2D myPencilPath;

    /**
     * This constructor for the pencil tool.
     */
    public Pencil() {
        super();
        myPencilPath = new GeneralPath();
    }

    @Override
    public Shape getShape() {

        // myPencilPath = new GeneralPath();
        final Path2D tempPath = (Path2D) myPencilPath.clone();

        return tempPath;
        // return myPencilPath;
    }

    @Override
    public void mousePressing(final MouseEvent theEvent) {
        setMyStartPoint(theEvent.getPoint());
        myPencilPath.moveTo(myStartPoint.getX(), myStartPoint.getY());

    }

    @Override
    public void mouseReleasing(final MouseEvent theEvent) {
        setMyEndPoint(theEvent.getPoint());

        myPencilPath.lineTo(myEndPoint.getX(), myEndPoint.getY());

    }

    @Override
    public void mouseDragging(final MouseEvent theEvent) {

        setMyEndPoint(theEvent.getPoint());
        myPencilPath.lineTo(myEndPoint.getX(), myEndPoint.getY());

    }

    @Override
    public Shape getShapeInstance() {
        
        return myPencilPath;
    }

    @Override
    public Shape getCopy() {
        final Path2D tempPath = (Path2D) myPencilPath.clone();
        myPencilPath = new GeneralPath();
        return tempPath;
    }

}
