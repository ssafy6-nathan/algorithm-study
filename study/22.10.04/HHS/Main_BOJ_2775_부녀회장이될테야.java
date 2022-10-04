import java.io.*;

public class Main_BOJ_2775_부녀회장이될테야 {

	static int T;
	static int [][] dp;
	
	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		T = Integer.parseInt(br.readLine());
		dp = new int[15][15];
		for(int i = 0; i < 15; i++) {
			dp[0][i] = i+1;
			dp[i][0] = 1;
		}
		
		for(int i = 1; i < 15; i++) {
			for (int j = 1; j < 15; j++) {
				dp[i][j] = dp[i-1][j]+dp[i][j-1];
			}
		}
		
		for(int t = 1; t <= T; t++) {
		
			int k = Integer.parseInt(br.readLine()); //층
			int n = Integer.parseInt(br.readLine()); //호
			
			bw.write(String.valueOf(dp[k][n-1])+"\n");
			bw.flush();
		}
		bw.close();
	}

}
