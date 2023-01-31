package study.nathan_algo_study.week45;

/**
 * 문제이름 : 네트워크
 * 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/43162
 */

public class Programmers_네트워크 {

    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] v = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (v[i])
                continue;

            dfs(i, computers, v, n);
            answer++;
        }
        return answer;
    }

    public void dfs(int pos, int[][] computers, boolean[] v, int n) {
        v[pos] = true;

        for (int i = 0; i < n; i++) {
            if (i == pos || v[i] || computers[pos][i] == 0)
                continue;

            dfs(i,computers,v,n);
        }
    }
}

/*
110
110
001

110
111
011
*/
