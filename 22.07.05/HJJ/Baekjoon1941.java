package study.nathan_algo_study.week19;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 문제이름 : 소문난 칠공주
 * 링크 : https://www.acmicpc.net/problem/1941
 */

public class Baekjoon1941 {
    static final int N = 5;
    static int[][] dir = {{0, -1}, {-1, 0}, {0, 1}, {1, 0}};
    static char[][] map;
    static boolean[][] checked;
    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        map = new char[N][];
        for (int i = 0; i < N; i++)
            map[i] = br.readLine().toCharArray();

        result = 0;
        combi(0, 0, new int[7]);
        System.out.println(result);

    }

    public static void combi(int cnt, int start, int[] c) {
        if (cnt == 7) {
            int somCnt = 0;
            for (int i = 0; i < c.length; i++) {
                if (map[c[i] / 5][c[i] % 5] == 'S')
                    somCnt++;
            }
            if (somCnt >= 4)
                bfs(c);
            return;
        }

        for (int i = start; i < 25; i++) {
            c[cnt] = i;
            combi(cnt + 1, i + 1, c);
        }
    }

    public static void bfs(int[] pos) {
        Queue<int[]> q = new LinkedList<>();
        initVisited(pos);
        q.add(new int[]{pos[0] / 5, pos[0] % 5});
        checked[pos[0] / 5][pos[0] % 5] = false;
        int[] curr;
        int searchCnt = 0;
        while (!q.isEmpty()) {
            searchCnt++;
            curr = q.poll();
            int r = curr[0];
            int c = curr[1];

            for (int i = 0; i < dir.length; i++) {
                int dr = r + dir[i][0];
                int dc = c + dir[i][1];

                if (dr < 0 || dr >= 5 || dc < 0 || dc >= 5 || !checked[dr][dc])
                    continue;

                checked[dr][dc] = false;
                q.add(new int[]{dr, dc});
            }
        }

        if (searchCnt == 7)
            result++;
    }

    public static void initVisited(int[] pos) {
        checked = new boolean[N][N];
        for (int i = 0; i < pos.length; i++) {
            int r = pos[i] / 5;
            int c = pos[i] % 5;

            checked[r][c] = true;
        }
    }
}

/*
0 1 2 3 4
5 6 7 8 9
10 11 12 13 14
15 16 17 18 19
20 21 22 23 24


*/
