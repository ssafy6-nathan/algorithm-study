package study.nathan_algo_study.week59;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 문제이름 : A -> B
 * 링크 : https://www.acmicpc.net/problem/16953
 */

public class Baekjoon1653 {
    static int result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        result = Integer.MAX_VALUE;

        perm(1, a, b);

        if (result == Integer.MAX_VALUE)
            System.out.println(-1);
        else
            System.out.println(result);
    }

    public static void perm(int cnt, long p, long goal) {
        if (p >= goal) {
            if (p == goal)
                result = Math.min(result, cnt);

            return;
        }

        perm(cnt + 1, p * 2, goal);
        StringBuilder sb = new StringBuilder();
        sb.append(p);
        sb.append(1);
        perm(cnt + 1, Long.parseLong(sb.toString()), goal);
    }
}

/*
2
4
8
81
162


*/
