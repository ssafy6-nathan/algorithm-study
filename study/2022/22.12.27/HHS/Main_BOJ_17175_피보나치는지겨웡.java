import java.io.*;

public class Main_BOJ_17175_피보나치는지겨웡 {

	static int N;
	static int [] dp;
	static final int num = 1000000007;
	
	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		dp = new int[N+1];
		
		dp[0] = 1;
		if(N > 0)
		dp[1] = 1;
		
		for(int i = 2; i <= N; i++) {
			dp[i] = (dp[i-1] + dp[i-2] + 1) % num;
		}
		
		System.out.println(dp[N]);
	}

}
