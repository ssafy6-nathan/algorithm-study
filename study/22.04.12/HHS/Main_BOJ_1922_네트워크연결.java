package study_Nathan;

import java.io.*;
import java.util.*;

public class Main_BOJ_1922_네트워크연결 {
	
	static class Edge implements Comparable<Edge>{
		int from;
		int to;
		int weight;
		
		public Edge(int from, int to, int weight) {
			super();
			this.from = from;
			this.to = to;
			this.weight = weight;
		}
		
		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.weight, o.weight);
		}
		
	}

	static int N, M;
	static Edge [] network;
	static int result;
	static int [] parents;
	
	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer token;
		
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		
		parents = new int[N+1];
		network = new Edge[M];
		
		for(int i = 0; i < M; i++) {
			token = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(token.nextToken());
			int to = Integer.parseInt(token.nextToken());
			int weight = Integer.parseInt(token.nextToken());
			
			network[i] = new Edge(from, to, weight);
		}
		//간적크 간만프 
		//크루스칼 이용하여 최소값 구하기
		
		kruskal();
		
	}

	private static void kruskal() {
		
		int count = 0; //모든 정점 다 돌았는지 확인할 것
		
		Arrays.sort(network);
		
		make();
		
		for (int i = 0; i < network.length; i++) {
			
			if(union(network[i].from, network[i].to)) {
				//부모가 다르다면 합치고 result 올리고 카운트 올리기
				result += network[i].weight;
				count++;
				
				if(count == N-1)
					System.out.println(result);

			}
		}
		
		
	}

	private static void make() {
		//일단 자기 자신을 다 부모로 만들어놓기
		for (int i = 1; i <= N; i++) {
			parents[i] = i;
		}
		
	}
	
	private static int find(int a) {
		//부모찾기
		if(a == parents[a])
			return a;
		
		return parents[a] = find(parents[a]);
	}
	
	private static boolean union(int a, int b) {
		//부모 같은지 확인하고 다르다면 b의 부모를 a의 부모로 하고 트루 리턴

		int aRoot = find(a);
		int bRoot = find(b);
		
		if(aRoot == bRoot)
			return false;
		
		parents[aRoot] = bRoot;
		return true;
	}

}
