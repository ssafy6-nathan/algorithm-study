package week46;

/**
 * 프로그래머스 86491번
 * 최소직사각형
 * (https://school.programmers.co.kr/learn/courses/30/lessons/86491)
 **/
public class Programmers_86491 {
    public static void main(String[] args) {
        int[][][] sizes = {{{60, 50}, {30, 70}, {60, 30}, {80, 40}},
                {{10, 7}, {12, 3}, {8, 15}, {14, 7}, {5, 15}},
                {{14, 4}, {19, 6}, {6, 16}, {18, 7}, {7, 11}}};

        for (int[][] size : sizes) {
            System.out.println(solution(size));
        }
    }

    public static int solution(int[][] sizes) {
        int answer;
        int max_X = 0;
        int max_Y = 0;
        for (int i = 0; i < sizes.length; i++) {
            // 1. 가로 세로를 비교하여 더 긴 치수를 앞쪽에 배치
            if (sizes[i][0] < sizes[i][1]) {
                int temp = sizes[i][0];
                sizes[i][0] = sizes[i][1];
                sizes[i][1] = temp;
            }

            // 2. 최대 가로세로 길이 갱신
            if (sizes[i][0] > max_X)
                max_X = sizes[i][0];
            if (sizes[i][1] > max_Y)
                max_Y = sizes[i][1];
        }
        answer = max_X * max_Y;
        return answer;
    }
}
