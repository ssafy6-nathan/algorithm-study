import java.io.*;

/**
 * 백준 1003번
 * 피보나치 함수 (https://www.acmicpc.net/problem/1003)
 * 분류 : 다이나믹 프로그래밍
 **/

public class BJ_1003 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        int[][] dp;

        for (int k = 0; k < T; k++) {
            
            // fibo(N)의 N값 입력받기
            int N = Integer.parseInt(br.readLine());

            // 문제에서 N은 최대 40까지 입력받을 수 있으므로 41행 확보(0~40)
            // dp[N][0] = 0의 개수 저장
            // dp[N][1] = 1의 개수 저장
            dp = new int[41][2];

            // fibo(0)값 세팅
            dp[0][0] = 1;
            dp[0][1] = 0;

            // 현재항 0의 개수 = 이전항 1의 개수
            // 현재항 1의 개수 = 이전항 0의 개수 + 이전항 1의 개수
            for (int j = 1; j <= N; j++) {
                dp[j][0] = dp[j-1][1];
                dp[j][1] = dp[j-1][0] + dp[j-1][1];
            }

            bw.write(dp[N][0] + " " + dp[N][1] + "\n");
        }

        bw.flush();
        bw.close();
    }
}
