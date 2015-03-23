package pieces;

import java.util.ArrayList;

import chess.Board;

/**
 * 
 * @author Edward Mamedov
 *
 */
public class Bishop extends Piece{
	public Bishop(String color, int x, int y){
		super(color, x, y);
		name = "B";
	}
	
	public void getMoves(){
		possibleMoves = new ArrayList<String>();
		
		int tempX = x+1;
		int tempY = y+1;
		while(tempX < 8 && tempY < 9){
			char yLetter = (char)(tempY + 97);
			String newPosition = "" + yLetter + tempX;
			Piece temp = Board.pieces.get(newPosition);
			if(temp == null){
				possibleMoves.add(newPosition);
				tempX++;
				tempY++;
			}else if(!temp.color.equals(this.color)){
				possibleMoves.add(newPosition);
				break;
			}else
				break;
		}
		
		tempX = x+1;
		tempY = y-1;
		while(tempX < 9 && tempY > 0){
			char yLetter = (char)(tempY + 97);
			String newPosition = "" + yLetter + tempX;
			Piece temp = Board.pieces.get(newPosition);
			if(temp == null){
				possibleMoves.add(newPosition);
				tempX++;
				tempY--;
			}else if(!temp.color.equals(this.color)){
				possibleMoves.add(newPosition);
				break;
			}else
				break;
		}
		
		tempX = x-1;
		tempY = y-1;
		while(tempX > 1 && tempY > 0){
			char yLetter = (char)(tempY + 97);
			String newPosition = "" + yLetter + tempX;
			Piece temp = Board.pieces.get(newPosition);
			if(temp == null){
				possibleMoves.add(newPosition);
				tempX--;
				tempY--;
			}else if(!temp.color.equals(this.color)){
				possibleMoves.add(newPosition);
				break;
			}else
				break;
		}
		
		tempX = x-1;
		tempY = y+1;
		while(tempX > 1 && tempY < 8){
			char yLetter = (char)(tempY + 97);
			String newPosition = "" + yLetter + tempX;
			Piece temp = Board.pieces.get(newPosition);
			if(temp == null){
				possibleMoves.add(newPosition);
				tempX--;
				tempY++;
			}else if(!temp.color.equals(this.color)){
				possibleMoves.add(newPosition);
				break;
			}else
				break;
		}
		System.out.println(possibleMoves);
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
