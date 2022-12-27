import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class b2606_바이러스 {
	static boolean[][] map;
	static int n, e, s;
	static int cnt = 0;
	static boolean[] visited;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());	// 정점
		e = Integer.parseInt(br.readLine());	// 간선
		s = 1; // 시작
		map = new boolean[n+1][n+1];
		visited = new boolean[n+1];
		for (int i = 1; i <= e; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			map[u][v] = map[v][u] = true;
		}
		bfs(s);
		System.out.println(cnt);
	}
	private static int bfs(int s) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(s);
		visited[s]=true;
		while(!q.isEmpty()) {
			int next_n = q.poll();
			for(int i=1;i<=n;i++) {
				if(map[next_n][i]==true && visited[i]==false) {
					q.add(i);
					visited[i] = true;
					cnt++;
				}
			}
		}
		return cnt;
	}
}
