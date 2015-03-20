package chess;
/**
 * 
 * @author Hongjie Lin
 *
 */
public class Board {
	private static final int ROWS = 9;
	private static final int COLS = 9;
	private String[] board;
	
	/**
	 * init the 2D array without any pieces
	 */
	public Board(){
		board = new String[ROWS*COLS];
		int flag = 0;
		for(int i = 0; i < ROWS*COLS; i++){
			if(i == ROWS*COLS - 1){
				board[i] = "  ";
			}else if(i > 71){
				board[i] = " " + (char)(i + 25);
			}else if( (i+1) % 9 == 0){
				board[i] = Integer.toString(9-(i+1)/9);
				if(flag == 0)
					flag = 1;
				else
					flag = 0;
			}else if(flag == 0){
				board[i] = "  ";
				flag = 1;
			}else if(flag == 1){
				board[i] = "##";
				flag = 0;
			}
		}
	}
	
	public void display(){
		for(int i = 0; i < board.length; i++){
			System.out.print(board[i]+" ");
			if((i+1) % 9 == 0)
				System.out.println();
		}
	}
}

