import java.io.*;
import java.util.*;

public class Main_BOJ_11779_최소비용구하기2 {

	static int N;
	static int M;
	static ArrayList<Bus>[] bus;
	static int [] cities;
	static int [] costs;
	static int startCity, endCity;
	
	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		
		bus = new ArrayList[N+1];
		cities = new int[N+1];
		costs = new int[N+1];
		
		for(int i = 1; i <= N; i++) {
			bus[i] = new ArrayList<Bus>();
			costs[i] = Integer.MAX_VALUE;
		}
		
		StringTokenizer token = null;
		
		for(int i = 0; i < M; i++) {
			token = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(token.nextToken());
			int end = Integer.parseInt(token.nextToken());
			int cost = Integer.parseInt(token.nextToken());
			bus[start].add(new Bus(end, cost));
		}
		
		token = new StringTokenizer(br.readLine());
		startCity = Integer.parseInt(token.nextToken());
		endCity = Integer.parseInt(token.nextToken());
		
		find();
		
		//endCity까지 가는 방법 찾기
		ArrayList<Integer> result = new ArrayList<>();
		result.add(endCity);
		int c = endCity;
		while(c != startCity) {
			c = cities[c];
			result.add(c);
		}

		//비용
		System.out.println(costs[endCity]);
		
		//시티 개수 출력
		System.out.println(result.size());
		
		//경로 출력
		for(int i = result.size()-1; i >= 0; i--) {
			System.out.print(result.get(i) + " ");
		}System.out.println();
				
		
		
	}

	private static void find() {
		
		PriorityQueue<Bus> que = new PriorityQueue<Bus> (
				(o1,o2) -> Integer.compare(o1.cost, o2.cost));
				
		
		boolean [] visited = new boolean[N+1];
		que.add(new Bus(startCity,0));
		costs[startCity] = 0;
		
		while(!que.isEmpty()) {
			
			Bus b = que.poll();
			int nowBus = b.city;
			//방문했으면 나가
			if(visited[nowBus])
				continue;
			visited[nowBus] = true;
			
			for(int i = 0; i < bus[nowBus].size(); i++) {
				Bus bb = bus[nowBus].get(i);
				
				//더 작으면 이걸로 바꿔
				if(costs[bb.city] > costs[nowBus] + bb.cost) {
					costs[bb.city] = costs[nowBus] + bb.cost;
					que.add(new Bus(bb.city, costs[bb.city]));
					
					cities[bb.city] = nowBus;
				}
			}
			
		}
		
		
		
	}

	
} 
class Bus implements Comparable<Bus>{
	int city;
	int cost;
	
	public Bus(int city,int cost) {
		super();
		this.city = city;
		this.cost = cost;
	}
	@Override
	public int compareTo(Bus b) {
		return this.cost - b.cost;
	}

}
