package study.nathan_algo_study.week39;

import java.io.*;
import java.util.Arrays;

/**
 * 문제이름 : 칸토어 집합
 * 링크 : https://www.acmicpc.net/problem/4779
 */

public class Baekjoon4779 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String in;
        while ((in = br.readLine()) != null && !in.isEmpty()) {
            int n = (int)Math.pow(3,Integer.parseInt(in));

            if (n == 1)
                bw.write("-\n");
            else {
                char[] str = new char[n];
                Arrays.fill(str, ' ');
                dfs(n, 0, str);

                bw.write(String.valueOf(str) + '\n');
            }
        }
        bw.close();
    }

    public static void dfs(int len, int start, char[] str) {
        if (len == 3) {
            str[start] = '-';
            str[start + 2] = '-';

            return;
        }
        int nextLen = len / 3;

        dfs(nextLen, start, str);
        dfs(nextLen, start + nextLen * 2, str);
    }
}

/*

 */
