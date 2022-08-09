package study.nathan_algo_study.week24;

import java.util.PriorityQueue;

/**
 * 문제이름 : 더 맵게
 * 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/42626
 */

public class Programmers42626 {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < scoville.length; i++)
            pq.add(scoville[i]);

        int answer = 0;
        while (pq.peek() < K) {
            int food1 = pq.poll();
            int food2 = pq.poll();

            int mixedFood = food1 + (food2 * 2);
            answer++;

            if (pq.isEmpty() && mixedFood < K)    //마지막 음식이 스코빌지수를 K이상 못넘기면
                answer = -1;

            pq.add(mixedFood);
        }

        return answer;
    }
}

/*

 */
