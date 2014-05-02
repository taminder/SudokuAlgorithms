package model;

import javax.swing.event.ChangeListener;

import model.Grid;

public interface Model {
	
	/**
	 * attach
	 * @param listener listener to be attached
	 */
	public void addListener(ChangeListener listener);
	
	/**
	 * mutator
	 * @param row location of the int
	 * @param col location of the int
	 * @param k int to be stored
	 */
	public void set(int row, int col, int k);
	
	/**
	 * accessor
	 * @return copy of data represented as 9 X 9 board of int
	 */
	public int[][] getBoard();
	
	/**
	 * accessor to get a specific int
	 * @param row location of an int
	 * @param col location of an int
	 * @return int stored in that location
	 */
	public int get(int row, int col);
	
	/**
	 * mutator
	 * @throws Exception
	 */
	public void solve() throws Exception;
	
	/**
     * check if it is legal to store int in a specific location
     * @param row location on the board
     * @param col location on the board
     * @param k int to store
     * @return true if it is available spot, false otherwise
     */
	public boolean isAvailable(int row, int col, int k);
	
	/**
     * check if there is a duplicate int in a same row
     * @param row row on the board
     * @param k int to store
     * @return true if there is a duplicate, false otherwise
     */
    public boolean hasIntInRow(int row, int k);
    
    /**
     * check if there is a duplicate int in a same column
     * @param col column on the board
     * @param k int to store
     * @return true if there is a duplicate, false otherwise
     */
    public boolean hasIntInCol(int col, int k);
    
    /**
     * check if there is a duplicate int in a same grid
     * @param row row on the board
     * @param col column on the board
     * @param k int to store
     * @return true if there is a duplicate, false otherwise
     */
    public boolean hasIntInGrid(int row, int col, int k);
    
    /**
     * find which row on the board is on grid row
     * @param row row on the board
     * @return grid row corresponding to the row
     */
    public int getGridRow(int row);
    
    /**
     * find which column on the board is on grid column
     * @param col column on the board
     * @return grid column corresponding to the column
     */
    public int getGridCol(int col);
    
    /**
     * get a specific grid
     * @param gridRow grid row
     * @param gridCol grid column
     * @return a grid on a given row and column
     */
    public Grid getGrid(int gridRow, int gridCol);
}
