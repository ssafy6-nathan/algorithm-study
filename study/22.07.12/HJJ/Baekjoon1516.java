package study.nathan_algo_study.week20;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 문제이름 : 게임개발
 * 링크 : https://www.acmicpc.net/problem/1516
 */

public class Baekjoon1516 {
    static int N;
    static ArrayList<Integer>[] graph;
    static int[] prevBuildingCnt;
    static int[] times;
    static int[] result;
    static boolean[] v;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        graph = new ArrayList[N + 1];
        prevBuildingCnt = new int[N + 1];
        times = new int[N + 1];
        for (int i = 0; i <= N; i++)
            graph[i] = new ArrayList<>();


        int prev;
        for (int curr = 1; curr <= N; curr++) {
            st = new StringTokenizer(br.readLine());
            times[curr] = Integer.parseInt(st.nextToken());
            while (st.hasMoreTokens()) {
                prev = Integer.parseInt(st.nextToken());
                if (prev == -1)
                    break;

                graph[prev].add(curr);
                prevBuildingCnt[curr]++;
            }
        }

        result = new int[N + 1];
        v = new boolean[N + 1];
        v[0] = true;

        for (int i = 1; i <= N; i++) {
            if (v[i] || prevBuildingCnt[i] > 0)
                continue;

            bfs(i);
        }

        for (int i = 1; i <= N; i++) {
            bw.write(result[i] + "\n");
        }
        bw.close();

    }

    public static void bfs(int start) {
        Queue<int[]> q = new LinkedList<>();

        q.add(new int[]{start, times[start]});
        v[start] = true;
        result[start] = times[start];

        while (!q.isEmpty()) {
            int[] item = q.poll();
            int curr = item[0];
            int time = item[1];

            for (int next : graph[curr]) {
                if (v[next])
                    continue;

                prevBuildingCnt[next]--;
                result[next] = Math.max(result[next], time);    //최대시간 갱신
                if (prevBuildingCnt[next] <= 0) {  //선행 건물이 모두 지어졌으면
                    v[next] = true;
                    result[next] += times[next];
                    q.add(new int[]{next, result[next]});
                }
            }
        }

    }

}

/*
1 10
2 20
3 14
4 18
5 17

4
20 -1
10 -1
1 1 2 -1
1000 1 2 3 -1




 */
