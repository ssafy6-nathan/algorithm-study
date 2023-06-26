package study.nathan_algo_study.week59;

import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * 문제이름 : 카드 합체 놀이
 * 링크 : https://www.acmicpc.net/problem/15903
 */

public class Baekjoon15903 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        PriorityQueue<Long> pq = new PriorityQueue<>();

        for (int i = 0; i < n; i++)
            pq.add(Long.parseLong(st.nextToken()));

        for (int i = 0; i < m; i++) {
            long card1 = pq.poll();
            long card2 = pq.poll();

            pq.add(card1+card2);
            pq.add(card1+card2);
        }

        long result = 0;
        while (!pq.isEmpty())
            result += pq.poll();

        System.out.println(result);
    }
}

/*
4 2 3 1
4 3 3 3
4 3 6 6

*/
