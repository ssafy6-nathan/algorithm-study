package week50;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 프로그래머스 159993번
 * 미로 탈출
 * (https://school.programmers.co.kr/learn/courses/30/lessons/159993)
 **/
public class Programmers_159993 {
    static int[][] direct = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static char[][] map;
    static boolean[][] visit;
    public static void main(String[] args) {
        String[][] maps = {{"SOOOL","XXXXO","OOOOO","OXXXX","OOOOE"},{"LOOXS","OOOOX","OOOOO","OOOOO","EOOOO"}};

        for (int i = 0; i < maps.length; i++)
            System.out.println(solution(maps[i]));
    }

    public static int solution(String[] maps) {
        int answer;
        int startR = 0;
        int startC = 0;

        // 2차원 배열의 map으로 변경
        map = new char[maps.length][maps[0].length()];
        for (int i = 0; i < map.length; i++)
            for (int j = 0; j < map[i].length; j++) {
                map[i][j] = maps[i].charAt(j);
                if(map[i][j] == 'S') {
                    startR = i;
                    startC = j;
                }
            }

        answer = bfs(startR, startC);

        return answer;
    }

    private static int bfs(int startR, int startC) {
        Queue<int[]> queue = new ArrayDeque<>();
        visit = new boolean[map.length][map[0].length];

        // 레버 좌표
        int leverR = -1;
        int leverC = -1;
        int lever_count = -1;

        // 1. S -> L 경로 탐색
        queue.offer(new int[] {startR, startC, 0});
        visit[startR][startC] = true;
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int r = current[0];
            int c = current[1];
            int cnt = current[2];

            if (map[r][c] == 'L') { // 종료 조건 : 레버가 있는 칸일 경우
                leverR = r;
                leverC = c;
                lever_count = cnt;
                break;
            }

            for (int i = 0; i < direct.length; i++) { // 사방 탐색
                int dr = r + direct[i][0];
                int dc = c + direct[i][1];

                if (dr < 0 || dc < 0 || dr >= map.length || dc >= map[0].length || visit[dr][dc] || map[dr][dc] == 'X')
                    continue;

                queue.offer(new int[] {dr, dc, cnt + 1});
                visit[dr][dc] = true;
            }
        }

        if (lever_count == -1) // 만약 레버를 찾지 못한 경우 비정상 종료
            return -1;

        // 2. L -> E 경로 탐색
        queue.clear();
        visit = new boolean[map.length][map[0].length];
        queue.offer(new int[] {leverR, leverC, lever_count});
        visit[leverR][leverC] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int r = current[0];
            int c = current[1];
            int cnt = current[2];

            if (map[r][c] == 'E') // 종료 조건 : 출구가 있는 칸일 경우
                return cnt;

            for (int i = 0; i < direct.length; i++) { // 사방 탐색
                int dr = r + direct[i][0];
                int dc = c + direct[i][1];

                if (dr < 0 || dc < 0 || dr >= map.length || dc >= map[0].length || visit[dr][dc] || map[dr][dc] == 'X')
                    continue;

                queue.offer(new int[] {dr, dc, cnt + 1});
                visit[dr][dc] = true;
            }
        }
        
        return -1; // 출구를 찾지 못한 경우 비정상 종료
    }
}
