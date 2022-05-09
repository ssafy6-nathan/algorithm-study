import java.io.*;
import java.util.*;

public class Main_BOJ_2606_바이러스 {

	static int N; //컴퓨터 1~N 번까지 있음
	static int K; 
	static LinkedList<Line> line;
	static int result;
	
	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		K = Integer.parseInt(br.readLine());
		
		line = new LinkedList<>();
		
		StringTokenizer token = null;
		
		for (int i = 0; i < K; i++) {
			token = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(token.nextToken());
			int end = Integer.parseInt(token.nextToken());
			line.add(new Line(start, end));
		}
		
		bfs();
		
		System.out.println(result);
	}

	private static void bfs() {
		
		boolean [] visited = new boolean [N+1];
		Queue<Integer> que = new LinkedList<Integer>();
		que.add(1);

		
		while(!que.isEmpty()) {
		
			int start = que.poll();
			visited[start] = true;
			
			for (int i = 0; i < K; i++) {
				if(line.get(i).start == start && !visited[line.get(i).end]) {
					visited[line.get(i).end] = true;
					que.add(line.get(i).end);
				}
				if(line.get(i).end == start && !visited[line.get(i).start]) {
					visited[line.get(i).start] = true;
					que.add(line.get(i).start);
				}
			}
		}
		for (int i = 2; i < N+1; i++) {
			if(visited[i]) result++;
		}
	}

}
class Line{
	int start;
	int end;
	public Line(int start, int end) {
		super();
		this.start = start;
		this.end = end;
	}
}
