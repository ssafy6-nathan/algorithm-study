package study.nathan_algo_study.week50;

import java.util.HashMap;
import java.util.Map;

/**
 * 문제이름 : 카드 뭉치
 * 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/159994
 */

public class Programmers_카드뭉치 {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        Map<String, Integer> cardMap1 = new HashMap<>();
        Map<String, Integer> cardMap2 = new HashMap<>();

        for (int i = 0; i < cards1.length; i++)
            cardMap1.put(cards1[i], i);

        for (int i = 0; i < cards2.length; i++)
            cardMap2.put(cards2[i], i);

        int idx1 = 0;
        int idx2 = 0;

        int item = 0;
        for (String str : goal) {
            if (cardMap1.containsKey(str)) {
                item = cardMap1.get(str);
                if (item == idx1)
                    idx1++;
                else
                    return "No";
            } else {
                item = cardMap2.get(str);
                if (item == idx2)
                    idx2++;
                else
                    return "No";
            }
        }

        return "Yes";
    }
}

/*

*/
