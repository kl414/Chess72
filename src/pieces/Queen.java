package pieces;
/**
 * 
 * @author Edward Mamedov
 *
 */
public class Queen extends Piece{
	public Queen(String color, int x, int y){
		super(color, x, y);
		name = "Q";
	}

	public boolean isValid(String oldPosition, String newPosition){
		int oldX = Integer.parseInt(oldPosition.substring(1));
		int oldY = (oldPosition.charAt(0)-'a');
		int newX = Integer.parseInt(newPosition.substring(1));
		int newY = (newPosition.charAt(0)-'a');

		int deltaX = Math.abs(newX-oldX);
		int deltaY = Math.abs(newY-oldY);

		if (!spotTaken(newPosition)){
			if (deltaX == deltaY){
				return true;
			} else if (deltaX == 0 && deltaY != 0) {
				return true;
			}else if (deltaX != 0 && deltaY == 0){
				return true;
			}
		}

		return false;
	}
}
