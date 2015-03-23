package pieces;

import java.util.ArrayList;

import chess.Board;

/**
 * 
 * @author Edward Mamedov
 *
 */
public class Knight extends Piece{
	public Knight(String color, int x, int y){
		super(color, x, y);
		name = "N";
	}

	public void getMoves(){
		char yLetter = (char)(y + 97);
		String oldPosition = "" + yLetter + x;
		
		possibleMoves = new ArrayList<String>();
		for(String newPosition: Board.allPosition){
			if(isValid(oldPosition, newPosition)){
				possibleMoves.add(newPosition);
			}
		}
	}
	
	public boolean isValid(String oldPosition, String newPosition){
		int oldX = Integer.parseInt(oldPosition.substring(1));
		int oldY = (oldPosition.charAt(0)-'a');
		int newX = Integer.parseInt(newPosition.substring(1));
		int newY = (newPosition.charAt(0)-'a');

		int deltaX = Math.abs(newX-oldX);
		int deltaY = Math.abs(newY-oldY);

		if (!spotTaken(newPosition)){
			if (deltaX == 2 && deltaY == 1){
				return true;
			} else if (deltaX == 1 && deltaY == 2) {
				return true;
			}
		}

		return false;
	}
	
}
