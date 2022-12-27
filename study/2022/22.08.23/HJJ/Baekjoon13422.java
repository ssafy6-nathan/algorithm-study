package study.nathan_algo_study.week26;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 문제이름 : 도둑
 * 링크 : https://www.acmicpc.net/problem/13422
 */

public class Baekjoon13422 {
    static int N, M, K;
    static int[] house;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int tc = Integer.parseInt(br.readLine());
        for (int t = 0; t < tc; t++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            house = new int[N];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++)
                house[i] = Integer.parseInt(st.nextToken());

            bw.write(solution()+"\n");
        }
        bw.close();

    }

    public static int solution() {
        long steal = 0L;
        for (int i = 0; i < M; i++)
            steal += house[i];

        if (N == M) {
            if (steal < K)
                return 1;
            else
                return 0;
        }

        int start = 0;
        int end = M;
        int cnt = 0;
        while (start != N) {
            if (steal < K)
                cnt++;
            steal -= house[start++];
            steal += house[end++];

            if (end == N)
                end = 0;
        }

        return cnt;
    }
}

/*

*/
