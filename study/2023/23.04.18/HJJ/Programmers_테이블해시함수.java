package study.nathan_algo_study.week53;

import java.util.Arrays;

/**
 * 문제이름 : 테이블 해시 함수
 * 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/147354
 */

public class Programmers_테이블해시함수 {
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        Arrays.sort(data, (o1, o2) ->
                (o1[col - 1] == o2[col - 1]) ? o2[0] - o1[0] : o1[col - 1] - o2[col - 1]);

        int answer = sum(data[row_begin-1], row_begin);
        for (int i = row_begin; i < row_end; i++) {
            answer ^= sum(data[i], i+1);
        }

        return answer;
    }

    public int sum(int[] data, int i) {
        int result = 0;
        for(int n : data) {
            result += n % i;
        }

        return result;
    }
}

/*

 */
