package week48;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 백준 14430번
 * 자원 캐기 (https://www.acmicpc.net/problem/14430)
 * 분류 : 다이나믹 프로그래밍
 **/
public class BOJ_14430 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // 1. 원본 배열 채우기
        int[][] map = new int[N][M];
        for (int i = 0; i < map.length; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < map[i].length; j++)
                map[i][j] = Integer.parseInt(st.nextToken());
        }

        // 2. DP 배열 채우기
        int[][] dp = new int[N+1][M+1];
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[i].length; j++) {
                if(map[i-1][j-1] == 1) dp[i][j]++;
                dp[i][j] += Math.max(dp[i][j-1], dp[i-1][j]);
             }
        }
        System.out.println(dp[N][M]);
    }
}
