import java.io.*;
import java.util.*;

public class Main_BOJ_12865_평범한배낭 {

	static int N, K;
	static int arr[][];
	
	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer token = null;
		token = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(token.nextToken());//개수
		K = Integer.parseInt(token.nextToken());//견딜 수 있는 무게
		
		arr = new int[N][2];
		
		for(int i = 0; i < N; i++) {
			token = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(token.nextToken());
			arr[i][1] = Integer.parseInt(token.nextToken()); //value
		}
		
		int [] dp = new int[K+1];
		
		for (int i = 0; i < N; i++) {
			for (int j = K; j - arr[i][0] >= 0; j--) {
				dp[j] = Math.max(dp[j], dp[j-arr[i][0]] + arr[i][1]);
			}
		}
		
		bw.write(String.valueOf(dp[K]));
		bw.close();
	}

}