package study.nathan_algo_study.week8;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 문제이름 : 움직이는 미로 탈출
 * 링크 : https://www.acmicpc.net/problem/16954
 */

public class Baekjoon16954 {
    static int N = 8;
    static int[][] map;
    static int[][] dir = {{0, 0}, {0, -1}, {-1, -1}, {-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        map = new int[N][N];
        String line;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            line = st.nextToken();
            for (int j = 0; j < N; j++) {
                if (line.charAt(j) == '#')
                    map[i][j] = 1;
            }
        }

        if (bfs())
            System.out.println(1);
        else
            System.out.println(0);


    }

    public static boolean bfs() {
        Queue<int[]> q = new LinkedList<>();
        boolean[][] v = new boolean[N][N];
        int prevLen = 0;
        q.add(new int[]{7, 0, prevLen});
        v[7][0] = true;
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int r = curr[0];
            int c = curr[1];
            int len = curr[2];

            if (r == 0) //맨 위에 도달했으면 성공
                return true;

            if (len > prevLen) {    //이동한 거리가 이전 거리보다 크면
                moveMap();  //맵 아래로 한칸씩 옮김
                prevLen = len;
            }

            if (map[r][c] == 1)
                continue;

            for (int i = 0; i < dir.length; i++) {
                int dr = r + dir[i][0];
                int dc = c + dir[i][1];

                if (dr < 0 || dr >= N || dc < 0 || dc >= N || map[dr][dc] == 1)
                    //움직이는 좌표가 범위를 벗어나는지 벽인지 확인
                    continue;

                if ((!(dr == r && dc == c) && v[dr][dc]) || (dr > 0 && map[dr-1][dc] == 1))
                    //이미 방문한 곳인지(제자리에 멈추는 건 방문했어도 가능), 이동하는 좌표의 바로 위칸이 벽인지 확인
                    continue;

                q.add(new int[]{dr, dc, len + 1});
                v[dr][dc] = true;
            }

        }

        return false;
    }

    public static void moveMap() {
        for (int i = N - 2; i >= 0; i--)
            for (int j = 0; j < N; j++)
                map[i + 1][j] = map[i][j];

        for (int i = 0; i < N; i++)
            map[0][i] = 0;
    }
}

/*
좌 좌상 상 우상 우
좌하 하 우하


*/
