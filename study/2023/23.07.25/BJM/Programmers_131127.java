package week62;

/**
 * 프로그래머스 131127번
 * 할인 행사
 * (https://school.programmers.co.kr/learn/courses/30/lessons/131127)
 **/
public class Programmers_131127 {
    public static void main(String[] args) {
        String[][] want = {{"banana", "apple", "rice", "pork", "pot"}, {"apple"}};
        int[][] number = {{3, 2, 2, 2, 1}, {10}};
        String[][] discount = {{"chicken", "apple", "apple", "banana", "rice", "apple", "pork", "banana", "pork", "rice", "pot", "banana", "apple", "banana"} ,
                {"banana", "banana", "banana", "banana", "banana", "banana", "banana", "banana", "banana", "banana"}};
        for (int i = 0; i < 2; i++) {
            System.out.println(solution(want[i], number[i], discount[i]));;
        }
    }

    public static int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        // 현재 날짜 기준점 (i)
        for (int i = 0; i < discount.length - 9; i++) {
            // 현재 확인 중인 물품 기준점 (j)
            int j;
            for (j = 0; j < want.length; j++) {
                int count = 0;
                // 현재 기준일 (i)부터 10일 동안 확인
                for (int k = i; k < i + 10; k++)
                    if (want[j].equals(discount[k])) count++;
                // 살 수 없는 물품이 생기면 반복문 중단
                if (count < number[j]) break;
            }
            // 원하는 물품을 모두 살 수 있는 날짜라면 (j for문을 모두 돌았다면) 카운팅
            if (j == want.length) answer++;
        }
        return answer;
    }
}