package pieces;

import java.util.ArrayList;

import chess.Board;

/**
 * 
 * @author Hongjie Lin
 *
 */
public class Bishop extends Piece{
	public Bishop(String color, int x, int y){
		super(color, x, y);
		name = "B";
	}
	
	public boolean isValid(String oldPosition, String newPosition) {
		int oldX = Integer.parseInt(oldPosition.substring(1));
		int oldY = (oldPosition.charAt(0)-'a');
		int newX = Integer.parseInt(newPosition.substring(1));
		int newY = (newPosition.charAt(0)-'a');
		
        if((Math.abs(newX - oldX) == Math.abs(newY - oldY)) && (!spotTaken(newPosition)))
            return true;

        else return false;
    }
	
}
