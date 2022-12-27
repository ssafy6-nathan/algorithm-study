import java.io.*;
import java.util.*;

public class Main_BOJ_13549_숨바꼭질3 {

	static int N, K;
	static LinkedList<Seek> seek;
	static int result;
	final static int Lim = 100000;
	static boolean [] visited;
	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer token = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(token.nextToken());
		K = Integer.parseInt(token.nextToken());
		
		seek = new LinkedList<>();
		visited = new boolean[Lim+1];
//		seek.add(new Seek(0, N));
		
		find();
		System.out.println(result);
	}

	private static void find() {
		
		Queue<Seek> que = new LinkedList<>();
		
		visited[N] = true;
		que.add(new Seek(0, N));
		
		while(!que.isEmpty()) {
			
			Seek s = que.poll();
			
			int time = s.time;
			int place = s.place;
			
			if(place == K) {
				result = time;
				break;
			}
			
			if(2*place<=Lim && !visited[2*place]) {
				visited[2*place] = true;
				que.add(new Seek(time, 2*place));
			}

			if(place-1 >= 0 && !visited[place-1]) {
				visited[place-1] = true;
				que.add(new Seek(time+1, place-1));
			} 
			
			if(place+1 <= Lim && !visited[place+1]) {
				visited[place+1] = true;
				que.add(new Seek(time+1, place+1));
			} 

			
		}
		
	}

}
class Seek{
	int time;
	int place;
	public Seek(int time, int place) {
		super();
		this.time = time;
		this.place = place;
	}
}