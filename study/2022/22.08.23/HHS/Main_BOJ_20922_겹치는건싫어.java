import java.io.*;
import java.util.*;

public class Main_BOJ_20922_겹치는건싫어 {

	static int N, K;
	static int [] numbers;
	
	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = null;
		token = new StringTokenizer(br.readLine());
		N = Integer.parseInt(token.nextToken());
		K = Integer.parseInt(token.nextToken());
		
		
		numbers = new int[N];
		token = new StringTokenizer(br.readLine());

		for(int i = 0; i < N; i++)
			numbers[i] = Integer.parseInt(token.nextToken());
		
		int [] num = new int[1000000];
		
		int start = 0;
		int end = 0;
		int answer = 0;
		while(start <= end) {
			
			if(end == numbers.length)
				break;
			
			num[numbers[end]]++;
			while(num[numbers[end]] > K) {		
				//start 움직이면서 계속 빼주기	
				num[numbers[start]]--;
				start++;
			}
			answer = Math.max(answer, end-start+1);
			end++;
			
		}
		System.out.println(answer);
		
	}

}
