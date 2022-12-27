import java.io.*;
import java.util.*;

public class Main_BOJ_11659_구간합구하기4 {

	static int N, M;//수의 개수, 합을 구해야 하는 횟수
	static int [] numbers;
	static int [] sum;
	
	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer token = null;
		token = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(token.nextToken());
		M = Integer.parseInt(token.nextToken());
		
		numbers = new int[N+1];
		sum = new int[N+1];
		
		token = new StringTokenizer(br.readLine());
		for(int i = 1; i <= N; i++) {
			numbers[i] = Integer.parseInt(token.nextToken());
			if(i >= 2)
				sum[i] = sum[i-1] + numbers[i];
			else sum[i] = numbers[i];
		}
		
		for(int t = 0; t < M; t++) {
			token = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(token.nextToken()) - 1;
			int end = Integer.parseInt(token.nextToken());
			System.out.println(sum[end]-sum[start]);
		}
		
	}

}
