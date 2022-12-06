package study.nathan_algo_study.week3;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 문제이름 : 벽 부수고 이동하기
 * 링크 : https://www.acmicpc.net/problem/2206
 */

public class Baekjoon2206 {
    static int N, M;
    static int[][] map;
    static int[][] dir = {{0,1},{1,0},{0,-1},{-1,0}}; //오른쪽 아래 위
    static int minCnt;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = input.charAt(j) - 48;
            }
        }

        bfs(0, 0);
        System.out.println(minCnt);
        br.close();

    }

    public static void bfs(int startR, int startC) {
        Queue<int[]> q = new LinkedList<>();
        boolean[][][] v = new boolean[N][M][2];

        q.add(new int[]{startR, startC, 1, 0});
        v[startR][startC][0] = true;
        minCnt = -1;

        while (!q.isEmpty()) {
            int[] item = q.poll();
            int r = item[0];
            int c = item[1];
            int cnt = item[2];
            int destroyCnt = item[3];

            if (r == N-1 && c == M-1) {
                minCnt = cnt;
                break;
            }

            for (int i = 0; i < dir.length; i++) {
                int dr = r + dir[i][0];
                int dc = c + dir[i][1];
                int curDestroyCnt = destroyCnt;

                if (dr < 0 || dr >= N || dc < 0 || dc >= M || v[dr][dc][curDestroyCnt] || (map[dr][dc] == 1 && curDestroyCnt == 1))
                    continue;

                if (map[dr][dc] == 1 && curDestroyCnt == 0)    //한번도 벽을 안만났으면
                    curDestroyCnt = 1;

                q.add(new int[]{dr, dc, cnt + 1, curDestroyCnt});
                v[dr][dc][curDestroyCnt] = true;
            }
        }

    }
}

/*
7 6
010000
010110
010100
010101
010100
010110
000100



*/
