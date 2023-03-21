package study.nathan_algo_study.week49;

/**
 * 문제이름 : 바탕화면 정리
 * 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/161990
 */

public class Programmers_바탕화면정리 {
    public int[] solution(String[] wallpaper) {
        int maxX = 0;
        int minX = 51;
        int maxY = 0;
        int minY = 51;

        for (int i = 0; i < wallpaper.length; i++) {
            for (int j = 0; j < wallpaper[i].length(); j++) {
                if (wallpaper[i].charAt(j) == '.')
                    continue;

                maxX = Math.max(maxX, i);
                minX = Math.min(minX, i);
                maxY = Math.max(maxY, j);
                minY = Math.min(minY, j);
            }
        }

        int[] answer = {minX, minY, maxX + 1, maxY + 1};

        return answer;
    }
}

/*
01000
00100
00010

0000000000
0000010000
0000001100
0001100000
0000100000

1,5
2,6 2,7
3,3 3,4
4,4

1,3
5,8
*/
