import java.io.*;
import java.util.*;

public class Main_BOJ_1915_가장큰정사각형 {

	static int N, M;
	static int [][] map;
	static int answer;
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer token = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(token.nextToken());
		M = Integer.parseInt(token.nextToken());
		
		map = new int[N][M];
		
		for(int i = 0; i < N; i++) {
			String [] str = br.readLine().split("");
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(str[j]);
				if(map[i][j] == 1) answer = 1;
			}
		}
		
		for(int i = 1; i < N; i++) {
			for(int j = 1; j < M; j++) {
				
				if(map[i][j] == 1) {
					map[i][j] = Math.min(map[i-1][j-1], Math.min(map[i-1][j], map[i][j-1])) + 1;
					answer = Math.max(answer, map[i][j]);					
				}
				
			}
		}
		
		System.out.println(answer*answer);
	}

}
