import java.io.*;
import java.util.*;

public class Main_BOJ_15661_링크와스타트 {

	static int N;
	static int [][] map;
	static int result = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		
		StringTokenizer token = null;
		for(int i = 0; i < N; i++) {
			token = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++)
				map[i][j] = Integer.parseInt(token.nextToken());
		}
		
		make(0,new boolean[N]);
		System.out.println(result);
	}
	
	private static void make(int cnt, boolean [] visited) {
		
		if(cnt == N) {
			result = Math.min(result, cal(visited));
			return;
		}
		
		visited[cnt] = true;
		make(cnt+1, visited);
		visited[cnt] = false;
		make(cnt+1, visited);
		
	}

	private static int cal(boolean [] v) {
		int link = 0;
		int start = 0;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(v[i] && v[j])
					link += map[i][j];
				else if(!v[i] && !v[j])
					start += map[i][j];
			}
		}
		return Math.abs(start-link);
	}
}
