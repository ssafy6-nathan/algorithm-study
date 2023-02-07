package study.nathan_algo_study.week46;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 문제이름 : 게임맵최단거리
 * 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/1844
 */

public class Programmers_게임맵최단거리 {
    static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int solution(int[][] maps) {
        Deque<int[]> q = new ArrayDeque<>();
        boolean[][] v = new boolean[maps.length][maps[0].length];
        q.offer(new int[]{0, 0, 1});
        v[0][0] = true;

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int currX = curr[0];
            int currY = curr[1];
            int currCnt = curr[2];

            if (currX == maps.length - 1 && currY == maps[0].length - 1)
                return currCnt;

            for (int i = 0; i < dir.length; i++) {
                int nextX = currX + dir[i][0];
                int nextY = currY + dir[i][1];

                if (nextX < 0 || nextX >= maps.length || nextY < 0 || nextY >= maps[0].length || v[nextX][nextY] || maps[nextX][nextY] == 0)
                    continue;

                v[nextX][nextY] = true;
                q.offer(new int[]{nextX, nextY, currCnt + 1});
            }
        }

        return -1;
    }
}

/*

 */
