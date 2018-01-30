/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package checkerboard;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuBar;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 *
 * @author Peter
 */
public class FXMLDocumentController implements Initializable, Startable
{
    /****************MEMBERS***************/
    @FXML
    private VBox vBoxParent;
    @FXML
    private MenuBar menuBar;
    @FXML
    private AnchorPane anchorPane;
    
    private CheckerBoard board;
    private Boolean defaultColor;
    
    /****************EVENTS***************/
    /**
     * Determines which board sizing was selected, and redraws the board accordingly.
     * @param event 
     */
    @FXML
    private void handleMenuAction(ActionEvent event)
    {
        //Declare variables
        int rows = 0;
        int cols = 0;
        
        //Determine which menu item was selected
        if (event.getSource().equals(this.menuBar.getMenus().get(0).getItems().get(0)))
        { //16 x 16
            rows = cols = 16;
        } //End if (event.getSource().equals(this.menuBar.getMenus().get(0).getItems().get(0)))
        else if (event.getSource().equals(this.menuBar.getMenus().get(0).getItems().get(1)))
        { //10 x 10
            rows = cols = 10;
        } //End else if (event.getSource().equals(this.menuBar.getMenus().get(0).getItems().get(1)))
        else if (event.getSource().equals(this.menuBar.getMenus().get(0).getItems().get(2)))
        { //8 x 8
            rows = cols = 8;
        } //End else if (event.getSource().equals(this.menuBar.getMenus().get(0).getItems().get(2)))
        else if (event.getSource().equals(this.menuBar.getMenus().get(0).getItems().get(3)))
        { //3 x 3
            rows = cols = 3;
        } //End else if (event.getSource().equals(this.menuBar.getMenus().get(0).getItems().get(3)))
        else
        {
            //How did this happen?
            System.out.println("How did this happen?");
        } //End else
        
        if (this.defaultColor)
        {
            this.redraw(rows, cols, Color.RED, Color.BLACK);
        } //End if (this.defaultColor)
        else
        {
            this.redraw(rows, cols, Color.SKYBLUE, Color.DARKBLUE);
        } //End else
    } //End private void handleMenuAction(ActionEvent event)
    /**
     * Determines which color was selected, and redraws the board accordingly.
     * @param event 
     */
    @FXML
    private void handleColorAction(ActionEvent event)
    {
        //Determine which color was selected
        if (event.getSource().equals(this.menuBar.getMenus().get(1).getItems().get(0)))
        { //Default color
            if (!this.defaultColor)
            {
                this.defaultColor = true;
                this.redraw(this.board.getNumCols(), this.board.getNumRows(), Color.RED, Color.BLACK);
            } //End if (!this.defaultColor)
        } //End if (event.getSource().equals(this.menuBar.getMenus().get(1).getItems().get(0)))
        else if (event.getSource().equals(this.menuBar.getMenus().get(1).getItems().get(1)))
        { //Blue color
            if (this.defaultColor)
            {
                this.defaultColor = false;
                this.redraw(this.board.getNumCols(), this.board.getNumRows(), Color.SKYBLUE, Color.DARKBLUE);
            } //End if (!this.defaultColor)
            
            this.defaultColor = false;
        } //End else if (event.getSource().equals(this.menuBar.getMenus().get(1).getItems().get(1)))
        else
        {
            //How did this happen?
            System.out.println("How did this happen?");
        } //End else
    } //End private void handleColorAction(ActionEvent event)
    
    /****************METHODS***************/
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        // TODO
    } //End public void initialize(URL url, ResourceBundle rb)    
    /**
     * 
     */
    public void start()
    {
        this.defaultColor = true;
     
        //Draw the default state of the board
        this.redraw(8, 8, Color.RED, Color.BLACK);
        
        //Hanlde the resize events
        ChangeListener<Number> lambdaChangeListener = (observable, oldValue, newValue) -> {
            this.refresh();
        };

        this.vBoxParent.widthProperty().addListener(lambdaChangeListener);
        this.vBoxParent.heightProperty().addListener(lambdaChangeListener);
        
    } //End public void start()
    /**
     * Refreshes the board based on the currently chosen parameters of the board.
     */
    public void refresh()
    {
        if (this.defaultColor)
        {
            this.redraw(this.board.getNumRows(), this.board.getNumCols(), Color.RED, Color.BLACK);
        } //End if (this.defaultColor)
        else
        {
            this.redraw(this.board.getNumRows(), this.board.getNumCols(), Color.SKYBLUE, Color.DARKBLUE);
        } //End else
    } //End public void refresh()
    /**
     * Redraws the board based on the parameters passed in. Gets the current width and height of the parent, subtracting the menuBar height 
     * from the total height to be used when calculating the rectangle dimensions.
     * @param numRows
     * @param numCols
     * @param lightColor
     * @param darkColor 
     */
    public void redraw(int numRows, int numCols, Color lightColor, Color darkColor)
    {
        this.board = new CheckerBoard(numRows, numCols, this.vBoxParent.getWidth(), this.vBoxParent.getHeight() - this.menuBar.getHeight(), lightColor, darkColor);
        
        this.vBoxParent.getChildren().remove(this.anchorPane);
        this.anchorPane = this.board.build();
        this.vBoxParent.getChildren().add(this.anchorPane);
    } //End public void refresh()
} //End public class FXMLDocumentController implements Initializable
