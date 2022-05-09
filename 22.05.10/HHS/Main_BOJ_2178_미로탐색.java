import java.io.*;
import java.util.*;

public class Main_BOJ_2178_미로탐색 {

	static int N, M, result;
	static char [][] map;
	static int [][] copy;
	static int [] dr = {-1,0,1,0}; //0,3,6,9 시계방향
	static int [] dc = {0,1,0,-1};
	
	
	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer token = new StringTokenizer(br.readLine());
		N = Integer.parseInt(token.nextToken());
		M = Integer.parseInt(token.nextToken());
		
		map = new char[N][M];
		copy = new int[N][M];
		
		for(int i = 0; i < N; i++) {
			String line = br.readLine();
			for(int j = 0; j < M; j++) {
				map[i][j] = line.charAt(j);
			}
		}

		dfs(0,0,1);
		System.out.println(result);
		
	}

	private static void dfs(int r, int c, int count) {
		
		if(r == N-1 && c == M-1)
			result = count;
		
		for (int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			
			if(!check(nr, nc)) continue; //범위 벗어나면 나가
			
			if(map[nr][nc] =='0') continue; //이동하려는 곳이 0이면 나가
			
			if(copy[nr][nc] == 0||(copy[nr][nc] != 0 && copy[nr][nc] > count)) {
				copy[nr][nc] = count;
				dfs(nr,nc,count+1);
			}
							
		}
		
	}

	private static boolean check(int r, int c) {
		return r >= 0 && c >= 0 && r < N && c < M;
	}

}
