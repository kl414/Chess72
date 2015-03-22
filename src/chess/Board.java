package chess;

import java.util.ArrayList;
import java.util.HashMap;

import pieces.*;


/**
 * 
 * @author Hongjie Lin
 *
 */
public class Board {
	private static final int ROWS = 9;
	private static final int COLS = 9;
	private String[] board;
	/*
	 * The hashmap is used to store the alive pieces
	 * access by the postion on board
	 */
	private HashMap<String, Piece> pieces;
	
	/*
	 * access the element by (row * COLS + col)
	 * treat a as 0, b as 1
	 * e.g (a1 == 1*9 + 0, b2 = 2*9 + 1)
	 */
	public Board(){
		plainBoard();
		pieces = new HashMap<String, Piece>();
		initPieces();
		fillPieces();
	}
	/**
	 * init the 2D array without any pieces
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
	
	public void initPieces(){
		pieces.put("a8", new Rook("b", 8, 0));
		pieces.put("h8", new Rook("b", 8, 7));
		pieces.put("b8", new Knight("b", 8, 1));
		pieces.put("g8", new Knight("b", 8, 6));
		pieces.put("c8", new Bishop("b", 8, 2));
		pieces.put("f8", new Bishop("b", 8, 5));
		pieces.put("d8", new Queen("b", 8, 3));
		pieces.put("e8", new King("b", 8, 4));
		for(int i = 0; i < 8; i++){
			pieces.put(""+(char)(i+97)+"7", new Pawn("b", 7, i));
		}
		
		for(int i = 0; i < 8; i++){
			pieces.put(""+(char)(i+97)+"2", new Pawn("w", 2, i));
		}
		pieces.put("a1", new Rook("w", 1, 0));
		pieces.put("h1", new Rook("w", 1, 7));
		pieces.put("b1", new Knight("w", 1, 1));
		pieces.put("g1", new Knight("w", 1, 6));
		pieces.put("c1", new Bishop("w", 1, 2));
		pieces.put("f1", new Bishop("w", 1, 5));
		pieces.put("d1", new Queen("w", 1, 3));
		pieces.put("e1", new King("w", 1, 4));
	}
	
	/**
	 * fill the pieces into the plain board
	 */
	public void fillPieces(){
		for(String key: pieces.keySet()){
			Piece piece = pieces.get(key);
			board[piece.x * COLS + piece.y] = piece.toString();
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

