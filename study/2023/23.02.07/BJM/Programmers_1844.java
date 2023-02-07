package week46;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 프로그래머스 1844번
 * 게임 맵 최단거리
 * (https://school.programmers.co.kr/learn/courses/30/lessons/1844)
 **/
public class Programmers_1844 {
    static int[][] direct = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; // 방향 탐색

    public static void main(String[] args) {
        int[][] maps1 = {{1, 0, 1, 1, 1}, {1, 0, 1, 0, 1}, {1, 0, 1, 1, 1}, {1, 1, 1, 0, 1}, {0, 0, 0, 0, 1}};
        int[][] maps2 = {{1, 0, 1, 1, 1}, {1, 0, 1, 0, 1}, {1, 0, 1, 1, 1}, {1, 1, 1, 0, 0}, {0, 0, 0, 0, 1}};
        System.out.println(solution(maps1));
        System.out.println(solution(maps2));
    }

    public static int solution(int[][] maps) {
        int answer = 0;
        int[][] count = new int[maps.length][maps[0].length]; // 지나간 칸 개수
        bfs(maps, count);

        answer = count[maps.length - 1][maps[0].length - 1];
        if (answer == 0) {
            return -1;
        } else {
            return answer;
        }
    }

    private static void bfs(int[][] maps, int[][] count) {
        count[0][0] = 1; // 출발지점 카운트
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0}); // 출발지점 좌표 큐에 넣기

        while (!queue.isEmpty()) {
            // 현재 방문한 좌표 꺼내기
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];

            // 상하좌우 탐색
            for (int i = 0; i < 4; i++) {
                int nx = x + direct[i][0];
                int ny = y + direct[i][1];

                // 1. 유효한 공간을 넘어가면 무시
                if (nx < 0 || nx >= maps.length || ny < 0 || ny >= maps[0].length)
                    continue;
                // 2. 방문하지 않은 곳이면서 벽이 아닌 경우 방문
                if (count[nx][ny] == 0 && maps[nx][ny] == 1) {
                    count[nx][ny] = count[x][y] + 1; // 지나온 칸 개수 갱신
                    queue.add(new int[]{nx, ny});
                }
            }
        }
    }
}
