package week49;

import java.util.Arrays;

/**
 * 프로그래머스 161990번
 * 덧칠하기
 * (https://school.programmers.co.kr/learn/courses/30/lessons/161989)
 **/
public class Programmers_161989 {
    public static void main(String[] args) {
        int[] n = {8, 5, 4};
        int[] m = {4, 4, 1};
        int[][] section = {{2, 3, 6}, {1, 3}, {1, 2, 3, 4}};

        for (int i = 0; i < n.length; i++) {
            System.out.println(solution(n[i], m[i], section[i]));
        }
    }

    public static int solution(int n, int m, int[] section) {
        int answer = 0;

        // 1. 훼손된 벽 정보 저장
        boolean[] wall = new boolean[n];
        Arrays.fill(wall, true);
        for (int i = 0; i < section.length; i++)
            wall[section[i] - 1] = false;
        
        // 2. 페인트 칠하기
        for (int i = 0; i < wall.length; i++) {
            if(!wall[i]) { // 훼손된 벽을 만날 때 마다 페인트 칠
                for (int j = 0; j < m; j++) {
                    if (i+j < wall.length)
                        wall[i+j] = true;
                }
                answer++;
            }
        }

        return answer;
    }
}
