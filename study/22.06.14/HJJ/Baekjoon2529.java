package study.nathan_algo_study.week16;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 문제이름 : 부등호
 * 링크 : https://www.acmicpc.net/problem/2529
 */

public class Baekjoon2529 {
    static int K;
    static char[] signs;
    static String max, min;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        K = Integer.parseInt(br.readLine());
        signs = new char[K];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++)
            signs[i] = st.nextToken().charAt(0);

        max = null;
        min = null;

        search(0, new char[K + 1], new boolean[10]);
        System.out.println(max);
        System.out.println(min);
    }

    public static void search(int cnt, char[] num, boolean[] v) {
        if (cnt == K + 1) {
            String number = new String(num);
            if (max == null && min == null) {
                max = number;
                min = number;
            } else {
                max = (Long.parseLong(max) < Long.parseLong(number)) ? number : max;
                min = (Long.parseLong(min) > Long.parseLong(number)) ? number : min;
            }

            return;
        }

        for (int i = 0; i < 10; i++) {
            if (v[i])
                continue;

            if (cnt > 0 && !isValid(cnt - 1, Character.getNumericValue(num[cnt - 1]), i))
                continue;

            num[cnt] = (char) (i + 48);
            v[i] = true;
            search(cnt + 1, num, v);
            v[i] = false;
        }
    }

    public static boolean isValid(int idx, int n1, int n2) {
        if (signs[idx] == '>')
            return n1 > n2;
        else
            return n1 < n2;
    }
}

/*
10 9 8 7 6 5 4 3 2 1



*/
