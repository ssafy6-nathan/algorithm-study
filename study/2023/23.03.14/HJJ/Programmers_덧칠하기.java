package study.nathan_algo_study.week49;

/**
 * 문제이름 : 덧칠하기
 * 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/161989
 */

public class Programmers_덧칠하기 {
    public int solution(int n, int m, int[] section) {
        int answer = 0;

        int max = 0;
        for (int s : section) {
            if (s > max) {
                answer++;
                max = s + m -1;
            }
        }

        return answer;
    }
}

/*
8 4
1 2 3 4 5 6 7 8
2 3 6





*/
