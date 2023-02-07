import java.io.*;
import java.util.*;

public class Main_BOJ_15565_귀여운라이언 {

	static int N, K;
	static int [] dolls;
	
	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = null;
		token = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(token.nextToken());
		K = Integer.parseInt(token.nextToken());
		
		dolls = new int[N];
		ArrayList<Lion> lion = new ArrayList<>();
		token = new StringTokenizer(br.readLine());
		int count = 0;
		for(int i = 0; i < N; i++) {
			dolls[i] = Integer.parseInt(token.nextToken());
			if(dolls[i] == 1)
				lion.add(new Lion(i, ++count));
		}
		int answer = Integer.MAX_VALUE;
		
		for(int i = 0; i <= lion.size()-K; i++) {
			int start = lion.get(i).idx;
			int end = lion.get(i+K-1).idx;
			answer = Math.min(answer, end-start);
		}
		if(answer == Integer.MAX_VALUE)
			System.out.println(-1);
		else
			System.out.println(answer+1);
		
	}

	static class Lion{
		int idx;
		int count;
		public Lion(int idx, int count) {
			this.idx = idx;
			this.count = count;
		}
	}
}