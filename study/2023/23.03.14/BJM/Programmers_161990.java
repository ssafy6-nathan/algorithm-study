package week49;

import java.util.Arrays;

/**
 * 프로그래머스 161990번
 * 바탕화면 정리
 * (https://school.programmers.co.kr/learn/courses/30/lessons/161990)
 **/

public class Programmers_161990 {
    public static void main(String[] args) {
        String[][] wallpaper = {{".#...", "..#..", "...#."},
                {"..........", ".....#....", "......##..", "...##.....", "....#....."},
                {".##...##.", "#..#.#..#", "#...#...#", ".#.....#.", "..#...#..", "...#.#...", "....#...."},
                {"..", "#."}};

        for (String[] strings : wallpaper)
            System.out.println(Arrays.toString(solution(strings)));
    }

    public static int[] solution(String[] wallpaper) {
        int[] answer = new int[4];
        // r, c 최소값, 최대값
        int minRow = 51;
        int minCol = 51;
        int maxRow = -1;
        int maxCol = -1;

        // 1. 탐색
        for (int i = 0; i < wallpaper.length; i++) {
            for (int j = 0; j < wallpaper[i].length(); j++) {
                char c = wallpaper[i].charAt(j); // 현재 문자 확인
                if (c == '#') {
                    if (i < minRow) minRow = i;
                    if (i > maxRow) maxRow = i;
                    if (j < minCol) minCol = j;
                    if (j > maxCol) maxCol = j;
                }
            }
        }
        
        // 2. 좌표값 입력
        answer[0] = minRow;
        answer[1] = minCol;
        answer[2] = maxRow + 1;
        answer[3] = maxCol + 1;
        return answer;
    }
}
