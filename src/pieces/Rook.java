package pieces;

import java.util.ArrayList;

import chess.Board;

/**
 * 
 * @author Edward Mamedov
 *
 */

public class Rook extends Piece{
	public Rook(String color, int x, int y){
		super(color, x, y);
		name = "R";
	}
	

	public void getMoves(){
		possibleMoves = new ArrayList<String>();
		
		int tempX = x+1;
		int tempY = y;
		while(tempX < 9){
			char yLetter = (char)(tempY + 97);
			String newPosition = "" + yLetter + tempX;
			Piece temp = Board.pieces.get(newPosition);
			if(temp == null){
				possibleMoves.add(newPosition);
				tempX++;
			}else if(!temp.color.equals(this.color)){
				possibleMoves.add(newPosition);
				break;
			}else
				break;
		}
		
		tempX = x;
		tempY = y-1;
		while(tempY >= 0){
			char yLetter = (char)(tempY + 97);
			String newPosition = "" + yLetter + tempX;
			Piece temp = Board.pieces.get(newPosition);
			if(temp == null){
				possibleMoves.add(newPosition);
				tempY--;
			}else if(!temp.color.equals(this.color)){
				possibleMoves.add(newPosition);
				break;
			}else
				break;
		}
		
		tempX = x-1;
		tempY = y;
		while(tempX > 0){
			char yLetter = (char)(tempY + 97);
			String newPosition = "" + yLetter + tempX;
			Piece temp = Board.pieces.get(newPosition);
			if(temp == null){
				possibleMoves.add(newPosition);
				tempX--;
			}else if(!temp.color.equals(this.color)){
				possibleMoves.add(newPosition);
				break;
			}else
				break;
		}
		
		tempX = x;
		tempY = y+1;
		while(tempY < 8){
			char yLetter = (char)(tempY + 97);
			String newPosition = "" + yLetter + tempX;
			Piece temp = Board.pieces.get(newPosition);
			if(temp == null){
				possibleMoves.add(newPosition);
				tempY++;
			}else if(!temp.color.equals(this.color)){
				possibleMoves.add(newPosition);
				break;
			}else
				break;
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
			if (deltaX == 0 && deltaY != 0){
				return true;
			} else if (deltaX != 0 && deltaY == 0) {
				return true;
			}
		}

		return false;
	}
}
