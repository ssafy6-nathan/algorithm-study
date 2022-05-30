
import java.io.*;
import java.util.*;

public class Main_BOJ_9456_스티커 {

	static int T;
	static int N;
	static int [][] sticker;
	static int [][] dp;
	static int result;
	
	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		T = Integer.parseInt(br.readLine());
		
		for (int i = 1; i <= T; i++) {
			N = Integer.parseInt(br.readLine());

			sticker = new int[2][N+1];
			dp = new int[2][N+1];
			
			for (int j = 0; j < 2; j++) {
				StringTokenizer token = new StringTokenizer(br.readLine());
				for (int k = 1; k < N+1; k++) {
					sticker[j][k] = Integer.parseInt(token.nextToken());
				}
			}
			
			dp[0][1] = sticker[0][1];
			dp[1][1] = sticker[1][1];
			
			for (int k = 2; k < N+1; k++) {
				
				dp[0][k] = Math.max(dp[1][k-2], dp[1][k-1]) + sticker[0][k];
				dp[1][k] = Math.max(dp[0][k-2], dp[0][k-1]) + sticker[1][k];
					
			}

			result = Math.max(dp[0][N], dp[1][N]);
			System.out.println(result);
			
		}
		
	}

}
