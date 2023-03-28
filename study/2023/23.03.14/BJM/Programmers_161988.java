package week49;

/**
 * 프로그래머스 161988번
 * 연속 펄스 부분 수열의 합
 * (https://school.programmers.co.kr/learn/courses/30/lessons/161989)
 **/

public class Programmers_161988 {
    public static void main(String[] args) {
        int[] sequence = {2, 3, -6, 1, 3, -1, 2, 4};
        System.out.println(solution(sequence));
    }

    public static long solution(int[] sequence) {
        long answer = 0;
        long[] sum = new long[sequence.length + 1]; // 누적합 계산
        long max = Long.MIN_VALUE; // 최대값 갱신
        long min = Long.MAX_VALUE; // 최소값 갱신
        int pulse = -1;

        // 누적합 계산
        for (int i = 1; i < sum.length ; i++){
            sum[i] = ((long) sequence[i-1] * pulse) + sum[i-1];
            pulse *= -1;
        }

        // 최대값, 최소값 계산
        for (int i = 0; i < sum.length ; i++){
            if(max < sum[i]) max = sum[i];
            if(min > sum[i]) min = sum[i];
        }

        answer = max - min; // 이게 왜 되지?
        return answer;
    }
}
