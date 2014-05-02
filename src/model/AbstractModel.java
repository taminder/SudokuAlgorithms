package model;
import java.util.ArrayList;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;


public abstract class AbstractModel implements Model{
	protected static final int SLEEP_TIME = 10;
	
	public AbstractModel(){
		grid = new Grid[3][3];
        listeners = new ArrayList<ChangeListener>();
        for(int row = 0; row < 3; row++)
            for(int col = 0; col < 3; col++)
            {
                grid[row][col] = new Grid();
            }
        initialize();
	}
	
	public void initialize(){
		set(0,0,3);
        set(0,1,5);
        set(0,2,2);
        set(0,6,1);
        
        set(1,5,7);
        set(1,7,4);
        
        set(2,1,7);
        set(2,3,8);
        set(2,8,5);
        
        set(3,1,6);
        set(3,6,7);
        set(3,7,5);
        set(3,8,9);
        
        set(4,0,1);
        set(4,4,8);
        
        set(6,0,8);
        set(6,4,1);
        set(6,5,3);
        set(6,8,6);
        
        set(7,0,5);
        set(7,3,4);
        set(7,5,9);
        set(7,6,2);
        set(7,7,3);
        
        set(8,0,2);
        set(8,2,6);
        set(8,6,9);
	}
	
	public void addListener(ChangeListener listener)
    {
        listeners.add(listener);
    }
    
    public void set(int row, int col, int k)
    {
        getGrid(getGridRow(row), getGridCol(col)).set(row % 3, col % 3, k);
        //Notify event to listeners
        ChangeEvent event = new ChangeEvent(this);
        for(ChangeListener listener : listeners)
            listener.stateChanged(event);
    }
    
    public int[][] getBoard()
    {
        int[][] board = new int[9][9];
        int gridRow = 0;
        int gridCol = 0;
        for(int row = 0; row < 9; row++)
            for(int col = 0; col < 9; col++)
                board[row][col] = get(row, col);
        return board;
    }
    
    public int get(int row, int col)
    {
        //get int at row (row % 3) and col (col % 3) of a grid (getGrid())
        return getGrid(getGridRow(row), getGridCol(col)).get(row % 3, col % 3);
    }
    
    public boolean isAvailable(int row, int col, int k)
    {
        return !(hasIntInRow(row, k) || hasIntInCol(col, k) || hasIntInGrid(row, col, k));
    }
    
    public int getCandidateCount(int row, int col){
    	//if already filled, return 0
    	if(get(row, col) != 0) return 0;
    	int count = 0;
    	for(int i = 1; i <= 9; i++)
    		if(isAvailable(row, col, i)) count++;
    	return count;
    }
    
    public boolean isValidAndComplete(Model model){
    	for(int row = 0; row < 9; row++)
    		for(int col = 0; col < 9; col++){
    			//if some not filled yet
    			if(get(row, col) == 0) return false;
    			//if it violates rules
    			//if(!isAvailable(row, col, get(row, col))) return false;
    		}
    	return true;
    }
    
    public boolean hasIntInRow(int row, int k)
    {
        for(int col = 0; col < 9; col++)
            if(get(row, col) == k)
                return true;
        return false;
    }
    
    public boolean hasIntInCol(int col, int k)
    {
        for(int row = 0; row < 9; row++)
            if(get(row, col) == k)
                return true;
        return false;
    }
    
    public boolean hasIntInGrid(int row, int col, int k)
    {
        int gridRow = getGridRow(row);
        int gridCol = getGridCol(col);
        for(int rowInGrid = 0; rowInGrid < 3; rowInGrid++)
            for(int colInGrid = 0; colInGrid < 3; colInGrid++)
                if(k == getGrid(gridRow, gridCol).get(rowInGrid, colInGrid)) return true; 
        return false;
    }
    
    public Coordinate findSquare(){
    	int min = 9, retrow = 0, retcol = 0;
    	for(int row = 0; row < 9; row++){
    		for(int col = 0; col < 9; col++){
    			//if taken already
    			if(get(row, col) != 0) continue;
    			if(getCandidateCount(row, col) < min){
    				min = getCandidateCount(row, col);
    				retrow = row;
    				retcol = col;
    			}
    		}
    	}
    	return new Coordinate(retrow, retcol);
    }
    
    public int getGridRow(int row)
    {
        if(row >= 0 && row < 3) return 0;
        else if(row >= 3 && row < 6) return 1;
        else return 2;
    }
    
    public int getGridCol(int col)
    {
        if(col >= 0 && col < 3) return 0;
        else if(col >= 3 && col < 6) return 1;
        else return 2;
    }
    
    public Grid getGrid(int gridRow, int gridCol) { return grid[gridRow][gridCol]; }
	
	private Grid[][] grid; //data structure
    private ArrayList<ChangeListener> listeners; //listeners
}
