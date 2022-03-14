package study_Nathan;

//시간초과

import java.io.*;
import java.util.*;

public class Main_BOJ_2447_별찍기 {

	static int N;
	static char [][] map;
	
	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		map = new char[N][N];
		
		//분할정복 N/3  
		//맵 (1,1)이면 넘어가고 아니면 star 또 불러
		//N=1이면 별찍고 나가기 
		
		star(0,0,N);

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(map[i][j]);
			}System.out.println();
		}
		
	}

	private static void star(int r, int c, int N) {

		if(N == 1) {
			map[r][c] = '*';
			return;
		}
		
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				
				if(i != 1 || j != 1) {
					star(i*(N/3)+r, j*(N/3)+c, N/3);
				}
				
			}
		}
		
	}

}
