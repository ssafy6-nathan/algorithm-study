package study.nathan_algo_study.week6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * 문제이름 : 빛의 경로 사이클
 * 링크 : https://programmers.co.kr/learn/courses/30/lessons/86052
 */

public class Programmers_LightPathCycle {
    static int[][] dir = {{1, 0}, {-1, 0}, {0, -1}, {0, 1}}; //위, 아래, 왼쪽, 오른쪽
    static int[][] turn = {{0, 2, 3}, {1, 3, 2}, {2, 1, 0}, {3, 0, 1}}; //행 : 현재 진행방향, 열: 현재 만난 격자
    static int[][] map;
    static int R, C;
    static int len;

    public static void main(String[] args) {
        Programmers_LightPathCycle p = new Programmers_LightPathCycle();
        p.solution(new String[]{"SL","LR"});
    }

    public int[] solution(String[] grid) {
        R = grid.length;;
        C = grid[0].length();
        map = new int[R][C];

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                char c = grid[i].charAt(j);
                if (c == 'S')
                    map[i][j] = 0;
                else if (c == 'L')
                    map[i][j] = 1;
                else if (c == 'R')
                    map[i][j] = 2;
            }
        }

        ArrayList<Integer> answer = new ArrayList<>();
        boolean[][][] v = new boolean[R][C][dir.length];
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                for (int k = 0; k < dir.length; k++) {
                    if (v[i][j][k])
                        continue;

                    answer.add(dfs(i, j, k, v));
                }
            }
        }

        Collections.sort(answer);

        return answer.stream().mapToInt( i -> i.intValue()).toArray();
    }

    public int dfs(int r, int c, int d, boolean[][][] v) {
        int len = 0;
        int nextD = d;
        int dr = r;
        int dc = c;
        while (!v[dr][dc][nextD]) {
            len++;
            v[dr][dc][nextD] = true;

            nextD = turn[nextD][map[dr][dc]];
            dr = dr + dir[nextD][0];
            dc = dc + dir[nextD][1];

            if (dr < 0)
                dr += R;
            else if (dr >= R)
                dr %= R;

            if (dc < 0)
                dc += C;
            else if (dc >= C)
                dc %= C;
        }

        return len;
    }

    //시간초과가 생긴 코드
    public void dfs2(int r, int c, int d, boolean[][][] v) {
        if (v[r][c][d])
            return;

        v[r][c][d] = true;
        len++;

        int nextD = turn[d][map[r][c]];
        int dr = r + dir[nextD][0];
        int dc = c + dir[nextD][1];

        if (dr < 0)
            dr += R;
        else if (dr >= R)
            dr %= R;

        if (dc < 0)
            dc += C;
        else if (dc >= C)
            dc %= C;

        dfs(dr, dc, nextD, v);
    }

}

/*



 */