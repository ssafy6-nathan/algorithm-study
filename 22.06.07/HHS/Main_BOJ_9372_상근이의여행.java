import java.io.*;
import java.util.*;

public class Main_BOJ_9372_상근이의여행 {

	static int T;
	static int N, M;
	static boolean [][] map;
	static boolean [] visited;
	static int result;

	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = null;
		
		T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t++) {
			result = 0;
			
			token = new StringTokenizer(br.readLine());
			N = Integer.parseInt(token.nextToken());
			M = Integer.parseInt(token.nextToken());
			
			map = new boolean[N+1][N+1];
			visited = new boolean[N+1];
			
			
			//각 노선도 표시
			for(int i = 0; i < M; i++) {
				token = new StringTokenizer(br.readLine());
				int start = Integer.parseInt(token.nextToken());
				int end = Integer.parseInt(token.nextToken());
				
				map[start][end] = true;
				map[end][start] = true;
				
			}
			
			//bfs 돌려서 1번 국가부터 노선 타보고 있으면 큐에 넣고 값 올리기
			bfs();
			System.out.println(result-1);
		}
		
		
	}

	private static void bfs() {
		Queue<Integer> que = new LinkedList<>();
		
		que.add(1);
		
		while(!que.isEmpty()) {
			int q = que.poll();
			
			//방문한 나라면 나가
			if(visited[q]) continue;
			result++;
			
			visited[q] = true;
			//다른 나라로 갈 수 있으면 큐에 넣기
			for (int i = 1; i <= N; i++) {
				if(map[q][i])
					que.add(i);
			}
		}
		
	}

}
