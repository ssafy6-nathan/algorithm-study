import java.io.*;
import java.util.*;

public class Main_BOJ_3067_coin {

	static int T;
	static int N;
	static int [] arr;
	static int price;
	static int [] dp;
	
	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer token = null;
		
		T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			arr = new int [N];
			token = new StringTokenizer(br.readLine());
			for(int i = 0; i < N; i++)
				arr[i] = Integer.parseInt(token.nextToken());
			
			price = Integer.parseInt(br.readLine());
			dp = new int[price+1];
			
			dp[0] = 1;
			for(int i = 0; i < N; i++) {
				for(int j = arr[i]; j <= price; j++)
					dp[j] += dp[j - arr[i]];
			}
			
			bw.write(String.valueOf(dp[price]+"\n"));
		}
		bw.close();
		
		
	}

}
