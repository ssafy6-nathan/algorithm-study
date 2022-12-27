
import java.io.*;
import java.util.*;

public class Main_BOJ_2559_수열 {

	static int N, K;
	static int [] temp;
	static int result = Integer.MIN_VALUE;
	
	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = null;
		
		token = new StringTokenizer(br.readLine());
		N = Integer.parseInt(token.nextToken());
		K = Integer.parseInt(token.nextToken());
		
		temp = new int[N];
		
		token = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			temp[i] = Integer.parseInt(token.nextToken());
		}
		int sum = 0;
		for(int i = 0; i < K; i++) {
			sum += temp[i];
		}
		result = Math.max(sum, result);
		for (int i = 1; i <= N-K; i++) {
			sum -= temp[i-1];
			sum += temp[i+K-1];
			result = Math.max(sum, result);
		}
		System.out.println(result);
	}

}
