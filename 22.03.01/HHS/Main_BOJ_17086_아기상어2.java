package study_Nathan;

import java.io.*;
import java.util.*;

public class Main_BOJ_17086_아기상어2 {

	static int N, M;
	static int[][] map;
	static int[][] count;
	static int dr [] = {-1,-1,-1,0,0,1,1,1}; 
	static int dc [] = {-1,0,1,-1,1,-1,0,1};
	static int result = Integer.MIN_VALUE;
	static Queue<shark> que = new LinkedList<shark>();

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer token = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(token.nextToken());
		M = Integer.parseInt(token.nextToken());
		
		map = new int[N][M];
		count = new int[N][M];

		for (int i = 0; i < N; i++) {
			token = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(token.nextToken());
				if(map[i][j] == 1) {
					que.add(new shark(i,j));
				}
			}
		}//map입력 완료
		bfs();
		System.out.println(result);
	}

	private static void bfs() {
		
		while(!que.isEmpty()) {
			shark s = que.poll();
			int r = s.sr;
			int c = s.sc;
			
			for (int d = 0; d < 8; d++) {//8방체크
				int nr = r+dr[d];
				int nc = c+dc[d];
				
				if(!check(nr,nc)) continue; //map 벗어나면 나가기
				if(count[nr][nc] != 0) continue;//방문 했던 곳이면 나가기
				if(map[nr][nc] == 1) continue;//다음 칸이 상어라면 카운트 안함
				
				count[nr][nc] = count[r][c]+1;
				result = Math.max(result, count[nr][nc]);
				que.add(new shark(nr,nc));
			}
			
		}
		
		
	}

	private static boolean check(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < M;
	}

}

class shark{
	int sr;
	int sc;
	public shark(int sr, int sc) {
		super();
		this.sr = sr;
		this.sc = sc;
	}
}