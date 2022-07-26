package study.nathan_algo_study.week22;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 문제이름 : 인간-컴퓨터 상호작용
 * 링크 : https://www.acmicpc.net/problem/16139
 */

public class Baekjoon16139 {
    static String str;
    static int Q;
    static int[][] prefixSum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        str = br.readLine();
        Q = Integer.parseInt(br.readLine());
        prefixSum = new int[str.length() + 1][26];  //1번행부터 문자열 시작

        for (int i = 1; i <= str.length(); i++) {
            int idx = str.charAt(i - 1) - 'a';
            prefixSum[i][idx]++;
            for (int j = 0; j < 26; j++) {
                prefixSum[i][j] += prefixSum[i - 1][j];
            }
        }

        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());
            char c = st.nextToken().charAt(0);
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());

            bw.write(prefixSumCal(c, l + 1, r + 1) + "\n");
        }
        bw.close();

    }

    public static int prefixSumCal(char c, int l, int r) {
        int idx = c - 97;
        if (l == 1) {
            return prefixSum[r][idx];
        } else {
            return prefixSum[r][idx] - prefixSum[l - 1][idx];
        }
    }
}

/*
0 3 1 5 2

0 3 4 9 11




 */
