package study.nathan_algo_study.week24;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 문제이름 : 거리두기 확인하기
 * 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/81302
 */

public class Programmers81302 {
    static int[][] dir = {{0, -1}, {-1, 0}, {0, 1}, {1, 0}};

    public int[] solution(String[][] places) {
        int[] answer = new int[5];
        boolean isGoodDistance;
        for (int i = 0; i < places.length; i++) {
            isGoodDistance = true;
            loop:
            for (int j = 0; j < places[i].length; j++) {
                for (int k = 0; k < places[i][j].length(); k++) {
                    if (places[i][j].charAt(k) == 'P') {
                        if (!bfs(places[i],j,k)) {
                            isGoodDistance = false;
                            break loop;
                        }
                    }
                }
            }
            answer[i] = (isGoodDistance)? 1 : 0;
        }

        return answer;
    }

    public boolean bfs(String[] map, int startR, int startC) {
        Queue<int[]> q = new LinkedList<>();
        boolean[][] v = new boolean[5][5];

        q.add(new int[]{startR, startC, 0});
        v[startR][startC] = true;

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int r = curr[0];
            int c = curr[1];
            int cnt = curr[2];

            if (!(r == startR && c == startC) && map[r].charAt(c) == 'P')
                return false;

            if (cnt == 2)
                continue;

            for (int i = 0; i < dir.length; i++) {
                int dr = r + dir[i][0];
                int dc = c + dir[i][1];

                if (dr < 0 || dr >= 5 || dc < 0 || dc >= 5 || v[dr][dc] || map[dr].charAt(dc) == 'X')
                    continue;

                q.add(new int[]{dr, dc, cnt+1});
                v[dr][dc] = true;
            }
        }

        return true;
    }
}

/*

 */
