import java.io.*;
import java.util.*;

public class Main_BOJ_12847_꿀아르바이트 {

	static int N, M;
	static int [] nums;
	static long [] sum;
	
	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer token = null;
		
		token = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(token.nextToken());
		M = Integer.parseInt(token.nextToken());
		
		nums = new int[N];
		token = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(token.nextToken());
		}
		
		sum = new long[N+1];
		long answer = 0;
		for(int i = 1; i <= N; i++) {
			if(i <= M) 
				sum[i] = nums[i-1] + sum[i-1];
				
			else {
				sum[i] = nums[i-1] + sum[i-1] - nums[i-M-1];
			}
			answer = Math.max(sum[i], answer);
		}
		System.out.println(answer);
	}

}
