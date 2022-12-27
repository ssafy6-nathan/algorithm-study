package study.nathan_algo_study.week28;

import java.io.*;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

/**
 * 문제이름 : 기차가 어둠을 헤치고 은하수를
 * 링크 : https://www.acmicpc.net/problem/15787
 */

public class Baekjoon15787 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] trains = new int[N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int cmd = Integer.parseInt(st.nextToken());
            int train = Integer.parseInt(st.nextToken());
            int seat;
            switch (cmd) {
                case 1:
                    seat = Integer.parseInt(st.nextToken());
                    trains[train] |= 1 << (seat - 1);
                    break;
                case 2:
                    seat = Integer.parseInt(st.nextToken());
                    trains[train] &= ~(1 << (seat - 1));
                    break;
                case 3:
                    trains[train] = (trains[train] << 1) & ~(1 << 20);
                    break;
                case 4:
                    trains[train] = (trains[train] >>> 1);
            }

        }
        Set<Integer> set = new HashSet<>();
        for (int i = 1; i <= N; i++)
            set.add(trains[i]);

        System.out.println(set.size());
    }
}

/*

 */
