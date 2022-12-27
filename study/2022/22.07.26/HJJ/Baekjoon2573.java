package study.nathan_algo_study.week22;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 문제이름 : 빙산
 * 링크 : https://www.acmicpc.net/problem/2573
 */

public class Baekjoon2573 {
    static int N, M;
    static int year;
    static int[][] map;
    static int[][] dir = {{0, -1}, {-1, 0}, {0, 1}, {1, 0}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        year = 1;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int group;
        while ((group = searchGroup()) != 0 && group < 2) {
            oneYearLater();
            year++;
        }

        if (group == 0)
            System.out.println(0);
        else
            System.out.println(year - 1);
    }

    public static void oneYearLater() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] > 0) {
                    melt(i, j);
                }
            }
        }

    }

    private static void melt(int r, int c) {
        int cnt = 0;
        for (int i = 0; i < dir.length; i++) {
            int dr = r + dir[i][0];
            int dc = c + dir[i][1];

            if (dr < 0 || dr >= N || dc < 0 || dc >= M || map[dr][dc] > 0 || map[dr][dc] == -year)  //같은 연도에 녹은 빙산도 무시
                continue;

            cnt++;
        }

        if (map[r][c] - cnt > 0)
            map[r][c] -= cnt;
        else
            map[r][c] = -year;  //몇년후에 가라앉은지 기록

    }

    public static int searchGroup() {
        boolean[][] v = new boolean[N][M];
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!v[i][j] && map[i][j] > 0) {
                    dfs(i, j, v);
                    cnt++;
                }
            }
        }

        return cnt;
    }

    private static void dfs(int r, int c, boolean[][] v) {
        v[r][c] = true;

        for (int i = 0; i < dir.length; i++) {
            int dr = r + dir[i][0];
            int dc = c + dir[i][1];

            if (dr < 0 || dr >= N || dc < 0 || dc >= M || v[dr][dc] || map[dr][dc] <= 0)
                continue;

            dfs(dr, dc, v);
        }
    }
}

/*

 */
