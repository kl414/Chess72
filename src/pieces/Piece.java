package pieces;

import java.util.ArrayList;

import chess.Board;

/**
 * 
 * @author Hongjie Lin
 * @author Edward Mamedov
 */
public class Piece {
	public String color;
	public String name; //name used to print on terminal, e.g (bK, wN)
	public int x; //row in matrix
	public int y; //column in matrix
	boolean firstMove = true; //set to false within every piece object
	public ArrayList<String> possibleMoves;
	
	public Piece(String color, int x, int y){
		this.color = color;
		this.x = x;
		this.y = y;

	}
	
	public void setXY(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	public boolean isValid(String oldPosition, String newPosition){
		return true;
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
	
	public void getMoves(){
		possibleMoves = new ArrayList<String>();
	}
	public boolean hasPath(String oldPosition, String newPosition){
		return true;
	}
	
	public String toString(){
		return color + name;
	}
}
