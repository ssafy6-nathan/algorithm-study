package study.nathan_algo_study.week16;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 문제이름 : 날짜 계산
 * 링크 : https://www.acmicpc.net/problem/1476
 */

public class Baekjoon1476 {
    static int[] ranges = {15, 28, 19};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int e = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        System.out.println(change(e,s,m));
    }

    public static int change(int e, int s, int m) {
        int E = 1;
        int S = 1;
        int M = 1;
        int year = 1;

        while (e != E || s != S || m != M) {
            E = (E + 1 > ranges[0])? 1 : E + 1;
            S = (S + 1 > ranges[1])? 1 : S + 1;
            M = (M + 1 > ranges[2])? 1 : M + 1;
            year++;
        }

        return year;
    }
}

/*

 */
