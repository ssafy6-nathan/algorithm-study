package study.nathan_algo_study.week40;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 문제이름 : 위장
 * 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/42578
 */

public class Programmers_위장 {
    static Map<String, Integer> clothesCnt;

    public int solution(String[][] clothes) {
        clothesCnt = new HashMap<>();
        for (int i = 0; i < clothes.length; i++) {
            clothesCnt.put(clothes[i][1], clothesCnt.getOrDefault(clothes[i][1], 0) + 1);
        }

        int answer = 1;
        for (Map.Entry<String, Integer> entry : clothesCnt.entrySet())
            answer *= 1 + entry.getValue();

        return answer - 1;
    }


}

/*
(x+a)(x+b) - 1 = 3 * 2 - 1 = 5
   2    1

*/
