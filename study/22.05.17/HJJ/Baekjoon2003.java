package study.nathan_algo_study.week12;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 문제이름 : 수들의 합 2
 * 링크 : https://www.acmicpc.net/problem/2003
 */

public class Baekjoon2003 {
    static int N, M;
    static int[] seq;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        seq = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            seq[i] = Integer.parseInt(st.nextToken());

        System.out.println(counting());
    }

    public static int counting() {
        int cnt = 0;
        int front = 0;
        int back = 0;
        int sum = 0;

        while (true) {
            if (sum >= M)
                sum -= seq[front++];
            else if (back == N)
                break;
            else
                sum += seq[back++];


            if (sum == M)
                cnt++;
        }

        return cnt;
    }
}

/*

 */
