/*
 * Anh Nguyen 
 * TCSS305C - Winter 
 * Assignment 5b - Power Paint 
 * PowerPaintGUI.java
 * This class contains all the necessary components to 
 * create the GUI forPowerPaint.
 * 
 */

package gui;

import java.awt.BorderLayout;
import java.awt.Cursor;

import javax.swing.ImageIcon;
import javax.swing.JFrame;


/**
 * This is the GUI constructor class that will provide components for the Power
 * Paint application.
 * 
 * @author Anh Nguyen
 * @version 1.3
 *
 */
public class PowerPaintGUI extends JFrame {

    // Class constant.
    /**
     * This is an auto generated serial number for PowerPaintGUI.
     */
    private static final long serialVersionUID = -6870003831272220140L;

    /**
     * This is the title name of the application.
     */
    private static final String TITLE_NAME = "PowerPaint";

    // Class instance
    /**
     * The drawing area for the application.
     */
    private DrawingArea myDrawingArea;
    
    /**
     * This is the constructor for PowerPaintGUI.
     */
    public PowerPaintGUI() {
        super(TITLE_NAME);

    }

    /**
     * This method will start off calling all necessary methods to create the
     * PowerPaintGUI.
     */
    public void start() {

        // setting location to center screen
        setLocationRelativeTo(null);

        // add icon to title bar.
        final ImageIcon icon = new ImageIcon("images/myGamingIcon.png");
        setIconImage(icon.getImage());

        // This will close our application.
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // add drawing area
        addDrawArea();
        pack();
        setPreferredSize(getSize());

        // Create the Menu Bar and its contents.
        final MenuAndTool mtBar = new MenuAndTool(this, myDrawingArea);
        mtBar.makeTheToolAndMenu();

        // setting location to center screen
        setLocationRelativeTo(null);

        // Make everything visible.
        setVisible(true);
    }

    /**
     * This method adds the drawing area to the application.
     */
    private void addDrawArea() {
        //add the JPanel
        myDrawingArea = new DrawingArea();
        add(myDrawingArea, BorderLayout.CENTER);
        //set the cursor
        myDrawingArea.setCursor(Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));
        
    }

}
