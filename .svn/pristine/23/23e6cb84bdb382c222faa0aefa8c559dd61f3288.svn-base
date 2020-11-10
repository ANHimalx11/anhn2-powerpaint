/*
 * Anh Nguyen 
 * TCSS305C - Winter 
 * Assignment 5b - Power Paint 
 * ToolAction.java
 * This class extends AbstractAction for all the tools.
 * 
 */
package action;

import gui.DrawingArea;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ImageIcon;

import tools.Toolable;

/**
 * 
 * @author Anh Nguyen
 * @version 1.0
 */
public class ToolAction extends AbstractAction {
    
    /**
     * This is a generated serialVersionUID.
     */
    private static final long serialVersionUID = -649542084650115883L;

    //Class Instance fields
    
    /**
     * The current selected tool.
     */
    private final Toolable mySelectedTool;
    
    /**
     * This is the drawing area for the application.
     */
    private final DrawingArea myDrawArea;

    /**
     * This is the constructor for the ToolAction class.
     * @param theName The name of the tool.
     * @param theIcon The icon of the tool.
     * @param theMnemonic the Mnemonic of the tool.
     * @param theTool The actual tool itself.
     * @param theArea The drawing area.
     */
    public ToolAction(final String theName, final ImageIcon theIcon, 
                      final int theMnemonic, final Toolable theTool, 
                      final DrawingArea theArea) {
        super(theName, theIcon);
        
        //add the name of the tool.
        putValue(ACTION_COMMAND_KEY, theName);
        
        //add the icon 
        putValue(Action.LARGE_ICON_KEY, theIcon);
        
        //add the mnemonic key for the tool.
        putValue(Action.MNEMONIC_KEY, theMnemonic);

        mySelectedTool = theTool;
        myDrawArea = theArea;
        
        putValue(Action.SELECTED_KEY, true);
    }

    @Override
    public void actionPerformed(final ActionEvent theEvent) {

        myDrawArea.setTool(mySelectedTool);
    }

}
