package week45;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 프로그래머스 42840번
 * 모의고사
 * (https://school.programmers.co.kr/learn/courses/30/lessons/42840)
 **/
public class Programmers_42840 {
    public static void main(String[] args) {
        int[][] answers = {{1,2,3,4,5}, {1,3,2,4,2}, {3,3,1,1,1,1,2,3,4,5}};
        for (int[] answer : answers) {
            System.out.println(Arrays.toString(solution(answer)));
        }
    }

    public static int[] solution(int[] answers) {
        ArrayList<Integer> ans = new ArrayList<>();
        int[][] student = {{1,2,3,4,5}, {2,1,2,3,2,4,2,5}, {3,3,1,1,2,2,4,4,5,5}};
        int[] count = new int[3]; // 맞춘 개수

        // 1. 정답과 일치하는지 확인
        for (int i = 0; i < answers.length; i++) {
            if(answers[i] == student[0][i%student[0].length]) count[0]++;
            if(answers[i] == student[1][i%student[1].length]) count[1]++;
            if(answers[i] == student[2][i%student[2].length]) count[2]++;
        }

        // 2. 가장 많이 맞은 사람 탐색
        int max = 0;
        for (int i = 0; i < count.length; i++) {
            // 2-1. 최대값과 같을 경우 추가
            if(max == count[i]) {
                ans.add(i+1);
            }
            // 2-2. 최대값이 갱신되었을 경우 리스트 초기화 후 추가
            else if(max < count[i]) {
                ans.clear();
                ans.add(i+1);
                max = count[i];
            }
        }

        // 3. list -> array 후 정렬
        int[] answer = ans.stream().mapToInt(Integer::intValue).toArray();
        Arrays.sort(answer);
        return answer;
    }

}
