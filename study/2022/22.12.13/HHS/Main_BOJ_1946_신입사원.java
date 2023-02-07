import java.io.*;
import java.util.*;

public class Main_BOJ_1946_신입사원 {

	static int T;
	static int N;
	static int answer;
	static int [] arr;
	
	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			
			StringTokenizer token = null;
			arr = new int[N];
			answer = N;
			
			for(int i = 0; i < N; i++) {
				token = new StringTokenizer(br.readLine());
				int resume = Integer.parseInt(token.nextToken()) - 1;
				int interview = Integer.parseInt(token.nextToken()) - 1;
				
				arr[resume] = interview;
			}
			int m = arr[0];
			for(int i = 1; i < N; i++) {
				if(arr[i] > m)
					answer--;
				m = Math.min(m, arr[i]);
			}
			
			bw.write(String.valueOf(answer)+"\n");
			
		}
		bw.close();
		
	}

}
