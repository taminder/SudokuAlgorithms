package model;

class Coordinate {
	public Coordinate(int row, int col){
		this.row = row;
		this.col = col;
	}
	
	public int getRow(){return row;}
	public int getCol(){return col;}
	
	private int row;
	private int col;
}
