package study.nathan_algo_study.week44;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 문제이름 : 백룸
 * 링크 : https://www.acmicpc.net/problem/
 */

public class Baekjoon26259 {
    static int N, M;
    static int[][] map;
    static int[][] dp;
    static int x1, y1, x2, y2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());



        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N + 1][M + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= M; j++)
                map[i][j] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        x1 = Integer.parseInt(st.nextToken());
        y1 = Integer.parseInt(st.nextToken());
        x2 = Integer.parseInt(st.nextToken());
        y2 = Integer.parseInt(st.nextToken());

        boolean isRow = x1 == x2;

        if (isPossible(isRow)) {
            x1++;
            x2++;
            y1++;
            y2++;
            dp = new int[N + 1][M + 1];
            for (int i = 0; i < N+1; i++) {
                Arrays.fill(dp[i],-1000);
            }

            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= M; j++) {
                    if (i == 1 && j == 1)
                        dp[i][j] = map[i][j];
                    else if (isRow && i == x1 && j >= y1 && j < y2) {   //가로벽이 존재하고 현재 탐색중인 좌표 위에 벽이 있으면
                        if (dp[i][j - 1] == 0)
                            continue;
                        dp[i][j] = dp[i][j - 1] + map[i][j];
                    } else if (!isRow && j == y1 && i >= x1 && i < x2) {   //세로벽이 존재하고 현재 탐색중인 좌표 왼쪽에 벽이 있으면
                        if (dp[i - 1][j] == 0)
                            continue;
                        dp[i][j] = dp[i - 1][j] + map[i][j];
                    } else {
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]) + map[i][j];
                    }
                }
            }
            System.out.println(dp[N][M]);
        } else {
            System.out.println("Entity");
        }

    }

    public static boolean isPossible(boolean isRow) {
        if (isRow) {
            if (y1 > y2) {  //y1이 더 크면 스왑
                int temp = y1;
                y1 = y2;
                y2 = temp;
            }

            if ((y1 == 0 && y2 == M) && !(x1 == 0 || x1 == N)) //y가 M과 길이가 같고 x가 0 또는 N이 아니면
                return false;

        } else {
            if (x1 > x2) {  //x1이 더 크면 스왑
                int temp = x1;
                x1 = x2;
                x2 = temp;
            }

            if ((x1 == 0 && x2 == N) && !(y1 == 0 || y1 == M))  //x가 N과 길이가 같고 y가 0 또는 M이 아니면
                return false;
        }

        return true;
    }

}

/*
4 4
1 2 8 7
3 2 1 4
7 8 2 1
2 6 2 1
2 4 4 4
 */
