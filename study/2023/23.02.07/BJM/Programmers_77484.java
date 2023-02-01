package week46;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 프로그래머스 77484번
 * 로또의 최고 순위와 최저 순위
 * (https://school.programmers.co.kr/learn/courses/30/lessons/77484)
 **/
public class Programmers_77484 {
    public static void main(String[] args) {
        // 테스트 케이스 14번 추가
        int[][] lottos = {{44,1,0,0,31,25}, {0,0,0,0,0,0}, {45,4,35,20,3,9}, {1,2,3,4,5,6}};
        int[][] win_nums = {{31,10,45,1,6,19}, {38,19,20,40,15,25}, {20,9,3,45,4,35}, {7,8,9,10,11,12}};
        for (int i = 0; i < lottos.length; i++) {
            System.out.println(Arrays.toString(solution(lottos[i], win_nums[i])));
        }
    }

    public static int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        int correct = 0; // 당첨된 번호 개수
        int zero_count = 0; // 지워진 숫자 개수

        // 리스트 변환 (contains 사용)
        List<Integer> list = new ArrayList<>();
        for (int i : win_nums) list.add(i);

        for (int lotto : lottos) {
            if (list.contains(lotto)) // 당첨된 숫자 카운팅
                correct++;
            else if (lotto == 0) // 지워진 숫자 카운팅
                zero_count++;
        }

        // 최고 순위 : 당첨 번호 개수 + 지워진 숫자 개수 의 등수
        answer[0] = (correct + zero_count == 0) ? 6 : 7 - (correct + zero_count);
        // 최저 순위 : 당첨 번호 개수의 등수
        answer[1] = (correct == 0) ? 6 : 7 - correct;

        return answer;
    }
}
