package pieces;

import chess.Board;

/**
 * 
 * @author Hongjie Lin
 *
 */
public class Piece {
	public String color;
	public String name; //name used to print on terminal, e.g (bK, wN)
	public int x; //row in matrix
	public int y; //column in matrix
	boolean firstMove = true; //set to false within every piece object
	
	public Piece(String color, int x, int y){
		this.color = color;
		this.x = x;
		this.y = y;
	}
	
	public void setXY(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	public boolean spotTaken(String newPosition){
		if (Board.pieces.get(newPosition) == null){
			//valid to move
			return false;
		}
		else if (Board.pieces.get(newPosition).color.equals(color)){
			//same color can't move
			return true;
		}
		else{
			//different color, eat it
			return false;
		}
	}
	
	public String toString(){
		return color + name;
	}
}
