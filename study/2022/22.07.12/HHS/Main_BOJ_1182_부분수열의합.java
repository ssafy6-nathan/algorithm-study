package study_Nathan;

import java.io.*;
import java.util.*;

public class Main_BOJ_1182_부분수열의합 {

	static int N, S;
	static int [] number;
	static int count;
	
	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = null;
		
		token = new StringTokenizer(br.readLine());
		N = Integer.parseInt(token.nextToken());
		S = Integer.parseInt(token.nextToken());
		number = new int[N];
		
		token = new StringTokenizer(br.readLine()," ");
		for(int i = 0; i < N; i++) {
			number[i] = Integer.parseInt(token.nextToken());
		}
		
		
		subset(0, new boolean[N]);
		
		if(S == 0) 
			count-=1;
		System.out.println(count);
		
	}

	private static void subset(int cnt, boolean[] v) {
		if(cnt == N) {
			int sum = 0;
			for(int i = 0; i < N; i++) {
				if(v[i])
					sum += number[i];
			}
			if(sum == S) 
				count++;
			return;
		}
		v[cnt] = true;
		subset(cnt+1, v);
		v[cnt] = false;
		subset(cnt+1, v);
		
	}

}
