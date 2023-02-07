import java.io.*;
import java.util.*;

public class Main_BOJ_1535_안녕 {

	static int N;
	static int [][] dp;
	static int [][] arr;
	
	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		N = Integer.parseInt(br.readLine());
		
		arr = new int [N+1][2];
		
		StringTokenizer token = null;
		token = new StringTokenizer(br.readLine());
		for(int i = 1; i <= N; i++)
			arr[i][0] = Integer.parseInt(token.nextToken()); //체력
		
		token = new StringTokenizer(br.readLine());
		for(int i = 1; i <= N; i++)
			arr[i][1] = Integer.parseInt(token.nextToken()); //기쁨

		
		dp = new int[N+1][101];
		for(int i = 1; i <= N; i++) {
			for(int j = 1; j <= 100; j++) {
				if(arr[i][0] < j) 
					dp[i][j] = Math.max(dp[i-1][j-arr[i][0]]+ arr[i][1], dp[i-1][j]);
				else
					dp[i][j] = dp[i-1][j];
			}
		}
		
		bw.write(String.valueOf(dp[N][100]));
		bw.close();
	}

}
