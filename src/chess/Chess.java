package chess;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 
 * @author Hongjie Lin
 *
 */
public class Chess {
	public static void main(String[] args){
		Board board = new Board();
		board.display();
		String input = wMove();
		System.out.println();
	}
	
	public static boolean isValid(String input){
		
	}
	
	public static String wMove(){
		System.out.println();
		System.out.print("White's move:");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			 return br.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public static String bMove(){
		System.out.println();
		System.out.print("Black's move:");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			return br.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
