import java.io.*;

public class Main_BOJ_2631_줄세우기 {

	static int N;
	static int [] dp;
	static int [] line;
	
	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		N = Integer.parseInt(br.readLine());
		dp = new int[N];
		line = new int[N];
		
		for(int i = 0; i < N; i++)
			line[i] = Integer.parseInt(br.readLine());
		
		int Max = 0;
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < i; j++) {
				if(line[i] > line[j])
					dp[i] = Math.max(dp[j]+1, dp[i]);
			}
			Max = Math.max(Max, dp[i]);
		}
		
		bw.write(String.valueOf(N-Max-1));
		bw.close();
	}

}
