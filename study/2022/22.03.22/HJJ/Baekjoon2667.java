package study.nathan_algo_study.week4;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

/**
 * 문제이름 : 단자번호붙이기
 * 링크 : https://www.acmicpc.net/problem/2667
 */

public class Baekjoon2667 {
    static int[][] map;
    static int[][] dir = {{0, -1}, {-1, 0}, {0, 1}, {1, 0}};
    static int N;
    static int cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < N; j++)
                map[i][j] = input.charAt(j) - 48;
        }

        boolean[][] v = new boolean[N][N];
        ArrayList<Integer> houseCnts = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 0 || v[i][j])
                    continue;
                cnt = 0;
                dfs(i, j, v);
                houseCnts.add(cnt);
            }
        }

        Collections.sort(houseCnts);

        bw.write(houseCnts.size() + "\n");
        for (Integer i : houseCnts)
            bw.write(i+"\n");
        br.close();
        bw.close();
    }

    public static void dfs(int row, int col, boolean[][] v) {
        v[row][col] = true;
        cnt++;
        for (int i = 0; i < dir.length; i++) {
            int dr = row + dir[i][0];
            int dc = col + dir[i][1];

            if (dr < 0 || dr >= N || dc < 0 || dc >= N || v[dr][dc] || map[dr][dc] == 0)
                continue;

            dfs(dr, dc, v);
        }
    }
}

/*

 */
