import java.io.*;
import java.util.*;

public class Main_BOJ_1520_내리막길 {

	static int N, M;
	static int [][] map;
	static int [][] dp;
	static int answer;
	static int [] dr = {-1,0,1,0};
	static int [] dc = {0,1,0,-1};
	
	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer token = null;
		token = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(token.nextToken());
		M = Integer.parseInt(token.nextToken());
		
		map = new int [N][M];
		dp = new int [N][M];
		
		for(int i = 0; i < N; i++) {
			token = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(token.nextToken());
			}
		}
		
		for(int i = 0; i < N; i++)
			Arrays.fill(dp[i], -1);

		answer = dfs(0,0);
		
		bw.write(String.valueOf(answer));
		bw.close();
	}

	private static int dfs(int r, int c) {

		if(r == N-1 && c == M-1) {
			return 1;
		}
		
		if(dp[r][c] > -1) return dp[r][c];
		
		dp[r][c] = 0;
		
		for(int d = 0; d < 4; d++) {
			int nr = r+dr[d];
			int nc = c+dc[d];
			
			if(!check(nr, nc)) continue;
			if(map[r][c] > map[nr][nc])
				dp[r][c] += dfs(nr, nc);
			
		}
		return dp[r][c];
	}

	private static boolean check(int r, int c) {
		return r >= 0 && c >= 0 && r < N && c < M;
	}

}
