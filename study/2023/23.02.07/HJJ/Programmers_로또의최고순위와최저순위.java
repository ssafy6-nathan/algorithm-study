package study.nathan_algo_study.week46;

import java.util.HashSet;

/**
 * 문제이름 : 로또의 최고 순위와 최저 순위
 * 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/77484
 */

public class Programmers_로또의최고순위와최저순위 {
    public int[] solution(int[] lottos, int[] win_nums) {
        HashSet<Integer> winNums = new HashSet<>();
        for (int i = 0; i < win_nums.length; i++)
            winNums.add(win_nums[i]);

        int equalCnt = 0;
        int zeroCnt = 0;
        for (int i = 0; i < lottos.length; i++) {
            if (winNums.contains(lottos[i]))
                equalCnt++;
            else if (lottos[i] == 0)
                zeroCnt++;
        }

        int maxRank = (7-(equalCnt+zeroCnt) > 6)? 6 : 7-(equalCnt+zeroCnt);
        int minRank = (7-equalCnt > 6)? 6 : 7-equalCnt;

        int[] answer = {maxRank, minRank};
        return answer;
    }
}

/*

*/
