package study.nathan_algo_study.week1;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 문제이름 : 아기상어2
 * 링크 : https://www.acmicpc.net/problem/17086
 */

public class Baekjoon17086 {
    static int maxLen;
    static int N, M;
    static int[][] map;
    static int[][] dir = {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 0}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        maxLen = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) 
                map[i][j] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < N; i++) 
            for (int j = 0; j < M; j++)
                if (map[i][j] == 0) 
                    bfs(i,j);
                

        System.out.println(maxLen);
    }

    public static void bfs(int startR, int startC) {
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[N][M];

        q.add(new int[]{startR, startC, 0});
        visited[startR][startC] = true;

        while (!q.isEmpty()) {
            int[] item = q.poll();
            int r = item[0];
            int c = item[1];
            int len = item[2];

            if (map[r][c] == 1) {   //아기상어를 만나면
                if (len > maxLen)
                    maxLen = len;
                return;
            }

            for (int i = 0; i < dir.length; i++) {
                int dr = r + dir[i][0];
                int dc = c + dir[i][1];

                if (dr < 0 || dr >= N || dc < 0 || dc >= M || visited[dr][dc])
                    continue;

                q.add(new int[]{dr, dc, len + 1});
                visited[dr][dc] = true;
            }
        }
    }
}

/*


 */
