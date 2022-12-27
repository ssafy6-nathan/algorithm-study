import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static final int[][] dp = new int[31][31];
    static int T, N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            int ans = comb(M,N);
            sb.append(ans).append('\n');
        }
        System.out.println(sb);
        br.close();
    }

    private static int comb(int n, int r) {
        if (dp[n][r] > 0) return dp[n][r];
        else if (n == r || r == 0) return dp[n][r] = 1;
        else return dp[n][r] = comb(n - 1, r - 1) + comb(n - 1, r);
    }
}
