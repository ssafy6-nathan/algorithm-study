import java.io.*;
import java.util.*;

public class Main_BOJ_15486_퇴사2 {

	static int N;
	static int [][] quit;
	static int [] dp;
	static int M = Integer.MIN_VALUE;
	
	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		quit = new int[N+2][2];
		dp = new int[N+2];
		
		StringTokenizer token = null;
		
		for(int i = 1; i <= N; i++) {
			token = new StringTokenizer(br.readLine());
			quit[i][0] = Integer.parseInt(token.nextToken());
			quit[i][1] = Integer.parseInt(token.nextToken());
		}
		
		//날짜 더했을 때 범위 안넘으면 값 비교해서 dp에 넣어주기
		for (int i = 1; i <= N+1; i++) {
			M = Math.max(M, dp[i]);
			
			int nextDay = i+quit[i][0];
			
			if(nextDay < N+2) {
				dp[nextDay] = Math.max(dp[nextDay], M+quit[i][1]);
			}			
		}
		System.out.println(dp[N+1]);		
		
		
		
	}

}
