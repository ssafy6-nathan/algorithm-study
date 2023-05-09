package study.nathan_algo_study.week55;

import java.util.Arrays;

/**
 * 문제이름 : 연속된 부분 수열의 합
 * 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/178870
 */

public class Programmers_연속된부분수열의합 {
    public static void main(String[] args) {
        Programmers_연속된부분수열의합 p = new Programmers_연속된부분수열의합();
        System.out.println(Arrays.toString(p.solution(new int[]{1, 1, 1, 1, 1, 1, 1}, 7)));

    }

    public int[] solution(int[] sequence, int k) {
        int start = 0;
        int end = -1;
        int sum = 0;
        int minLen = sequence.length + 1;
        int minStart = -1;
        int minEnd = -1;

        while (true) {

            if (sum < k) {
                end++;
                if (end >= sequence.length)
                    break;
                sum += sequence[end];
            } else {    //크면 start++
                sum -= sequence[start];
                if (start >= sequence.length)
                    break;
                start++;
            }

            if (sum == k) {
                int len = end - start + 1;
                if (len < minLen) {
                    minLen = len;
                    minStart = start;
                    minEnd = end;
                }

            }
        }
        int[] answer = {minStart, minEnd};
        return answer;
    }
}

/*
1 2 3 4 5

1
1 2
1 2 3
1 2 3 4
2 3 4
3 4 = 2 len
4 5
5

5 6 7 8,  k = 5

5 len = 1
5 6
6


 */
