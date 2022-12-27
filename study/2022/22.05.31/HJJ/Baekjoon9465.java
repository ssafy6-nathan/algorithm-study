package study.nathan_algo_study.week14;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 문제이름 : 스티커
 * 링크 : https://www.acmicpc.net/problem/9465
 */

public class Baekjoon9465 {
    static int[][] stickers;
    static int[][] dp;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int tc = Integer.parseInt(br.readLine());
        for (int t = 0; t < tc; t++) {
            N = Integer.parseInt(br.readLine());
            stickers = new int[2][N + 1];
            dp = new int[2][N + 1];

            for (int i = 0; i < 2; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 1; j < N + 1; j++)
                    stickers[i][j] = Integer.parseInt(st.nextToken());
            }
            dp[0][1] = stickers[0][1];
            dp[1][1] = stickers[1][1];

            for (int i = 2; i < N + 1; i++) {
                for (int j = 0; j < 2; j++) {
                    dp[j][i] = stickers[j][i] + Math.max(dp[(j + 1) % 2][i - 1], dp[(j + 1) % 2][i - 2]);
                }
            }

            bw.write((Math.max(dp[0][N], dp[1][N])) + "\n");
        }
        bw.close();
    }
}

/*

 */
