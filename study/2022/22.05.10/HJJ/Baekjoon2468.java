package study.nathan_algo_study.week11;

import java.io.*;
import java.util.*;

/**
 * 문제이름 : 안전 영역
 * 링크 : https://www.acmicpc.net/problem/2468
 */

public class Baekjoon2468 {
    static int N;
    static int[][] map;
    static int[][] dir = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
    static boolean[][] v;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        HashSet<Integer> rainLen = new HashSet<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int n = Integer.parseInt(st.nextToken());
                map[i][j] = n;
                rainLen.add(n);
            }
        }
        rainLen.add(0); //비가 오지 않는 경우 고려

        int maxCnt = 0;
        int cnt;
        for (int rain : rainLen) {
            v = new boolean[N][N];
            cnt = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (v[i][j] || map[i][j] <= rain)
                        continue;

                    dfs(i,j,rain);
                    cnt++;
                }
            }

            maxCnt = Math.max(cnt, maxCnt);
        }

        System.out.println(maxCnt);
    }

    static void dfs(int r, int c, int rain) {
        v[r][c] = true;

        for (int i = 0; i < dir.length; i++) {
            int dr = r + dir[i][0];
            int dc = c + dir[i][1];

            if (dr < 0 || dr >= N || dc < 0 || dc >= N || v[dr][dc] || map[dr][dc] <= rain)
                continue;

            dfs(dr,dc,rain);
        }
    }
}

/*


 */
