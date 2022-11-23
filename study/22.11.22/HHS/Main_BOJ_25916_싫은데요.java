import java.io.*;
import java.util.*;

public class Main_BOJ_25916_싫은데요 {

	static int N, M;
	static int [] arr;
	static int answer;	
	
	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer token = null;
		
		token = new StringTokenizer(br.readLine());
		N = Integer.parseInt(token.nextToken());
		M = Integer.parseInt(token.nextToken()); //부피
		arr = new int[N];
		
		token = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++)
			arr[i] = Integer.parseInt(token.nextToken());
		
		int s = 0; 
		int e = 0;
		
		int sum = 0;
		while(e < N && s < N) {
			sum += arr[e];
			e++;
			
			while(sum > M) {
				sum -= arr[s];
				s++;
			}
			answer = Math.max(answer, sum);
		}
		
		bw.write(String.valueOf(answer));
		bw.close();
	}

}
