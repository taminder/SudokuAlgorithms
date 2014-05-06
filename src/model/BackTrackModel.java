package model;

public class BackTrackModel extends AbstractModel
{
    public BackTrackModel(){
        super();
    }
    
    public void solve(int row, int col) throws Exception
    {
        //if solution found, terminate the program by throwing exception
        if(row > 8){
        	long endTime = System.currentTimeMillis();
			//runtime = end time - start time - sleep time
        	long runtime = endTime - startTime - (sleepCount * SLEEP_TIME);
        	System.out.println("Runtime for BackTracking: " + runtime + "ms");
        	System.out.println("# setting value to square for BackTracking: " + getSetCount());
        	throw new Exception("Solved");
        }
        
        int nextRow, nextCol;
        if(col < 8)
        {
            nextRow = row;
            nextCol = col + 1;
        }
        else
        {
            nextRow = row + 1;
            nextCol = 0;
        }
        
        if(get(row, col) != 0)
            solve(nextRow, nextCol);
        else
        {
            for(int k = 1; k <= 9; k++)
            {
                if(isAvailable(row, col, k))
                {
                    set(row, col, k);
                    Thread.sleep(SLEEP_TIME);
                    sleepCount++;
                    solve(nextRow, nextCol);
                }
            }
            set(row, col, 0);
        }
    }
    
    public void solve() throws Exception{
    	/*//find starting square
    	Coordinate start = findSquare();
    	int row = start.getRow();
    	int col = start.getCol();
    	
    	for(int i = 1; i <= 9; i++){
    		if(isAvailable(row, col, i)){
    			set(row, col, i);
    			Thread.sleep(500);
    			model = solve(model);
    			if(isValidAndComplete(model)) return model;
    		}
    	}
    	return null;*/
    	startTime = System.currentTimeMillis();
    	solve(0, 0);
    }
}