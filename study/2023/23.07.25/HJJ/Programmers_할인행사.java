package study.nathan_algo_study.week62;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 문제이름 : 할인 행사
 * 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/131127
 */

public class Programmers_할인행사 {
    public static int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        Map<String, Integer> wantMap = new HashMap<>();
        Map<String, Integer> wantIdx = new HashMap<>();
        int maxCnt = 0;
        for (int i = 0; i < want.length; i++) {
            wantIdx.put(want[i], i);
            maxCnt += number[i];
        }

        int cnt = 0;
        for (int i = 0; i < 10; i++) {
            if (!wantIdx.containsKey(discount[i]))
                continue;

            wantMap.put(discount[i], wantMap.getOrDefault(discount[i], 0) + 1);
            if (wantMap.get(discount[i]) <= number[wantIdx.get(discount[i])])   //제품 갯수가 원하는 갯수를 안넘어갔을 때만 카운트
                cnt++;
        }

        if (cnt >= maxCnt)
            answer++;

        //슬라이드 윈도우
        for (int i = 0; i < discount.length - 10; i++) {
            if (wantIdx.containsKey(discount[i])) {     //시작지점부터 하나 뺌
                wantMap.put(discount[i], wantMap.get(discount[i]) - 1);
                if (wantMap.get(discount[i]) < number[wantIdx.get(discount[i])])
                    cnt--;
            }

            if (wantIdx.containsKey(discount[i + 10])) {    //끝지점 하나 추가
                wantMap.put(discount[i + 10], wantMap.getOrDefault(discount[i + 10], 0) + 1);
                if (wantMap.get(discount[i + 10]) <= number[wantIdx.get(discount[i + 10])])   //제품 갯수가 원하는 갯수를 안넘어갔을 때만 카운트
                    cnt++;
            }

            if (cnt >= maxCnt)
                answer++;
        }

        return answer;
    }
}

/*
banana, apple, rice, pork, pot
  3,     2,     2,     2,   1

"chicken", "apple", "apple", "banana", "rice", "apple", "pork","banana", "pork", "rice",

"pot", "banana", "apple", "banana"

*/
