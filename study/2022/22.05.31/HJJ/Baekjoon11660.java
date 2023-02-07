package study.nathan_algo_study.week14;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 문제이름 : 구간 합 구하기 5
 * 링크 : https://www.acmicpc.net/problem/11660
 */

public class Baekjoon11660 {
    static int[][] table;
    static int[][] dp;
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        table = new int[N][N];
        dp = new int[N][N];

        int sum;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            sum = 0;
            for (int j = 0; j < N; j++) {
                table[i][j] = Integer.parseInt(st.nextToken());
                sum += table[i][j];
                dp[i][j] = sum;
            }
        }

        int x1, x2, y1, y2, temp;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            x1 = Integer.parseInt(st.nextToken()) - 1;
            y1 = Integer.parseInt(st.nextToken()) - 1;
            x2 = Integer.parseInt(st.nextToken()) - 1;
            y2 = Integer.parseInt(st.nextToken()) - 1;

            if (x1 > x2) {
                temp = x1;
                x1 = x2;
                x2 = temp;
            }

            if (y1 > y2) {
                temp = y1;
                y1 = y2;
                y2 = temp;
            }

            bw.write(prefixSum(x1, y1, x2, y2) + "\n");
        }
        bw.close();
    }

    public static int prefixSum(int minX, int minY, int maxX, int maxY) {
        int sum = 0;
        for (int x = minX; x <= maxX; x++) {
            if (minY != 0)
                sum += dp[x][maxY] - dp[x][minY-1];
            else
                sum += dp[x][maxY];
        }

        return sum;
    }
}

/*

 */
