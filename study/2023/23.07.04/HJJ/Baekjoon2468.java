package study.nathan_algo_study.week60;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

/**
 * 문제이름 : 안전 영역
 * 링크 : https://www.acmicpc.net/problem/2468
 */

public class Baekjoon2468 {
    static int[][] map;
    static int[][] dir = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        int max = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                max = Math.max(max, map[i][j]);
            }
        }

        boolean[][] v;
        int cnt;
        int maxCnt = 0;
        for (int i = 0; i < max; i++) {
            cnt = 0;
            v = new boolean[N][N];
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    if (v[j][k] || map[j][k] <= i)
                        continue;

                    bfs(j, k, i, v);
                    cnt++;
                }
            }

            maxCnt = Math.max(maxCnt, cnt);
        }

        System.out.println(maxCnt);
    }

    public static void bfs(int r, int c, int cutline, boolean[][] v) {
        Deque<int[]> q = new ArrayDeque<>();

        q.offer(new int[]{r, c});
        v[r][c] = true;

        while (!q.isEmpty()) {
            int[] item = q.poll();
            int currR = item[0];
            int currC = item[1];

            for (int i = 0; i < dir.length; i++) {
                int dr = currR + dir[i][0];
                int dc = currC + dir[i][1];

                if (dr < 0 || dr >= N || dc < 0 || dc >= N || v[dr][dc] || map[dr][dc] <= cutline)
                    continue;

                q.offer(new int[]{dr, dc});
                v[dr][dc] = true;
            }
        }
    }
}

/*

 */
