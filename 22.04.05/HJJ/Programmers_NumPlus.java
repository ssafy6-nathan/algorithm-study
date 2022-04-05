package study.nathan_algo_study.week6;

/**
 * 문제이름 : 없는 숫자 더하기
 * 링크 : https://programmers.co.kr/learn/courses/30/lessons/86051
 */

public class Programmers_NumPlus {
    public int solution(int[] numbers) {
        int sumAll = 45;
        int sum = 0;
        for (int i = 0; i < numbers.length; i++) {
            sum += numbers[i];
        }
        int answer = sumAll - sum;
        return answer;
    }
}

/*
1 2 3 4 5 6 7 8 9 0


 */