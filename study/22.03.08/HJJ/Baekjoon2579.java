package study.nathan_algo_study.week2;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 문제이름 : 계단 오르기
 * 링크 : https://www.acmicpc.net/problem/2579
 */

public class Baekjoon2579 {
    static int stairs;
    static int[] dp;
    static int[] stairsArr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        stairs = Integer.parseInt(br.readLine());
        dp = new int[stairs + 1];
        stairsArr = new int[stairs + 1];
        for (int i = 1; i < stairs + 1; i++)
            stairsArr[i] = Integer.parseInt(br.readLine());

        dp[1] = stairsArr[1];
        if (stairs >= 2)
            dp[2] = stairsArr[1] + stairsArr[2];

        for (int i = 3; i < dp.length; i++)
            dp[i] = Math.max(dp[i-2], dp[i-3] + stairsArr[i-1]) + stairsArr[i];

        br.close();
        System.out.println(dp[stairs]);

    }
}

/*

 */
