package study.nathan_algo_study.week50;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 문제이름 : 미로 탈출
 * 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/159993
 */

public class Programmers_미로탈출 {
    static int[][] dir = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
    static char[][] map;

    public int solution(String[] maps) {
        int answer = -1;
        map = new char[maps.length][];
        for (int i = 0; i < map.length; i++)
            map[i] = maps[i].toCharArray();

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if (map[i][j] == 'S') {
                    answer = bfs(i, j);
                }
            }
        }
        return answer;
    }

    public int bfs(int startR, int startC) {
        Deque<int[]> q = new ArrayDeque<>();
        boolean[][] v = new boolean[map.length][map[0].length];
        q.offer(new int[]{startR, startC, 0});
        v[startR][startC] = true;

        int leverR = -1;
        int leverC = -1;
        int leverCnt = -1;
        while (!q.isEmpty()) {
            int[] item = q.poll();
            int r = item[0];
            int c = item[1];
            int cnt = item[2];
            if (map[r][c] == 'L') {
                leverR = r;
                leverC = c;
                leverCnt = cnt;
                break;
            }

            for (int i = 0; i < dir.length; i++) {
                int dr = r + dir[i][0];
                int dc = c + dir[i][1];

                if (dr < 0 || dr >= map.length || dc < 0 || dc >= map[0].length || v[dr][dc] || map[dr][dc] == 'X')
                    continue;

                q.offer(new int[]{dr, dc, cnt + 1});
                v[dr][dc] = true;
            }
        }

        if (leverCnt == -1)
            return -1;

        q.clear();
        q.offer(new int[]{leverR, leverC, leverCnt});
        v = new boolean[map.length][map[0].length];
        while (!q.isEmpty()) {
            int[] item = q.poll();
            int r = item[0];
            int c = item[1];
            int cnt = item[2];
            if (map[r][c] == 'E') {
                return cnt;
            }

            for (int i = 0; i < dir.length; i++) {
                int dr = r + dir[i][0];
                int dc = c + dir[i][1];

                if (dr < 0 || dr >= map.length || dc < 0 || dc >= map[0].length || v[dr][dc] || map[dr][dc] == 'X')
                    continue;

                q.offer(new int[]{dr, dc, cnt + 1});
                v[dr][dc] = true;
            }

        }

        return -1;
    }
}

/*

 */
