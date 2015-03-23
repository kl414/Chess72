package pieces;

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
