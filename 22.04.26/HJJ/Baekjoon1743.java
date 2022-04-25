package study.nathan_algo_study.week9;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 문제이름 : 음식물피하기
 * 링크 : https://www.acmicpc.net/problem/1743
 */

public class Baekjoon1743 {
    static int[][] map;
    static int N, M, K;
    static int cnt;
    static boolean[][] v;
    static int[][] dir = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;
            map[r][c] = 1;
        }

        v = new boolean[N][M];
        int maxCnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0 || v[i][j])
                    continue;

                cnt = 0;
                dfs(i,j);
                maxCnt = Math.max(cnt, maxCnt);
            }
        }

        System.out.println(maxCnt);

    }

    public static void dfs(int r, int c) {
        v[r][c] = true;
        cnt++;

        for (int i = 0; i < dir.length; i++) {
            int dr = r + dir[i][0];
            int dc = c + dir[i][1];

            if (dr < 0 || dr >= N || dc < 0 || dc >= M || map[dr][dc] == 0 || v[dr][dc])
                continue;

            dfs(dr,dc);
        }
    }
}

/*

 */
