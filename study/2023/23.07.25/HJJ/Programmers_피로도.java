package study.nathan_algo_study.week62;

/**
 * 문제이름 : 피로도
 * 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/87946
 */

public class Programmers_피로도 {
    static int maxCnt;
    static int[][] dungeon;
    public int solution(int k, int[][] dungeons) {
        maxCnt = 0;
        dungeon = dungeons;
        dfs(0, dungeons.length, new boolean[dungeons.length], k);

        return maxCnt;
    }

    private void dfs(int cnt, int n, boolean[] v, int currFatigue) {
        if (cnt == n) {
            maxCnt = n;
            return;
        }

        maxCnt = Math.max(maxCnt, cnt);

        for (int i = 0; i < n; i++) {
            if (v[i])
                continue;

            if (currFatigue >= dungeon[i][0]) {
                v[i] = true;
                dfs(cnt + 1, n, v, currFatigue - dungeon[i][1]);
                v[i] = false;
            }
        }
    }
}

/*
80 20
50 40
30 10

80 20
30 10
50 40


*/
