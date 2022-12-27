import java.util.*;
import java.io.*;

public class Main_BOJ_쉬운계단수 {

	static long answer;
	static int N;
	
	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		long [][] dp = new long[N+1][10];
		
		for(int i = 1; i <= 9; i++)
			dp[1][i] = 1;
		
		for(int i = 2; i <= N; i++) {
			for(int j = 0; j <= 9; j++) {
				if(j == 0)
					dp[i][j] = dp[i-1][j+1];
				else if(j == 9)
					dp[i][j] = dp[i-1][j-1];
				else
					dp[i][j] = dp[i-1][j-1] + dp[i-1][j+1];
				
				dp[i][j] %= 1000000000;
			}
		}
		
		for(int i = 0; i <= 9; i++) {
			answer += dp[N][i];
		}
		System.out.println(answer%1000000000);
	}

}
