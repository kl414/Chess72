package pieces;

import java.util.ArrayList;

import chess.Board;

/**
 * 
 * @author Edward Mamedov
 *
 */
public class Pawn extends Piece{
	public Pawn(String color, int x, int y){
		super(color, x, y);
		name = "p";
	}
	
	public void getMoves(){
		char yLetter = (char)(y + 97);
		String oldPosition = "" + yLetter + x;
		
		possibleMoves = new ArrayList<String>();
		for(String newPosition: allPosition){
			if(isValid(oldPosition, newPosition)){
				possibleMoves.add(newPosition);
			}
		}
	}
	
	public boolean isValid(String oldPosition, String newPosition) {
		int oldX = Integer.parseInt(oldPosition.substring(1));
		int oldY = (oldPosition.charAt(0)-'a');
		int newX = Integer.parseInt(newPosition.substring(1));
		int newY = (newPosition.charAt(0)-'a');

		int deltaX;
		int deltaY;
		boolean legal = false;

		if (this.color.equals("w")){
			deltaY = -(newY-oldY);
		}else{
			deltaY = newY - oldY;
		}

		deltaX = Math.abs(newX-oldX);

		if (deltaY == 0 && deltaX == 1 && !spotTaken(newPosition)){
			legal = true;
		} else if (deltaX == 1 && deltaY == 1 && Board.pieces.get(newPosition)!=null){  //pawn capture IMPLEMENT CASE WHERE PAWN IS ONLY OPPOSITE COLOR
			if (Board.pieces.get(newPosition).color!=color){
				legal  = true;
			}
		} else if (this.firstMove == true && deltaY == 0 && deltaX == 2 && !spotTaken(newPosition)){
			legal = true;

		}

		/*	if (legal == true){
		this.firstMove = false;
	}
		 */	
		return legal;
	}
}

