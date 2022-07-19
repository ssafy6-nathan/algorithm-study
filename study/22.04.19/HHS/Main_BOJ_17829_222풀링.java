package study_Nathan;

import java.io.*;
import java.util.*;

public class Main_BOJ_17829_222풀링 {

	static int N;
	static int [][] map;
	
	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token;
		
		N = Integer.parseInt(br.readLine());
		
		map = new int[N][N];
		
		for(int i = 0; i < N; i++) {
			token = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(token.nextToken());
			}
		}//map 입력 완료
		
		System.out.println(pooling(0,0,N));
		
		
		
	}

	private static int pooling(int r, int c, int size) {

		//사이즈 2이면 배열 만들어서 넣어놓고 정렬해서 세번째꺼 뽑기
		if(size == 2) {
			int [] num = new int[4];
			int index = 0;
			for(int i = r; i < r+2; i++) {
				for(int j = c; j < c+2; j++) {
					num[index++] = map[i][j];
				}
			}
			Arrays.sort(num);
			return num[2];
		}
		//2보다 크면 사이즈 반으로 줄이고 각 배열마다 재귀 돌린거 값 넣고 정렬
		else {
			size = size/2;
			int [] num = new int[4];
			num[0] = pooling(r,c,size);
			num[1] = pooling(r,c+size,size);
			num[2] = pooling(r+size,c,size);
			num[3] = pooling(r+size,c+size,size);
			
			Arrays.sort(num);
			return num[2];
		}
		
	}

}
