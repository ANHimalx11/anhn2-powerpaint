/*
 * Anh Nguyen TCSS305C - Winter Assignment 5b - Power Paint CustomIcon.java This
 * class creates a custom icon for the color icon in the Menu.
 * 
 */

package gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;

import javax.swing.Icon;

/**
 * This class implements Icon in order to create a custom icon for PowerPaint.
 * 
 * @author Anh Nguyen
 * @version 1.0
 */
public class CustomIcon implements Icon {

    // Class Constant
    /**
     * This is a constant for the size of the Icon in the menu.
     */
    private static final int ICON_SIZE = 15;

    // Class Instance fields
    /**
     * The color of the icon.
     */
    private Color myColor;

    /**
     * The constructor of the custom icon.
     * @param theColor the color of the icon.
     */
    public CustomIcon(final Color theColor) {

        super();

        myColor = theColor;
    }

    @Override
    public void paintIcon(final Component theComponent, final Graphics theGraphics,
                          final int theX, final int theY) {
        
        theGraphics.setColor(myColor);
        theGraphics.fillRect(theX, theY, getIconWidth(), getIconHeight());
        
    }
    
    /**
     * This method sets the icon color.
     * @param theColor is the color of the icon.
     */
    public void setColorIcon(final Color theColor) {
        
        myColor = theColor;
    }

    @Override
    public int getIconWidth() {
        // TODO Auto-generated method stub
        return ICON_SIZE;
    }

    @Override
    public int getIconHeight() {
        // TODO Auto-generated method stub
        return ICON_SIZE;
    }

}
