import java.io.*;
import java.util.StringTokenizer;

/**
 * 백준 1010번
 * 다리 놓기 (https://www.acmicpc.net/problem/1010)
 * 분류 : 수학, 다이나믹 프로그래밍, 조합론
 **/

public class BJ_1010 {

    static int[][] dp = new int[30][30];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {

            // N = r, M = n
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt((st.nextToken()));
            int M = Integer.parseInt((st.nextToken()));
            
            bw.write(combi(M, N)+"\n");
        }

        bw.flush();
        bw.close();
    }

    // 조합공식
    static int combi (int n, int r) {
        if (dp[n][r] > 0)
            return dp[n][r];
        if (n == r | r == 0) 
            return dp[n][r] = 1;
        else
            return dp[n][r] = combi(n-1, r-1) + combi(n-1, r);
    }
        
}
