package study.nathan_algo_study.week40;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 문제이름 : 저울
 * 링크 : https://www.acmicpc.net/problem/2437
 */

public class Baekjoon2437 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int[] w = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++)
            w[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(w);

        int sum = 0;
        for (int i = 0; i < n; i++) {
            if (sum + 1 < w[i])
                break;

            sum += w[i];
        }

        System.out.println(sum + 1);
    }
}

/*
1 1 2 3 6 7 30

1

1 2

1 2 3 4

1 2 3 4 5 6 7

1 2 3 4 5 6 7 8 9 10 11 12 13

1 1 2 = 4
1 1 2 4

1 2 5
*/
