package study_Nathan;

import java.io.*;
import java.util.*;

public class Main_BOJ_2156_포도주시식 {

	static int N;
	static int [] wine;
	static int [] dp;
	
	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		
		wine = new int[N+1];
		dp = new int[N+1];
		
		for (int i = 1; i <= N; i++) {
			wine[i] = Integer.parseInt(br.readLine());
		}
		
		wine[0] = 0;
		dp[1] = wine[1];
		
		if(N > 1) {
			dp[2] = dp[1] + wine[2];
		}
		int max_value = 0;
		for (int i = 3; i <= N; i++) {
			//2잔 연속 안마시는 경우까지 포함해서 봐야함
			//마지막잔 안마시는 경우까지 
			max_value = Math.max(dp[i-2], dp[i-3]+wine[i-1]);
			dp[i] = Math.max(max_value, dp[i-3]) + wine[i];
			
			dp[i] = Math.max(dp[i], dp[i-1]);
		}
		
		System.out.println(dp[N]);
		
	}

}
