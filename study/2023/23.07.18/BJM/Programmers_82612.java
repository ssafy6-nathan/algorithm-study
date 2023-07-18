package week61;

/**
 * 프로그래머스 82612번
 * 부족한 금액 계산하기
 * (https://school.programmers.co.kr/learn/courses/30/lessons/82612)
 **/
public class Programmers_82612 {
    public static void main(String[] args) {
        int price = 3;
        int money = 20;
        int count = 4;
        System.out.println(solution(price, money, count));
    }

    public static long solution(int price, int money, int count) {
        long answer;
        long val = 0; // 금액 누적값

        for (int i = 1; i <= count; i++)
            val += ((long) price * i);

        if (val >= money) answer = val - money;
        else answer = 0;

        return answer;
    }
}
