import java.io.*;
import java.util.*;

public class Main_BOJ_2468_안전영역 {

	static int N;
	static int [][] map;
	static int result;
	static int dr[] = {-1,0,1,0};
	static int dc[] = {0,1,0,-1};

	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = null;
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		int MapMax = Integer.MIN_VALUE;
		for(int i = 0; i < N; i++) {
			token = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(token.nextToken());
				if(map[i][j] > MapMax) MapMax = map[i][j];
			}
		}

		
		for (int i = 0; i < MapMax+1; i++) {
			result = Math.max(result, go(i));
		}
		
		System.out.println(result);
	}

	private static int go(int safeNum) {
		boolean [][] visited = new boolean[N][N];
		int count = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(map[i][j] > safeNum && !visited[i][j]) {
					count += dfs(i,j,safeNum, visited);
				}
			}
		}
	
		return count;
	}

	private static int dfs(int r, int c, int safe, boolean[][] visited) {
		visited[r][c] = true;
		
		for (int d = 0; d < 4; d++) {
			int nr = r+dr[d];
			int nc = c+dc[d];
			
			if(!check(nr,nc)) continue;
			if(visited[nr][nc]) continue;
			if(map[nr][nc] <= safe) continue;
			
			dfs(nr,nc,safe,visited);
			
		}
		return 1;
		
	}

	private static boolean check(int r, int c) {
		return r >= 0 && c >= 0 && r < N && c < N;
	}
}
