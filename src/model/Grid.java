package model;

/**
 * Each grid on a sudoku board
 * @author Naoki Nakatani
 *
 */
class Grid
{
    /**
     * construct a grid with 3 x 3 matrix with int
     */
    public Grid()
    {
        grid = new int[3][3];
    }
    
    /**
     * set int to a specific location. This method gets called by Model's set().
     * @param row row on the grid
     * @param col column on the grid
     * @param k int to be stored
     */
    public void set(int row, int col, int k) { grid[row][col] = k; }
    
    /**
     * get int from a specific location. This method gets called by Model's get().
     * @param row row on the grid
     * @param col column on the grid
     * @return int stored in that location
     */
    public int get(int row, int col) { return grid[row][col]; }
    
    private int[][] grid;
}