import java.io.*;
import java.util.*;

public class Main_BOJ_1063_킹 {

//	static int [][] map; 
	//map없이 해보기
	static String king;
	static String stone;
	
	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer token = new StringTokenizer(br.readLine());
		
		king = token.nextToken();
		char kingAlpha = king.charAt(0);
		char kingNum = king.charAt(1);

		stone = token.nextToken();
		char stoneAlpha = stone.charAt(0);
		char stoneNum = stone.charAt(1);
		
		int T = Integer.parseInt(token.nextToken());		

		for(int t = 1; t <= T; t++) {
			//움직이는대로 움직이고
			//만약 판을 벗어나면 현재 움직이는거 넘기고 다음 움직이기하기
			String str = br.readLine();
			char tempKA = kingAlpha;
			char tempKN = kingNum;
			char tempSA = stoneAlpha;
			char tempSN = stoneNum;
			
			if(str.equals("R")) {
				tempKA += 1; 
				if(tempKN == stoneNum && tempKA == stoneAlpha)
					tempSA += 1;
				
			}else if(str.equals("L")) {
				tempKA -= 1; 
				if(tempKN == stoneNum && tempKA == stoneAlpha)
					tempSA -= 1;
			}else if(str.equals("T")) {
				tempKN += 1;
				if(tempKN == stoneNum && tempKA == stoneAlpha)
					tempSN += 1;
			}else if(str.equals("B")) {
				tempKN -= 1;
				if(tempKN == stoneNum && tempKA == stoneAlpha)
					tempSN -= 1;
			}else if(str.equals("RT")) {
				tempKN += 1;
				tempKA += 1;
				if(tempKN == stoneNum && tempKA == stoneAlpha) {
					tempSN += 1;
					tempSA += 1;
				}
			}else if(str.equals("LT")) {
				tempKN += 1;
				tempKA -= 1;
				if(tempKN == stoneNum && tempKA == stoneAlpha) {
					tempSN += 1;
					tempSA -= 1;
				}
			}else if(str.equals("RB")) {
				tempKN -= 1;
				tempKA += 1;
				if(tempKN == stoneNum && tempKA == stoneAlpha) {
					tempSN -= 1;
					tempSA += 1;
				}
			}else if(str.equals("LB")){
				tempKN -= 1;
				tempKA -= 1;
				if(tempKN == stoneNum && tempKA == stoneAlpha) {
					tempSN -= 1;
					tempSA -= 1;
				}				
			}
			
			if(check(tempSA, tempSN) && check(tempKA, tempKN)) {
				kingAlpha = tempKA;
				kingNum = tempKN;
				stoneAlpha = tempSA;
				stoneNum = tempSN;
			}
		}
		System.out.print(kingAlpha);
		System.out.println(kingNum);		
		System.out.print(stoneAlpha);
		System.out.println(stoneNum);		
		
	}

	private static boolean check(char alpha, char num) {
		return alpha <= 'H' && alpha >= 'A' && num >= '1' && num <= '8';
	}

}
