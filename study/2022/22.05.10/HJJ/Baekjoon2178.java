package study.nathan_algo_study.week11;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 문제이름 : 미로 탐색
 * 링크 : https://www.acmicpc.net/problem/2178
 */

public class Baekjoon2178 {
    static int N, M;
    static char[][] map;
    static int[][] dir = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        for (int i = 0; i < N; i++)
            map[i] = br.readLine().toCharArray();

        System.out.println(bfs());
    }

    public static int bfs() {
        Queue<int[]> q = new LinkedList<>();
        boolean[][] v = new boolean[N][M];

        q.add(new int[]{0,0,1});
        v[0][0] = true;

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int r = curr[0];
            int c = curr[1];
            int cnt = curr[2];

            if (r == N-1 && c == M-1)
                return cnt;

            for (int i = 0; i < dir.length; i++) {
                int dr = r + dir[i][0];
                int dc = c + dir[i][1];

                if (dr < 0 || dr >= N || dc < 0 || dc >= M || v[dr][dc] || map[dr][dc] == '0')
                    continue;

                q.add(new int[]{dr,dc,cnt+1});
                v[dr][dc] = true;
            }
        }

        return -1;
    }
}

/*

 */
