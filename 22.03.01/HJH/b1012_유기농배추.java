import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b1012_유기농배추 {
	static int M, N, K, cnt;
	static int[][] map;
	static boolean[][] visit;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			map = new int[M][N];	// 0으로 초기화
			visit = new boolean[M][N];
			K = Integer.parseInt(st.nextToken());
			cnt = 0;
			for (int k = 0; k < K ; k++) {
				st = new StringTokenizer(br.readLine());
				map[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = 1;	// 양배추 위치 저장
			}
			for (int r = 0; r < M; r++) {
				for (int c = 0; c<N; c++) {
					if(!visit[r][c] && map[r][c] == 1) {
						dfs(r, c);
						cnt++;
					}
				}
			}
			System.out.println(cnt);
		}
	}
	
	public static void dfs(int r, int c) {
		visit[r][c] = true;
		for (int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			if(nr >= 0 && nr <M && nc >= 0 && nc < N) {
				if(!visit[nr][nc] && map[nr][nc] == 1) {
					dfs(nr, nc);
				}
			}
		}
	}
}
