package study_Nathan;

import java.io.*;
import java.util.*;

public class Main_BOJ_11047_동전0_2번째풀이 {

	static int N, K;
	static int result;
	
	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer token = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(token.nextToken());
		K = Integer.parseInt(token.nextToken());
		
		int [] coin = new int[N];
		
		for(int i = 0; i < N; i++) {
			coin[i] = Integer.parseInt(br.readLine());
		}
		
		int i = N-1;
		
		while(K > 0) {
			
			if(coin[i] <= K && coin[i] != 0) {
				int count = K / coin[i];
				K -= count * coin[i];
				result += count;
			}
			
			i--;

		}
		
		System.out.println(result);
	}

}
