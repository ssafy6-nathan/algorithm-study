package week42;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 백준 1915번
 * 가장 큰 정사각형 (https://www.acmicpc.net/problem/1915)
 * 분류 : 다이나믹 프로그래밍
 **/
public class BOJ_1915 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int answer = 0;
        char[][] arr = new char[n][];
        // 1. 원본 배열 채우기
        for (int i = 0; i < arr.length; i++) {
            arr[i] = br.readLine().toCharArray();
        }

        // 2. DP 배열 선언 (arr 배열의 0,0부터 계산하기 위해 마진 생성)
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[i].length; j++) {
                // arr 배열의 값이 1인 경우
                // 좌상단, 좌단, 상단의 값을 확인하여 (세 값중 가장 작은 값 + 1)을 저장
                if (arr[i - 1][j - 1] == '1') {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j - 1], dp[i][j - 1]), dp[i - 1][j]) + 1;
                    answer = Math.max(dp[i][j], answer); // 정사각형 크기 갱신
                } else {
                    dp[i][j] = 0;
                }
            }
        }
        System.out.println(answer * answer);
    }
}
