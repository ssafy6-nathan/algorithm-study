import java.io.*;
import java.util.*;

public class Main_BOJ_13422_도둑 {

	static int T;
	static int N, M, K;
	static int [] houses;
	
	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = null; 
		
		T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t++) {
			token = new StringTokenizer(br.readLine());
			N = Integer.parseInt(token.nextToken());
			M = Integer.parseInt(token.nextToken());
			K = Integer.parseInt(token.nextToken());
			
			houses = new int[N+M-1];
			long sum = 0;
			int count = 0;
			
			token = new StringTokenizer(br.readLine());
			for(int i = 0; i < houses.length; i++) {				
				if(i < N) 
					houses[i] = Integer.parseInt(token.nextToken());
				else
					houses[i] = houses[i%N];
			}
			
			for(int i = 0; i < M; i++)
				sum += houses[i];
			
			if(sum < K)
				count++;
			
			if(N != M) {
				for(int i = M; i < houses.length; i++) {
					sum -= houses[i-M];
					sum += houses[i];
					if(sum < K)
						count++;
				}
			}
			System.out.println(count);
		}
		
	}

}
