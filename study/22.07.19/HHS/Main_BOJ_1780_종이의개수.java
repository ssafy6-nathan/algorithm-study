import java.io.*;
import java.util.*;

public class Main_BOJ_1780_종이의개수 {

	static int N;
	static int [][] map;
	static int minusOne, plusOne, zero;
	
	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = null;
		
		N = Integer.parseInt(br.readLine());
		
		map = new int[N][N];
		
		for(int i = 0; i < N; i++) {
			token = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(token.nextToken());
			}
		}
		num(0,0,N);
		System.out.println(minusOne);
		System.out.println(zero);
		System.out.println(plusOne);
		
	}

	private static void num(int r, int c, int width) {

		//같은 숫자끼리 있거나 크기 1이면 개수 올리기
		if(width == 1 || sameNum(r,c,width)) {
			
			if(map[r][c] == -1)
				minusOne++;
			else if(map[r][c] == 0) 			
				zero++;
			else 
				plusOne++;
			
			return;
		}
		
		int w = width / 3;
		
		num(r,c,w);
		num(r+w,c,w);
		num(r+w*2,c,w);
		num(r,c+w,w);
		num(r,c+w*2,w);
		num(r+w,c+w,w);
		num(r+w*2,c+w,w);
		num(r+w,c+w*2,w);
		num(r+w*2,c+w*2,w);
		
	}

	private static boolean sameNum(int r, int c, int width) {
		//같은 숫자인지 판별하기
		
		int temp = map[r][c];
		for (int i = r; i < r+width; i++) {
			for (int j = c; j < c+width; j++) {
				if(temp != map[i][j])
					return false;
			}
		}
		return true;
	}
	
	

}
