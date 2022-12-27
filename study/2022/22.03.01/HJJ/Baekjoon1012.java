package study.nathan_algo_study.week1;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 문제이름 : 유기농 배추
 * 링크 : https://www.acmicpc.net/problem/1012
 */

public class Baekjoon1012 {

    static int M, N, K;
    static int[][] map;
    static boolean[][] v;
    static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int tc = Integer.parseInt(br.readLine());
        for (int t = 0; t < tc; t++) {
            st = new StringTokenizer(br.readLine());

            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            map = new int[M][N];
            v = new boolean[M][N];
            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());

                int r = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                map[r][c] = 1;
            }
            int count = 0;
            for (int i = 0; i < M; i++) {
                for (int j = 0; j < N; j++) {
                    if (map[i][j] == 1 && !v[i][j]) {
                        dfs(i,j);
                        count++;
                    }
                }
            }
            bw.write(count+"\n");
        }
        bw.close();
    }

    public static void dfs(int r, int c) {
        v[r][c] = true;

        for (int d = 0; d < dir.length; d++) {
            int dr = r + dir[d][0];
            int dc = c + dir[d][1];

            if (dr < 0 || dr >= M || dc < 0 || dc >= N || map[dr][dc] == 0 || v[dr][dc])
                continue;

            dfs(dr,dc);
        }
    }
}

/*

 */
