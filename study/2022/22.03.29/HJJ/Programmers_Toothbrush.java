package study.nathan_algo_study.week5;

import java.util.HashMap;

/**
 * 문제이름 : 다단계 칫솔 판매
 * 링크 : https://programmers.co.kr/learn/courses/30/lessons/77486
 */

public class Programmers_Toothbrush {
    static HashMap<String, Integer> index;
    static int[] profits;
    static int[] parents;

    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        index = new HashMap<>();
        parents = new int[enroll.length];
        profits = new int[referral.length];
        for (int i = 0; i < enroll.length; i++) {
            if (enroll[i].equals("-"))
                continue;
            index.put(enroll[i], i);
        }

        for (int i = 0; i < referral.length; i++) {
            parents[i] = (referral[i].equals("-")) ? -1 : index.get(referral[i]);
        }

        for (int i = 0; i < seller.length; i++) {
            dfs(index.get(seller[i]), 100 * amount[i]);
        }

        return profits;
    }

    public static void dfs(int target, int totalProfit) {
        int payToParent = 0;
        if (totalProfit / 10 < 1)
            profits[target] += totalProfit;
        else {
            payToParent = totalProfit / 10;
            profits[target] += totalProfit - payToParent;
        }

        if (payToParent == 0 || parents[target] == -1) //위로 올려보낼 상납금이 없거나 추천인이 없으면
            return;

        dfs(parents[target], payToParent);
    }
}

/*

 */
