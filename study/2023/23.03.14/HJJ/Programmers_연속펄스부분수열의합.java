package study.nathan_algo_study.week49;

/**
 * 문제이름 : 연속 펄스 부분 수열의 합
 * 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/161988
 */

public class Programmers_연속펄스부분수열의합 {
    public long solution(int[] sequence) {

        return cal(sequence, -1);
    }

    public long cal(int[] sequence, int pulse) {
        int n = sequence.length;
        long[] prefixSum = new long[n + 1];
        long max = Long.MIN_VALUE;
        long min = Long.MAX_VALUE;
        long pulseValue;
        for (int i = 1; i <= n; i++) {
            pulseValue = (long) pulse * sequence[i - 1];
            pulse *= -1;

            prefixSum[i] = pulseValue + prefixSum[i - 1];

            max = Math.max(max, prefixSum[i]);
            min = Math.min(min, prefixSum[i]);
        }

        max = Math.max(max, prefixSum[0]);
        min = Math.min(min, prefixSum[0]);

        return max - min;
    }
}

/*
0 1  2 3 4  5 6 7
2 3 -6 1 3 -1 2 4

-2 3 6 1 -3 -1 -2 4
-2 1 7 8 5 4 2 6

2 -3 -6 -1 3 1 2 -4
2 -1 -7 -8 -5 -4 -2 -6

2 5 -1 2 5 4 6 10




-2 5 1 2 -5 4 -6 10
2 -5 -1 -2 5 -4 6 -10



*/
