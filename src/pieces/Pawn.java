package pieces;
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

	public boolean isValid(String oldPosition, String newPosition) {
		int oldX = Integer.parseInt(oldPosition.substring(1));
		int oldY = (oldPosition.charAt(0)-'a');
		int newX = Integer.parseInt(newPosition.substring(1));
		int newY = (newPosition.charAt(0)-'a');

		int deltaX;
		int deltaY;
		boolean legal = false;

		if (this.color == "w"){
			deltaY = -(newY-oldY);
		}else{
			deltaY = newY - oldY;
		}

		deltaX = Math.abs(newX-oldX);

		if (deltaY == 1 && deltaX == 0 && !spotTaken(newPosition)){
			legal = true;
		} else if (deltaX == 1 && deltaY == 1 && !spotTaken(newPosition)){  //pawn capture
			legal  = true;
		} else if (this.firstMove == true && deltaY == 2 && deltaX == 0 && !spotTaken(newPosition)){
			legal = true;

		}

		/*	if (legal == true){
		this.firstMove = false;
	}
		 */	
		return legal;
	}
}

