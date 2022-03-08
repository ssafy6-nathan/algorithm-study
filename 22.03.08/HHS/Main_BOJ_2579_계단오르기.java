package study_Nathan;

import java.io.*;
import java.util.*;

public class Main_BOJ_2579_계단오르기 {

	static int N;
	static int [] stairs;
	static int [] dp;
	
	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		stairs = new int[N+1];
		dp = new int[N+1];
		
		for (int i = 1; i <=N; i++) {
			stairs[i] = Integer.parseInt(br.readLine());
		}
		
		stairs[0] = 0; //시작점은 0
		
		//dp[1]값과 dp[2]값 지정해주기
		dp[1] = stairs[1]; 

		if(N > 1) {
			dp[2] = dp[1] + stairs[2];
		}
		
		for (int i = 3; i <= N; i++) {
			//연속 3칸 금지
			dp[i] = Math.max(dp[i-2], dp[i-3]+stairs[i-1]) + stairs[i];			
		}
		
		System.out.println(dp[N]);
		
	}

}
