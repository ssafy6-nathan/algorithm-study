package study_Nathan;

import java.io.*;
import java.util.*;

public class Main_BOJ_11047_동전0 {

	static int N, K;
	static int [] coin;
	static int count;
	
	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer token = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(token.nextToken());
		K = Integer.parseInt(token.nextToken());
		
		coin = new int[N];
		
		for (int i = 0; i < N; i++) {
			coin[N-1-i] = Integer.parseInt(br.readLine());
		}//코인 배열에 내림차순으로 넣어놓기
		
		//해당 금액보다 큰 코인값이면 넘기고 작은 값이면 그 금액만큼 계속 빼주며 카운트 올리기
		
		int index = 0;
		
		while(K > 0) {
			if(coin[index] <= K) {
				count++;
				K -= coin[index];
			}else index++;
		}
		
		System.out.println(count);
		
	}

}
