import java.io.*;
import java.util.*;

public class Main_BOJ_2252_줄세우기 {

	static int N, M;
	static int [] student;
	static ArrayList<Integer>[] line;
	
	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = null;
		
		token = new StringTokenizer(br.readLine());
		N = Integer.parseInt(token.nextToken());
		M = Integer.parseInt(token.nextToken());
		
		student = new int[N+1]; //1부터 조회하기
		line = new ArrayList[N+1];
		StringBuilder sb = new StringBuilder();
		
		for (int i = 1; i <= N; i++) {
			line[i] = new ArrayList<Integer>();
		}
		
		for (int i = 0; i < M; i++) {
			token = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(token.nextToken());
			int end = Integer.parseInt(token.nextToken());
			
			line[start].add(end);
			student[end]++;
		}
		
		Queue<Integer> que = new LinkedList<>();
		//student 0 인 것만 큐에 넣기
		for (int i = 1; i <= N; i++) {
			if(student[i] == 0)
				que.add(i);
		}
		
		while(!que.isEmpty()) {
			int std = que.poll();
			sb.append(std + " ");
			
			for(int i = 0; i < line[std].size(); i++) {
				int e = line[std].get(i);
				student[e]--;
				if(student[e] == 0)
					que.add(e);
			}
			
		}
		System.out.println(sb.toString());
		
	}

}
