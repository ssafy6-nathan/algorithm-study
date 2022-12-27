
import java.io.*;
import java.util.*;

public class Main_BOJ_11048_이동하기 {

	static int [][] dp;
	static int [][] arr;
	static int N, M;
	
	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer token = null;
		
		token = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(token.nextToken());
		M = Integer.parseInt(token.nextToken());
		
		dp = new int[N][M];
		arr = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			token = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(token.nextToken());
			}
		}
		
		dp[0][0] = arr[0][0];
		for (int i = 1; i < M; i++) {
			dp[0][i] = dp[0][i-1] + arr[0][i];
		}
		
		for (int i = 1; i < N; i++) {
			dp[i][0] = dp[i-1][0] + arr[i][0];
		}
		
		
		for (int i = 1; i < N; i++) {
			for (int j = 1; j < M; j++) {
				int dpMax = 0;
				dpMax = Math.max(dp[i-1][j-1], dp[i-1][j]);
				dp[i][j] = Math.max(dpMax, dp[i][j-1]) + arr[i][j];
				
			}
		}
		
		System.out.println(dp[N-1][M-1]);
	}

}
