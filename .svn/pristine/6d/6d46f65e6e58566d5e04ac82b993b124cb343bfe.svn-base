/*
 * Anh Nguyen TCSS305C - Winter Assignment 5b - Power Paint MenuAndTool.java
 * This class creates the MenuBar and ToolBar for the PowerPaint application.
 * 
 */

package gui;

import action.ToolAction;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//import java.awt.event.ItemEvent;
//import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JSlider;
import javax.swing.JToggleButton;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;

import tools.Ellipse;
import tools.Line;
import tools.Pencil;
import tools.Rectangle;

/**
 * This class creates the Menu Bar for the PowerPaint application.
 * 
 * @author Anh Nguyen
 * @version 1.4
 *
 */
public class MenuAndTool {

    // Class Constants
    /**
     * Max thickness of shapes drawn for the slider option.
     */
    private static final int MAX_THICKNESS = 20;

    /**
     * The major ticking size of slider option.
     */
    private static final int MAJOR_TICK = 5;

    /**
     * The minor ticking size of slider option..
     */
    private static final int MINOR_TICK = 1;

    /**
     * Initial thickness of shapes drawn for the slider option.
     */
    private static final int INITIAL_THICKNESS = 5;

    /**
     * This is a string for the About message.
     */
    private static final String ABOUT_MESSAGE = "TCSS 305 PowerPaint\nWinter 2016\nAnh Nguyen";

    /**
     * This is a temporary color for the initial paint.
     */
    private static final Color UW_PURPLE = new Color(51, 0, 111);

    // Class Instance Fields

    /**
     * A menu bar for the application.
     */
    private JMenuBar myMenuBar;

    /**
     * A JFrame object.
     */
    private final JFrame myFrame;

    /**
     * This is a JSlider component used for stroke value.
     */
    private JSlider mySlider;

    /**
     * A drawing area.
     */
    private final DrawingArea myArea;

    /**
     * A list of all my actions.
     */
    private List<ToolAction> myToolActions;

    /**
     * This is a constructor for a MenuBar object.
     * 
     * @param theFrame is object sent as a parameter.
     * @param theArea is the area that is being drawn on.
     */
    public MenuAndTool(final JFrame theFrame, final DrawingArea theArea) {
        myFrame = theFrame;
        myArea = theArea;
    }

    /**
     * This method calls all the methods within the class to make the MenuBar.
     */
    public void makeTheToolAndMenu() {
        // Create the Menu Bar and its contents.
        createMenuBar();
        createFileMenu();
        createOptionsMenu();
        createToolsMenu();
        createHelpMenu();

        // Create the ToolBar
        createToolBar();
    }

    /**
     * This method creates a menu bar for the application.
     */
    private void createMenuBar() {
        myMenuBar = new JMenuBar();
        myFrame.setJMenuBar(myMenuBar);
    }

    /**
     * This method creates a tool bar for the application.
     */
    private void createToolBar() {
        final JToolBar toolBar = new JToolBar();

        // Add all the buttons into the JToolBar.
        final ButtonGroup toolBarGrp = new ButtonGroup();
        for (final ToolAction jTA : myToolActions) {
            final JToggleButton tb = new JToggleButton(jTA);

            // add JToggleButtons to group and ToolBar.
            toolBarGrp.add(tb);
            toolBar.add(tb);
        }
        // Add ToolBar to the application.
        myFrame.add(toolBar, BorderLayout.SOUTH);
    }

