package study.nathan_algo_study.week27;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 문제이름 : 성곽
 * 링크 : https://www.acmicpc.net/problem/2234
 */

public class Baekjoon2234 {
    //왼쪽 1, 위쪽 2, 오른쪽 4, 아래쪽 8
    static int N, M;
    static int[][] dir = {{0, -1}, {-1, 0}, {0, 1}, {1, 0}};    //왼쪽 위쪽 오른쪽 아래쪽
    static int[][] map;
    static boolean[][] v;
    static int size;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[M][N];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++)
                map[i][j] = Integer.parseInt(st.nextToken());
        }

        v = new boolean[M][N];
        int maxRoomSize = 0;
        int roomCnt = 0;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (v[i][j])
                    continue;

                size = 0;
                roomCnt++;
                dfs(i,j);
                maxRoomSize = Math.max(size, maxRoomSize);
            }
        }

        System.out.println(roomCnt);
        System.out.println(maxRoomSize);

    }

    public static void dfs(int r, int c) {
        v[r][c] = true;
        size++;

        for (int i = 0; i < dir.length; i++) {
            int dr = r + dir[i][0];
            int dc = c + dir[i][1];

            if (dr < 0 || dr >= M || dc < 0 || dc >= N || v[dr][dc] || (map[r][c] & (1 << i)) > 0)
                continue;

            dfs(dr,dc);
        }
    }
}

/*
8 4 2 1

1 1 0 1


 */
