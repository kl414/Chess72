package pieces;
/**
 * 
 * @author Edward Mamedov
 *
 */
public class King extends Piece{
	public King(String color, int x, int y){
		super(color, x, y);
		name = "K";
	}

	public boolean isValid(String oldPosition, String newPosition){
		int oldX = Integer.parseInt(oldPosition.substring(1));
		int oldY = (oldPosition.charAt(0)-'a');
		int newX = Integer.parseInt(newPosition.substring(1));
		int newY = (newPosition.charAt(0)-'a');

		int deltaX = newX - oldX;
		int deltaY = newY - oldY;

		if (!spotTaken(newPosition)){
			if (deltaX == deltaY && deltaX == 1 && deltaY == 1){
				return true;
			}else if (deltaX == 0 && deltaY == 1){
				return true;
			} else if (deltaX == 1 && deltaY == 0) {
				return true;
			}
		}
		return false;
	}

}
