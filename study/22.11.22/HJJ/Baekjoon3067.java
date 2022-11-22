package study.nathan_algo_study.week37;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 문제이름 : Coins
 * 링크 : https://www.acmicpc.net/problem/3067
 */

public class Baekjoon3067 {
    static int N;
    static int M;
    static int[] coins;
    static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int tc = Integer.parseInt(br.readLine());
        for (int t = 0; t < tc; t++) {
            int N = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            coins = new int[N];
            for (int i = 0; i < N; i++)
                coins[i] = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(br.readLine());

            dp = new int[M+1];
            dp[0] = 1;
            for (int i = 0; i < N; i++) {
                for (int money = 0; money <= M; money++) {
                    if (coins[i] <= money)
                        dp[money] += dp[money - coins[i]];
                }
            }

            bw.write(dp[M]+"\n");
        }
        bw.close();
    }

}

/*



*/
