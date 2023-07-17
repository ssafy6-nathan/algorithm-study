package study.nathan_algo_study.week61;

/**
 * 문제이름 : 부족한 금액 계산하기
 * 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/82612
 */

public class Programmers_부족한금액계산하기 {
    public long solution(int price, int money, int count) {
        long answer = -1;
        long totalPrice = 0;

        for (int i = 1; i <= count; i++) {
            totalPrice += price * i;
        }

        answer = (totalPrice - money < 0)? 0 : totalPrice - money;
        return answer;
    }
}

/*

*/
