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
	static int drawFlag;
	public static void main(String[] args){
		Board board = new Board();
		board.display();
		String input = "";
		int flag = 0;
		while(true){
			if(flag == 0){
				input = wMove();
				System.out.println();
				if(!isValid(input)){
					System.out.println("Illegal move, try again");
					System.out.println();
					continue;
				}
				flag = 1;
			}
			if(flag == 1){
				input = bMove();
				System.out.println();
				if(!isValid(input)){
					System.out.println("Illegal move, try again");
					System.out.println();
					continue;
				}
				flag = 0;
			}
		}
	}
	
	public static boolean isValid(String input){
		if(input == null || input.equals(""))
			return false;
		else if(input.equals("resign"))
			return true;
		else if(input.equals("draw")){
			if(drawFlag == 1)
				return true;
			else
				return false;
		}
		
		String[] tokens = input.split(" ");
		if(tokens.length == 2 || tokens.length == 3){
			if(tokens[0].length() != 2 || tokens[1].length() != 2)
				return false;
			char oldY = tokens[0].charAt(0);
			int oldX = Integer.parseInt(tokens[0].substring(1));
			char newY = tokens[1].charAt(0);
			int newX = Integer.parseInt(tokens[1].substring(1));
			if(oldY - 'a' < 0 || oldY - 'h' > 0 || newY - 'a' < 0 || newY - 'h' > 0)
				return false;
			if(oldX - 1 < 0 || oldX - 8 > 0 || newX - 1 < 0 || newX - 8 > 0)
				return false;
			if(oldY == newY && oldX == newX)
				return false;
			
			if(tokens.length == 3){
				switch(tokens[2]){
				case "N": case "R": case "B": case "Q":
					return true;
				case "draw?":
					drawFlag = 1;
					return true;
				default:
					return false;
				}
			}
			return true;
		}
		
		return false;
	}
	
	public static String wMove(){
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
