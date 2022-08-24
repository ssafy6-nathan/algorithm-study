package study.nathan_algo_study.week26;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 문제이름 : 내려가기
 * 링크 : https://www.acmicpc.net/problem/2096
 */

public class Baekjoon2096 {
    static int N;
    static int[][] nums;
    static int[][][] dp;
    static int max, min;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        nums = new int[N+1][3];
        dp = new int[2][N+1][3];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());

            nums[i][0] = Integer.parseInt(st.nextToken());
            nums[i][1] = Integer.parseInt(st.nextToken());
            nums[i][2] = Integer.parseInt(st.nextToken());
        }

        solution();

        System.out.println(max + " " + min);
    }

    public static void solution() {
        for (int i = 1; i <= N; i++) {
            dp[0][i][0] = nums[i][0] + Math.min(dp[0][i-1][0], dp[0][i-1][1]);
            dp[0][i][1] = nums[i][1] + Math.min(Math.min(dp[0][i-1][0], dp[0][i-1][1]), dp[0][i-1][2]);
            dp[0][i][2] = nums[i][2] + Math.min(dp[0][i-1][1], dp[0][i-1][2]);
        }

        for (int i = 1; i <= N; i++) {
            dp[1][i][0] = nums[i][0] + Math.max(dp[1][i-1][0], dp[1][i-1][1]);
            dp[1][i][1] = nums[i][1] + Math.max(Math.max(dp[1][i-1][0], dp[1][i-1][1]), dp[1][i-1][2]);
            dp[1][i][2] = nums[i][2] + Math.max(dp[1][i-1][1], dp[1][i-1][2]);
        }

        min = Math.min(Math.min(dp[0][N][0], dp[0][N][1]), dp[0][N][2]);
        max = Math.max(Math.max(dp[1][N][0], dp[1][N][1]), dp[1][N][2]);
    }
}

/*
1 2 3
4 5 6
4 9 0

1 2 3
5 6 8
9 14 6


*/
