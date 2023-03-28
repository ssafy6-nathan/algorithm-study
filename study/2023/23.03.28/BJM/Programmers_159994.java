package week50;

import java.util.Stack;

/**
 * 프로그래머스 159994번
 * 카드 뭉치
 * (https://school.programmers.co.kr/learn/courses/30/lessons/159994)
 **/
public class Programmers_159994 {
    public static void main(String[] args) {
        // 25번 테스트 케이스 반례 추가
        String[][] cards1 = {{"i", "drink", "water"}, {"i", "water", "drink"}, {"a", "b", "c"}};
        String[][] cards2 = {{"want", "to"}, {"want", "to"}, {"d", "e"}};
        String[][] goal = {{"i", "want", "to", "drink", "water"}, {"i", "want", "to", "drink", "water"}, {"b", "c", "d", "e"}};

        for (int i = 0; i < goal.length; i++ )
            System.out.println(solution(cards1[i], cards2[i], goal[i]));
    }

    public static String solution(String[] cards1, String[] cards2, String[] goal) {
        String answer = "Yes";
        // 1. Array -> Stack
        Stack<String> cards_1 = new Stack<>();
        for (int i = cards1.length - 1; i >= 0; i--)
            cards_1.push(cards1[i]);

        Stack<String> cards_2 = new Stack<>();
        for (int i = cards2.length - 1; i >= 0; i--)
            cards_2.push(cards2[i]);

        // 2. 카드 뭉치 비교하기
        for (int i = 0; i < goal.length; i++) {
            String str = goal[i];
            // 카드 뭉치 1과 일치하는지 확인
            if (!cards_1.empty() && cards_1.peek().equals(str)) {
                cards_1.pop();
                continue;
            }
            // 카드 뭉치 2와 일치하는지 확인
            if (!cards_2.empty() && cards_2.peek().equals(str)) {
                cards_2.pop();
                continue;
            }
            // 연속으로 모두 일치하지 않으면 goal과 일치할 수 없음
            else {
                answer = "No";
                break;
            }
        }
        return answer;
    }
}