package study.nathan_algo_study.week21;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 문제이름 : 개똥벌레
 * 링크 : https://www.acmicpc.net/problem/3020
 */

public class Baekjoon3020 {
    static int N, H;
    static int[] top;
    static int[] bottom;
    static int min, cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        top = new int[H + 1];
        bottom = new int[H + 1];
        for (int i = 0; i < N / 2; i++) {
            int topSize = Integer.parseInt(br.readLine());
            int bottomSize = Integer.parseInt(br.readLine());
            top[topSize]++;
            bottom[bottomSize]++;
        }
        min = N;
        cnt = 0;

        addSum();

        System.out.println(min + " " + cnt);

    }

    public static void addSum() {
        int[] bottomPrefixSum = new int[H + 1];
        int[] topPrefixSum = new int[H + 1];

        for (int i = 1; i < H + 1; i++) {
            topPrefixSum[i] = topPrefixSum[i - 1] + top[i];
            bottomPrefixSum[i] = bottomPrefixSum[i - 1] + bottom[i];
        }

        for (int i = 1; i < H + 1; i++) {
            int breakCnt = 0;

            //부수는 석순의 갯수 = 전체 석순의 갯수 - (i - 1) 이하인 석순의 갯수
            breakCnt += bottomPrefixSum[H] - bottomPrefixSum[i - 1];
            //부수는 종유석의 갯수 = 전체 종유석의 갯수 - (H - i) 이하인 종유석의 갯수
            breakCnt += topPrefixSum[H] - topPrefixSum[H - i];

            if (min > breakCnt) {
                min = breakCnt;
                cnt = 1;
            } else if (min == breakCnt)
                cnt++;
        }

    }
}

/*
14 5
1
3
4
2
2
4
3
4
3
3
3
2
3
3

1 2 3 3 3 3 4

2 2 3 3 3 4 4



 */
