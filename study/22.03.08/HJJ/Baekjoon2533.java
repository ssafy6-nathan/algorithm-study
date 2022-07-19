package study.nathan_algo_study.week2;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * 문제이름 : 사회망 서비스
 * 링크 : https://www.acmicpc.net/problem/2533
 */

public class Baekjoon2533 {
    static ArrayList<Integer>[] tree;
    static int[][] dp;
    static boolean[] visited;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        dp = new int[n + 1][2];
        tree = new ArrayList[n + 1];
        visited = new boolean[n + 1];
        for (int i = 0; i < n + 1; i++)
            tree[i] = new ArrayList<>();

        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            tree[from].add(to);
            tree[to].add(from);
        }

        dfs(1);
        System.out.println(Math.min(dp[1][0], dp[1][1]));
    }

    public static void dfs(int curNode) {
        visited[curNode] = true;
        dp[curNode][0] = 0;    //현재 노드가 얼리어답터가 아닌경우
        dp[curNode][1] = 1;    //현재 노드가 얼리어답터인 경우

        for (int childNode : tree[curNode]) {
            if (visited[childNode])
                continue;

            dfs(childNode);
            dp[curNode][0] += dp[childNode][1]; //현재 노드가 얼리어답터가 아니면 자식노드는 모두 얼리어답터야 함
            dp[curNode][1] += Math.min(dp[childNode][0], dp[childNode][1]);  //현재노드가 얼리어답터이면 자식노드는 얼리어답터일수도 아닐수도 있으므로 둘중에 최소인 값을 더함
        }
    }
}

/*
탐색중인 노드가 얼리어답터이면
- 이웃한 노드는 얼리어답터일수도 아닐 수도 있다.

탐색중인 노드가 얼리어답터가 아니면
- 이웃한 노드는 모두 얼리답터여야 한다.


*/
