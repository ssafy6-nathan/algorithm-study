package study.nathan_algo_study.week38;

import java.io.*;
import java.util.*;

/**
 * 문제이름 : LCS3
 * 링크 : https://www.acmicpc.net/problem/1958
 */

public class Baekjoon1958 {
    static String[] strings;
    static int[][][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        strings = new String[3];
        strings[0] = br.readLine();
        strings[1] = br.readLine();
        strings[2] = br.readLine();

        dp = new int[strings[0].length() + 1][strings[1].length() + 1][strings[2].length() + 1];

        for (int i = 1; i <= strings[0].length(); i++) {
            for (int j = 1; j <= strings[1].length(); j++) {
                for (int k = 1; k <= strings[2].length(); k++) {
                    // 세 문자열을 순회하면서 charAt(i) == charAt(j) == charAt(k) 인 지점을 찾음
                    if (strings[0].charAt(i - 1) == strings[1].charAt(j - 1) && strings[1].charAt(j - 1) == strings[2].charAt(k - 1))
                        dp[i][j][k] = dp[i - 1][j - 1][k - 1] + 1;
                    else
                        //이전 값 중에 최대값을 갱신
                        dp[i][j][k] = Math.max(dp[i - 1][j][k], Math.max(dp[i][j - 1][k], dp[i][j][k - 1]));
                }
            }
        }

        System.out.println(dp[strings[0].length()][strings[1].length()][strings[2].length()]);
    }
}

/*

 */
