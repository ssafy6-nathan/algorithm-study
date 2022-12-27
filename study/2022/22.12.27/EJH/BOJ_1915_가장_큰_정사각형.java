import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1915_가장_큰_정사각형 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] arr= new int[N + 1][M + 1];
        int[][] dp = new int[N + 1][M + 1];
        int max = 0;

        for (int i = 1; i <= N; i++) {
            String[] input = br.readLine().split("");
            for (int j = 1; j <= M; j++) {
                arr[i][j] = Integer.parseInt(input[j - 1]);
                dp[i][j] = arr[i][j];

                if (i > 0 && j > 0){
                    if(dp[i-1][j] > 0 && dp[i-1][j-1] > 0 && dp[i][j-1] > 0 && dp[i][j] > 0) {
                        int min = Math.min(dp[i-1][j], Math.min(dp[i-1][j-1], dp[i][j-1]));
                        dp[i][j] = min + 1;
                    }
                }
                max = Math.max(max, dp[i][j]);
            }
        }

        System.out.println(max * max);
    }
}
