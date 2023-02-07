package week41;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 프로그래머스 118667번
 * 두 큐 합 같게 만들기
 * (https://school.programmers.co.kr/learn/courses/30/lessons/118667)
 **/
public class Programmers_118667 {
    public static void main(String[] args) {
        int[][] queue1 = {{3, 2, 7, 2}, {1, 2, 1, 2}, {1, 1}};
        int[][] queue2 = {{4, 6, 5, 1}, {1, 10, 1, 2,}, {1, 5}};
        for (int i = 0; i < queue1.length; i++) {
            System.out.println(solution(queue1[i], queue2[i]));
        }
    }

    public static int solution(int[] queue1, int[] queue2) {
        int count = 0; // pop, insert 횟수
        long target = 0; // 각 큐가 만들어야 하는 합
        long sum1 = 0; // queue1의 합
        long sum2 = 0; // queue2의 합

        // 1. 큐 선언 후 값 넣기
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        for (int i = 0; i < queue1.length; i++) {
            q1.add(queue1[i]);
            q2.add(queue2[i]);
            sum1 += queue1[i];
            sum2 += queue2[i];
            target += queue1[i] + queue2[i];
        }

        if (target % 2 != 0) return -1; // 총합이 홀수인 경우 같게 만들 수 없음
        else target /= 2; // 총합이 짝수인 경우 각 큐는 (총합/2)이 되도록 만들어야함

        // 2. pop & insert 실행
        // 연산 후 각 합을 구하여 합이 더 큰 큐에서 pop 하도록 함
        while (count < (queue1.length + queue2.length)*2) { // 테스트케이스에서 나올 수 있는 최대 횟수
            if (sum1 == target && sum2 == target) break; // 각 큐의 합이 같아졌을 때 반복문 탈출
            if (sum1 > sum2) {
                int n = q1.poll();
                q2.add(n);
                sum1 -= n;
                sum2 += n;
            } else if (sum1 < sum2) {
                int n = q2.poll();
                q1.add(n);
                sum1 += n;
                sum2 -= n;
            }
            count++;
        }
        if (count == (queue1.length + queue2.length)*2) return -1; // while 을 전부 돌았다면 같게 만들 수 없음
        else return count; // 탈출 조건에 의해 while 반복을 빠져나왔다면 count 반환 
    }
}
