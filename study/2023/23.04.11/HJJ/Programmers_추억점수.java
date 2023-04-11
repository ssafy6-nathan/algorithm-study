package study.nathan_algo_study.week52;

import java.util.HashMap;
import java.util.Map;

/**
 * 문제이름 : 추억 점수
 * 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/176963
 */

public class Programmers_추억점수 {

    public static void main(String[] args) {

        int[] answer = solution(new String[]{"may", "kein", "kain", "radi"}, new int[]{5,10,1,3},
                new String[][]{{"may", "kein", "kain", "radi"},{"may", "kein", "brin", "deny"},{"kon", "kain", "may", "coni"}});

        System.out.println(answer.toString());
    }
    public static int[] solution(String[] name, int[] yearning, String[][] photo) {
        Map<String, Integer> point = new HashMap<>();
        for (int i = 0; i < name.length; i++)
            point.put(name[i],yearning[i]);

        int[] answer = new int[photo.length];
        for (int i = 0; i < photo.length; i++) {
            for (int j = 0; j < photo[i].length; j++) {
                answer[i] += point.getOrDefault(photo[i][j], 0);
            }
        }

        return answer;
    }
}

/*

*/
