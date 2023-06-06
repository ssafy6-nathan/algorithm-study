package study.nathan_algo_study.week57;

/**
 * 문제이름 : 이모티콘 할인행사
 * 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/150368
 */

public class Programmers_이모티콘할인행사 {

    static final int[] DISCOUNT = {90, 80, 70, 60};
    static int totalEmoticonPlus;
    static int totalAmount;

    public int[] solution(int[][] users, int[] emoticons) {
        dfs(emoticons, users, 0, new int[emoticons.length]);

        int[] answer = {totalEmoticonPlus, totalAmount};
        return answer;
    }

    public void dfs(int[] emoticons, int[][] users, int curr, int[] rates) {
        if (curr == emoticons.length) {
            calc(emoticons, users, rates);
            return;
        }

        for (int discount : DISCOUNT) {
            rates[curr] = discount;
            dfs(emoticons, users, curr + 1, rates);
        }
    }

    public void calc(int[] emotions, int[][] users, int[] rates) {
        int epCnt = 0;
        int amountSum = 0;

        for (int[] user : users) {
            int userAmount = 0;
            int userRateCutLine = user[0];
            int userEpCutLine = user[1];
            for (int i = 0; i < rates.length; i++) {
                if (100 - rates[i] >= userRateCutLine) //할인율이 사용자의 기준을 넘으면
                    userAmount += (emotions[i] * rates[i]) / 100;    //이모티콘 구매

                if (userAmount >= userEpCutLine) {   //구매금액이 이모티콘플러스 구매컷트라인 넘으면
                    epCnt++;    //이모티콘플러스 구매
                    userAmount = 0;
                    break;
                }
            }
            amountSum += userAmount;
        }

        if (epCnt > totalEmoticonPlus) {
            totalEmoticonPlus = epCnt;
            totalAmount = amountSum;
        } else if (epCnt == totalEmoticonPlus) {
            totalAmount = Math.max(amountSum, totalAmount);
        }
    }
}

/*

 */
