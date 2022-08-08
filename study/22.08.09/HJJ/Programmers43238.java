package study.nathan_algo_study.week24;

import java.util.Arrays;

/**
 * 문제이름 : 입국심사
 * 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/43238
 */

public class Programmers43238 {
    public long solution(int n, int[] times) {
        long answer = 0;
        Arrays.sort(times);
        long left = 0;
        long right = (long) n * times[times.length - 1];

        while (left <= right) {
            long mid = (left + right) / 2;
            long people = 0;

            for (int i = 0; i < times.length;i++) {
                people += mid / times[i];
            }

            if (people < n) //해야할 인원보다 처리 못하면 시간 더 늘림
                left = mid + 1;
            else {  // 해야할 인원보다 처리 많이 하면 시간 더 줄여봄
                right = mid - 1;
                answer = mid;
            }
        }

        return answer;
    }
}

/*

*/
