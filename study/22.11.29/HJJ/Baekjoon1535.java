package study.nathan_algo_study.week38;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 문제이름 : 안녕
 * 링크 : https://www.acmicpc.net/problem/1535
 */

public class Baekjoon1535 {
    static int N;
    static int[] healths;
    static int[] happys;
    static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        healths = new int[N];
        happys = new int[N];
        dp = new int[100];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            healths[i] = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            happys[i] = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            for (int j = 99; j >= healths[i]; j--) {
                dp[j] = Math.max(dp[j - healths[i]] + happys[i], dp[j]);
            }
        }

        System.out.println(dp[99]);
    }
}

/*
1  21 79
20 30 25


*/
