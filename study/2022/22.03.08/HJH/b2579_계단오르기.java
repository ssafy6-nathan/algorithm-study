import java.io.IOException;
import java.util.Scanner;
//dp
public class b2579_계단오르기 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int[] stairs = new int[N+1];
		for(int i = 1; i <= N; i++) {
			stairs[i] = in.nextInt();
		}
		int[] dp = new int[N+1];
		dp[1] = stairs[1];
		if (N >= 2) {
			dp[2] = stairs[1] + stairs[2]; 
		}
		for(int i = 3; i <= N; i++) {
			dp[i] = Math.max(dp[i-2], dp[i-3] + stairs[i-1]) + stairs[i];
		}
		System.out.println(dp[N]);
	}
}
