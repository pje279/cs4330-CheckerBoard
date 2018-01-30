/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package checkerboard;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/**
 *
 * @author Peter
 */
public class CheckerBoard //extends Application
{
    /****************MEMBERS***************/
    private int numRows;
    private int numCols;
    private double boardWidth;
    private double boardHeight;
    private Color darkColor;
    private Color lightColor;
    private AnchorPane boardAnchorPane;
    
    /****************CONSTRUCTORS***************/
    /**
     * Base constructor for the Checkerboard class
     * @param numRows
     * @param numCols
     * @param boardWidth
     * @param boardHeight 
     */
    public CheckerBoard(int numRows, int numCols, double boardWidth, double boardHeight)
    {
        this.numRows = numRows;
        this.numCols = numCols;
        this.boardWidth = boardWidth;
        this.boardHeight = boardHeight;
        this.darkColor = Color.BLACK;
        this.lightColor = Color.RED;
        
        this.boardAnchorPane = new AnchorPane();
    } //End public Checkerboard(int numRows, int numCols, double boardWidth, double boardHeight)
    /**
     * Auxiliary constructor for when the default color scheme is not used. Calls the base constructor, then sets the chosen color scheme.
     * @param numRows
     * @param numCols
     * @param boardWidth
     * @param boardHeight
     * @param lightColor
     * @param darkColor 
     */
    public CheckerBoard(int numRows, int numCols, double boardWidth, double boardHeight, Color lightColor, Color darkColor)
    {
        this(numRows, numCols, boardWidth, boardHeight);
        
        this.lightColor = lightColor;
        this.darkColor = darkColor;
    } //End public Checkerboard(int numRows, int numCols, double boardWidth, double boardHeight, Color lightColor, Color, darkColor)
    
    /****************METHODS***************/
    public AnchorPane build()
    {
        //Declare variables
        Rectangle rect = null;
        
        //Clear the previous board
        this.boardAnchorPane.getChildren().clear();
        
        //Fill the grid pane with the appropriate rectangles
        for (int j = 0; j < this.numRows; j++)
        {
            for (int i = 0; i < this.numCols; i++)
            {
                if (j % 2 == 0)
                { //Even row
                    if (i % 2 == 0)
                    { //Even column
                        rect = new Rectangle(j * this.getRectangleWidth(), i * this.getRectangleHeight(), this.getRectangleWidth(), this.getRectangleHeight());
                        rect.setFill(this.getLightColor());
                        this.boardAnchorPane.getChildren().add(rect);
                    } //End if (i % 2 == 0)
                    else
                    { //Odd column
                        rect = new Rectangle(j * this.getRectangleWidth(), i * this.getRectangleHeight(), this.getRectangleWidth(), this.getRectangleHeight());
                        rect.setFill(this.getDarkColor());
                        this.boardAnchorPane.getChildren().add(rect);
                    } //End else
                } //End if (j % 2 == 0)
                else 
                { //Odd row
                    if (i % 2 == 0)
                    { //Even column
                        rect = new Rectangle(j * this.getRectangleWidth(), i * this.getRectangleHeight(), this.getRectangleWidth(), this.getRectangleHeight());
                        rect.setFill(this.getDarkColor());
                        this.boardAnchorPane.getChildren().add(rect);
                    } //End if (i % 2 == 0)
                    else
                    { //Odd column
                        rect = new Rectangle(j * this.getRectangleWidth(), i * this.getRectangleHeight(), this.getRectangleWidth(), this.getRectangleHeight());
                        rect.setFill(this.getLightColor());
                        this.boardAnchorPane.getChildren().add(rect);
                    } //End else
                } //End else
            } //End for (int i = 0; i < this.numCols; i++)
        } //End for (int j = 0; j < this.numRows; j++)
        
        return this.boardAnchorPane;
    } //End public void build()
    
    /****************GETTERS & SETTERS***************/
    /**
     * Gets the current board. Returns null if no board has been created.
     */
    public AnchorPane getBoard()
    {
        if (this.boardAnchorPane == null)
        {
            return null;
        } //End if (this.boardAnchorPane == null)
        else
        {
            return this.boardAnchorPane;
        } //End else
    } //End public AnchorPane getBoard()
    /**
     * Gets the number of rows.
     * @return The number of rows.
     */
    public int getNumRows()
    {
        return this.numRows;
    } //End public int getNumRows()
    /**
     * Gets the number of columns.
     * @return The number of columns.
     */
    public int getNumCols()
    {
        return this.numCols;
    } //End public int getNumCols()
    /**
     * Gets the width of the board.
     * @return The width of the board.
     */
    public double getWidth()
    {
        return this.boardWidth;
    } //End public double getWidth()
    /**
     * Gets the height of the board.
     * @return The height of the board.
     */
    public double getHeight()
    {
        return this.boardHeight;
    } //Endpublic double getHeight()
    /**
     * Gets the dark color used in the board.
     * @return The dark color used in the board.
     */
    public Color getDarkColor()
    {
        return this.darkColor;
    } //End public Color getDarkColor()
    /**
     * Gets the light color used in the board.
     * @return The light color used in the board.
     */
    public Color getLightColor()
    {
        return this.lightColor;
    } //End public Color getLightColor()
    /**
     * Calculates and returns the width of each rectangle in the board.
     * @return The board width / the number of columns.
     */
    public double getRectangleWidth()
    {
        return this.boardWidth / this.numCols;
    } //End public double getRectangelWidth()
    /**
     * Calculates and returns the height of each rectangle in the board.
     * @return The board height /  the number of rows.
     */
    public double getRectangleHeight()
    {
        return this.boardHeight / this.numRows;
    } //End public double getRectangleHeigth()
} //End public class Checkerboar extends Application
