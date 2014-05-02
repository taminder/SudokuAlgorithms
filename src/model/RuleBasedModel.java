package model;

import java.util.ArrayList;

public class RuleBasedModel extends AbstractModel{

	public RuleBasedModel(){
		super();
	}

	public void solve() throws Exception {
		solve(this);
	}
	
	public void solve(RuleBasedModel model) throws Exception{
		//keep copy in case we need to backtrack
		copy = model.getCopy(model);
		
		//fill square with single candidate
		while(fillNaked(model)){}
		
		Coordinate start = findSquare();
		int row = start.getRow();
		int col = start.getCol();
		
		for(int i = 1; i <= 9; i++){
			if(isAvailable(row, col, i)){
				set(row, col, i);
				Thread.sleep(SLEEP_TIME);
				solve(model);
				if(isValidAndComplete(model)){
					System.out.println("Found a solution");
					throw new Exception("Solved");
				}
				//restore previous state before backtracking
				restore();
			}
		}
		return;
	}
	
	public boolean fillNaked(RuleBasedModel model) throws InterruptedException{
		for(int row = 0; row < 9; row++)
			for(int col = 0; col < 9; col++){
				if(getCandidateCount(row, col) == 1){
					//fill
					for(int i = 1; i <= 9; i++)
						if(isAvailable(row, col, i)){
							set(row, col, i);
							Thread.sleep(SLEEP_TIME);
							return true;
						}
				}
			}
		return false;
	}
    
    public RuleBasedModel getCopy(RuleBasedModel original){
    	RuleBasedModel ret = new RuleBasedModel();
    	for(int row = 0; row < 9; row++)
    		for(int col = 0; col < 9; col++)
    			ret.set(row, col, original.get(row, col));
    	return ret;
    }
    
    public void restore(){
    	for(int row = 0; row < 9; row++)
    		for(int col = 0; col < 9; col++)
    			set(row, col, copy.get(row, col));
    }
    
    private RuleBasedModel copy;
}
