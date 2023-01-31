package study.nathan_algo_study.week45;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 문제이름 : 단속카메라
 * 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/42884
 */

public class Programmers_단속카메라 {
    public int solution(int[][] routes) {
        Arrays.sort(routes, Comparator.comparingInt(o -> o[1]));

        int cnt = 0;
        int cctv = -30001;
        for (int[] route : routes) {
            if (route[0] <= cctv && cctv <= route[1]) {
                continue;
            }

            cctv = route[1];
            cnt++;
        }

        return cnt;
    }
}

/*
-15
-13
-5
-3




 */
