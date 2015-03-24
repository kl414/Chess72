package chess;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import pieces.Piece;

/**
 * 
 * @author Hongjie Lin
 *
 */
public class Chess {
	static int drawFlag;
	static int resignFlag;
	public static int enpassantFlag;
	public static int eFlag;

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
				if(resignFlag == 0){
					String[] tokens = input.split(" ");
					Piece temp = Board.pieces.get(tokens[0]);
					if (temp != null){
						temp.getMoves();
					}
					if(temp == null || 
							(!temp.isValid(tokens[0], tokens[1]) && !temp.possibleMoves.contains(tokens[1]))
							|| !temp.color.equals("w")){
						System.out.println("Illegal move, try again");
						System.out.println();
						continue;
					}else{
						board.pieces.remove(tokens[0]);
						board.pieces.remove(tokens[1]);
						char newY = tokens[1].charAt(0);
						int newX = Integer.parseInt(tokens[1].substring(1));
						temp.setXY(newX, newY-'a');
						board.pieces.put(tokens[1], temp);
						Board.drawBoard();
						Piece p = board.pieces.get(tokens[1]);
						p.firstMove = false;
						p.getMoves();
						for(String key: board.pieces.keySet()){
							Piece piece = board.pieces.get(key);
							if(piece != null){
								if(piece.toString().equals("bK")){
									if (p.possibleMoves.contains(key)){
										System.out.println("Check");
										System.out.println();
									}
								}
							}
						}
					}
					if(enpassantFlag == 1){
						enpassantFlag = 0;
						eFlag = 0;
					}
					if(eFlag == 1)
						enpassantFlag = 1;
					if(temp.y > 0){
						Piece tempLeft = board.pieces.get(""+(char)(temp.y+1+97)+temp.x);
						if(tempLeft != null && tempLeft.toString().equals("bp")){
							tempLeft.possibleMoves.add(""+(char)(temp.y+97)+(temp.x-1));
						}
					}
					if(temp.y<8){
						Piece tempRight = board.pieces.get(""+(char)(temp.y-1+97)+temp.x);
						if(tempRight != null && tempRight.toString().equals("bp")){
							tempRight.possibleMoves.add(""+(char)(temp.y+97)+(temp.x-1));
						}
					}

					flag = 1;
				}
			}
			if (resignFlag == 1){
				return;
			}
			if (drawFlag == 1){
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

				if(resignFlag == 0){
					String[] tokens = input.split(" ");
					Piece temp = Board.pieces.get(tokens[0]);
					temp.getMoves();
					if(temp == null || 
							(!temp.isValid(tokens[0], tokens[1]) && !temp.possibleMoves.contains(tokens[1]))
							|| !temp.color.equals("b")){
						System.out.println("Illegal move, try again");
						System.out.println();
						continue;
					}else{
						board.pieces.remove(tokens[0]);
						board.pieces.remove(tokens[1]);
						char newY = tokens[1].charAt(0);
						int newX = Integer.parseInt(tokens[1].substring(1));
						temp.setXY(newX, newY-'a');
						board.pieces.put(tokens[1], temp);
						Board.drawBoard();
						Piece p = board.pieces.get(tokens[1]);
						p.firstMove = false;
						p.getMoves();
						for(String key: board.pieces.keySet()){
							Piece piece = board.pieces.get(key);
							if(piece != null){
								if(piece.toString().equals("wK")){
									if (p.possibleMoves.contains(key)){
										System.out.println("Check");
										System.out.println();
									}
								}
							}
						}
					}
					if(temp.y > 0){
						Piece tempLeft = board.pieces.get(""+(char)(temp.y+1+97)+temp.x);
						if(tempLeft != null && tempLeft.toString().equals("wp")){
							tempLeft.possibleMoves.add(""+(char)(temp.y+97)+(temp.x+1));
						}
					}
					if(temp.y<8){
						Piece tempRight = board.pieces.get(""+(char)(temp.y-1+97)+temp.x);
						if(tempRight != null && tempRight.toString().equals("wp")){
							tempRight.possibleMoves.add(""+(char)(temp.y+97)+(temp.x+1));
						}
					}
				}

				flag = 0;
			}
			if (resignFlag == 1){
				return;
			}
			if (drawFlag == 1){
				flag = 0;
			}
		}
	}

	public static boolean isValid(String input){
		if(input == null || input.equals(""))
			return false;
		else if(input.equals("resign")){
			resignFlag = 1;
			return true;
		}
		else if(input.equals("draw")){
			if(drawFlag == 1){
				System.exit(0);
				return true;
			}
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
