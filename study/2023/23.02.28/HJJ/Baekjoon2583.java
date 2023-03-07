package study.nathan_algo_study.week48;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 문제이름 : 영역 구하기
 * 링크 : https://www.acmicpc.net/problem/2583
 */

public class Baekjoon2583 {
    static int N, M, K;
    static boolean[][] map;
    static int[][] dir = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
    static boolean[][] v;
    static int cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new boolean[N][M];
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());

            int y1 = Integer.parseInt(st.nextToken());
            int x1 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());

            makeRectangle(x1, y1, x2, y2);
        }

        List<Integer> result = new ArrayList<>();
        v = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (v[i][j] || map[i][j])
                    continue;

                cnt = 0;
                dfs(i, j);
                result.add(cnt);
            }
        }
        Collections.sort(result);
        bw.write(result.size()+"\n");
        for (int i : result)
            bw.write(i+" ");
        bw.close();

    }

    public static void makeRectangle(int x1, int y1, int x2, int y2) {
        for (int i = x1; i < x2; i++) {
            for (int j = y1; j < y2; j++) {
                map[i][j] = true;
            }
        }
    }

    public static void dfs(int r, int c) {
        v[r][c] = true;
        cnt++;

        for (int i = 0; i < dir.length; i++) {
            int dr = r + dir[i][0];
            int dc = c + dir[i][1];

            if (dr < 0 || dr >= N || dc < 0 || dc >= M || map[dr][dc] || v[dr][dc])
                continue;

            dfs(dr, dc);
        }
    }
}

/*

 */