    /**
     * This method creates the contents for the File menu.
     */
    private void createFileMenu() {
        final JMenu file = new JMenu("File");
        myMenuBar.add(file);
        file.setMnemonic(KeyEvent.VK_F);

        // Create and add contents of File.
        final JMenuItem undo = new JMenuItem("Undo all changes");
        undo.setEnabled(false);

        undo.setMnemonic(KeyEvent.VK_U);

        // making an anonymous inner class to clear the list.
        undo.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(final ActionEvent theEvent) {
                myArea.clearList();
            }
        });

        final JMenuItem exit = new JMenuItem("Exit");
        exit.setMnemonic(KeyEvent.VK_E);

        // Create actionListener when exit button is pressed.
        exit.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(final ActionEvent theEvent) {
                myFrame.dispose();
            }
        });

        // check if the list is null then set exit to false.
        file.addMenuListener(new MenuListener() {

            @Override
            public void menuSelected(final MenuEvent theEvent) {
                if (myArea.getListSize() == 0) {
                    undo.setEnabled(false);
                } else {
                    undo.setEnabled(true);
                }
            }

            @Override
            public void menuDeselected(final MenuEvent theEvent) {
            }

            @Override
            public void menuCanceled(final MenuEvent theEvent) {
            }
        });
        // Add to GUI
        file.add(undo);
        file.addSeparator();
        file.add(exit);
    }

    /**
     * This method creates the contents for the Options menu.
     */
    private void createOptionsMenu() {
        final JMenu options = new JMenu("Options");
        myMenuBar.add(options);
        options.setMnemonic(KeyEvent.VK_O);

        // Create and add contents of Options.
        final JCheckBoxMenuItem squaresAndCircles =
                        new JCheckBoxMenuItem("Square/Circle Only");
        squaresAndCircles.setMnemonic(KeyEvent.VK_S);
        
//        //adding menu listener for the square and circle only.
//        squaresAndCircles.addItemListener(new ItemListener() {
//
//            @Override
//            public void itemStateChanged(final ItemEvent theEvent) {
//                if (theEvent.getStateChange() == 1) {
//                    myArea.setCheckBox(true);
//                } else {
//                    myArea.setCheckBox(false);
//                }
//            }
//            });

        final JMenu subOptionThickness = new JMenu("Thickness");
        subOptionThickness.setMnemonic(KeyEvent.VK_T);

        // create JSlider for sub-menu thickness.
        mySlider = new JSlider(SwingConstants.HORIZONTAL, 0, MAX_THICKNESS, INITIAL_THICKNESS);

        mySlider.setMajorTickSpacing(MAJOR_TICK);
        mySlider.setMinorTickSpacing(MINOR_TICK);
        mySlider.setPaintLabels(true);
        mySlider.setPaintTicks(true);

        subOptionThickness.add(mySlider);
        
        myArea.setStrokeThick(INITIAL_THICKNESS);
        
        // add an anonymous inner class ChangeListener to notify changes in
        // stroke value.
        mySlider.addChangeListener(new ChangeListener() {

            @Override
            public void stateChanged(final ChangeEvent theChangeEvent) {
                myArea.setStrokeThick(mySlider.getValue());
            }
        });

        
        myArea.setColor(UW_PURPLE);
        // create Icon for "Color..."
        final CustomIcon colorIcon = new CustomIcon(myArea.getColor());

        final JMenuItem color = new JMenuItem("Color...", colorIcon);
        color.setMnemonic(KeyEvent.VK_C);

        
        // create action button for JColorChooser
        color.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(final ActionEvent theEvent) {
                final Color colorChooser = JColorChooser.showDialog(myFrame.getParent(),
                                                                    "Color", UW_PURPLE);

                // setting the icon color and the drawing area.
                colorIcon.setColorIcon(colorChooser);
                myArea.setColor(colorChooser);

            }
        });

        // Add to GUI
        options.add(squaresAndCircles);
        options.addSeparator();
        options.add(subOptionThickness);
        options.addSeparator();
        options.add(color);
    }

    /**
     * This method creates the contents for the Tools menu.
     */
    private void createToolsMenu() {
        final JMenu tools = new JMenu("Tools");
        myMenuBar.add(tools);
        tools.setMnemonic(KeyEvent.VK_T);

        // make the list of buttons.
        myToolActions = new ArrayList<ToolAction>();

        myToolActions.add(new ToolAction("Pencil", new ImageIcon("images/pencil_bw.gif"),
                                         KeyEvent.VK_P, new Pencil(), myArea));
        myToolActions.add(new ToolAction("Line", new ImageIcon("images/line_bw.gif"),
                                         KeyEvent.VK_L, new Line(), myArea));
        myToolActions.add(new ToolAction("Rectangle",
                                         new ImageIcon("images/" + "rectangle_bw.gif"),
                                         KeyEvent.VK_R, new Rectangle(), myArea));
        myToolActions.add(new ToolAction("Ellipse", new ImageIcon("images/ellipse_bw.gif"),
                                         KeyEvent.VK_E, new Ellipse(), myArea));

        // add the tools to a button group
        final ButtonGroup toolMenuGrp = new ButtonGroup();
        for (final ToolAction ta : myToolActions) {
            final JRadioButton rb = new JRadioButton(ta);

            rb.setIcon(null);
            toolMenuGrp.add(rb);
            tools.add(rb);
        }

        // set pencil as the first tool selected.
        myToolActions.get(0).actionPerformed(null);
    }

    /**
     * This method creates the contents for the Help menu.
     */
    private void createHelpMenu() {
        // create Help menu
        final JMenu help = new JMenu("Help");
        myMenuBar.add(help);
        help.setMnemonic(KeyEvent.VK_H);

        // create icon for the about JOptionPane.
        final ImageIcon icon = new ImageIcon("images/myGamingIcon.png");

        final JMenuItem about = new JMenuItem("About...");
        about.setMnemonic(KeyEvent.VK_A);
        help.add(about);

        // add ActionListener when about button is pressed to show dialogue.
        about.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(final ActionEvent theEvent) {
                if (theEvent.getSource() == about) {
                    JOptionPane.showMessageDialog(myFrame.getParent(), ABOUT_MESSAGE, "About",
                                                  JOptionPane.INFORMATION_MESSAGE, icon);
                }
            }
        });

    }

}
