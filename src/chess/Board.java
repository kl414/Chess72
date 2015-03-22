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
	private String[] pieces;
	
	public Board(){
		plainBoard();
	}
	/**
	 * init the 2D array without any pieces
	 * access the element by (row * COLS + col)
	 */
	public void plainBoard(){
		board = new String[ROWS*COLS];
		int flag = 1;
		for(int i = 0; i < board.length; i++){
			if(i == 8){
				board[i] = "  ";
			}else if(i < 9){
				board[i] = " " + (char) (i+97);
			}else if((i+1) % 9 == 0){
				board[i] = Integer.toString(i/9);
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
		for(int i = ROWS; i > 0; i--){
			for(int j = 0; j < COLS; j++){
				System.out.print(board[(i-1)*COLS+j] + " ");
				if(j == COLS-1){
					System.out.println();
				}
			}
		}
	}
	/*
	public Board(){
		board = new String[(ROWS+1)*(COLS+1)];
		pieces = new String[ROWS*COLS];
		int flag = 0;
		for(int i = 0; i < (ROWS+1)*(COLS+1); i++){
			if(i == (ROWS+1)*(COLS+1) - 1){
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
	*/
}

