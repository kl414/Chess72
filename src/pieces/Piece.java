package pieces;
/**
 * 
 * @author Hongjie Lin
 *
 */
public class Piece {
	public String color;
	public String name; //name used to print on terminal, e.g (bK, wN)
	public int x; //row in matrix
	public int y; //column in matrix
	
	public Piece(String color, int x, int y){
		this.color = color;
		this.x = x;
		this.y = y;
	}
	
	public String toString(){
		if(color.equals("black"))
			return "b" + name;
		else
			return "w" + name;
	}
}
