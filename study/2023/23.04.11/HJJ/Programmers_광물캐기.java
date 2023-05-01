package study.nathan_algo_study.week52;

import java.util.Arrays;

/**
 * 문제이름 : 광물 캐기
 * 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/172927
 */

public class Programmers_광물캐기 {
    static int[][] costArr = {{1, 1, 1}, {5, 1, 1}, {25, 5, 1}};

    public static void main(String[] args) {
        Programmers_광물캐기 p = new Programmers_광물캐기();

        int result = p.solution(new int[]{1, 3, 2}, new String[]{"diamond", "diamond", "diamond", "iron", "iron", "diamond", "iron", "stone"});
        System.out.println(result);
    }

    //다이아 0 철 1 돌 2
    public int solution(int[] picks, String[] minerals) {
        int setLen = minerals.length / 5 + (minerals.length % 5 > 0 ? 1 : 0);
        int[][] mineralSet = new int[setLen][2];
        for (int i = 0; i < setLen; i++) {
            mineralSet[i][0] = getMineralSetCost(i * 5, 2, minerals);
            mineralSet[i][1] = i;
        }

        Arrays.sort(mineralSet, (o1, o2) -> o2[0] - o1[0]);
        int pickCnt = 0;
        for (int i = 0; i < picks.length; i++)
            pickCnt += picks[i];


        int answer = 0;
        for (int i = 0; i < setLen; i++) {
            int cost = mineralSet[i][0];
            int idx = mineralSet[i][1];

            if (idx >= pickCnt) //곡갱이의 갯수보다 광물묶음의 순서가 더 크면 광물 캐기 불가능
                continue;

            if (picks[0] > 0) {
                answer += getMineralSetCost(idx * 5, 0, minerals);
                picks[0]--;
            } else if (picks[1] > 0) {
                answer += getMineralSetCost(idx * 5, 1, minerals);
                picks[1]--;
            } else if (picks[2] > 0) {
                answer += getMineralSetCost(idx * 5, 2, minerals);
                picks[2]--;
            } else {
                break;
            }
        }

        return answer;
    }

    public int getMineralSetCost(int startIdx, int pick, String[] minerals) {
        int cost = 0;
        for (int i = startIdx; i < startIdx + 5 && i < minerals.length; i++)
            cost += getCost(minerals[i], pick);

        return cost;
    }

    public int getCost(String mineral, int pick) {
        int mineralNum = -1;

        if (mineral.equals("diamond"))
            mineralNum = 0;
        else if (mineral.equals("iron"))
            mineralNum = 1;
        else
            mineralNum = 2;

        return costArr[pick][mineralNum];
    }
}

/*
광물을 5개씩 묶어서 피로도 계산

1번 예제
광물 묶기
dddii, dis

dddii = 다이아곡: 5, 철곡: 17, 돌곡: 85 (첫번째 묶음)
dis = 다이아곡: 3, 철곡: 7, 돌곡: 31 (두번째 묶음)

8
2



*/
