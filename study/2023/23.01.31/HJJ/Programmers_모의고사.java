package study.nathan_algo_study.week45;

import java.util.ArrayList;
import java.util.List;

/**
 * 문제이름 : 모의고사
 * 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/42840
 */

public class Programmers_모의고사 {
    public int[] solution(int[] answers) {
        int[][] mathGiveUp = {{1, 2, 3, 4, 5}, {2, 1, 2, 3, 2, 4, 2, 5}, {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}};
        int[] cnt = new int[3];

        int idx1 = 0;
        int idx2 = 0;
        int idx3 = 0;
        for (int i = 0; i < answers.length; i++) {
            if (mathGiveUp[0][idx1] == answers[i])
                cnt[0]++;

            if (mathGiveUp[1][idx2] == answers[i])
                cnt[1]++;

            if (mathGiveUp[2][idx3] == answers[i])
                cnt[2]++;

            idx1 = (idx1 + 1) % mathGiveUp[0].length;
            idx2 = (idx2 + 1) % mathGiveUp[1].length;
            idx3 = (idx3 + 1) % mathGiveUp[2].length;
        }

        int max = 0;
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < cnt.length; i++) {
            if (max < cnt[i]) {
                max = cnt[i];
                result.clear();
                result.add(i + 1);
            } else if (max == cnt[i]) {
                result.add(i + 1);
            }
        }
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}

/*

 */
