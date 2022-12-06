import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int N;
	static int[][] map;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static boolean[][] visited;
	static int count = 1;

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		N = in.nextInt();
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			String str = in.next();
			for (int j = 0; j < N; j++) {
				map[i][j] = str.charAt(j)-'0';
			}
		}

		visited = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 1 && !visited[i][j]) {// 집 있고 방문 안 한 곳
					dfs(i, j);// 탐색
					count++;
				}
			}
		}
		System.out.println(count - 1);// 시작을 1로 했어서
		int total[] = new int[count];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] != 0) {
					total[map[i][j]]++;
				}
			}
		}
		Arrays.sort(total);
		for (int i = 1; i < total.length; i++) {
			System.out.println(total[i]);
		}
		in.close();
	}

	private static void dfs(int r, int c) {
		map[r][c] = count;// 방문 후 표시
		visited[r][c] = true;
		for (int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			// 범위체크
			if (nr >= 0 && nr < N && nc >= 0 && nc < N) {
				if (map[nr][nc] == 1 && !visited[nr][nc]) {// 집 있고 방문 안 한 곳
					dfs(nr, nc);
				}
			}
		}

	}
}
