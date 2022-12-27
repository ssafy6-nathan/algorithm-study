package study.nathan_algo_study.week39;

import java.io.*;

/**
 * 문제이름 : 종이 접기
 * 링크 : https://www.acmicpc.net/problem/1802
 */

public class Baekjoon1802 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int tc = Integer.parseInt(br.readLine());
        for (int t = 0; t < tc; t++) {

            String str = br.readLine();
            boolean isYes = true;
            int mid = str.length() / 2;
            int len = str.length();
            fail:
            while (mid != 0) {
                for (int i = 0; i < mid; i++) {
                    int pair = len - 1 - i;
                    if (str.charAt(i) == str.charAt(pair)) {
                        isYes = false;
                        break fail;
                    }
                }
                mid /= 2;
                len /= 2;
            }

            bw.write(isYes ? "YES\n" : "NO\n");
        }
        bw.close();
    }

}

/*
100 0
011


2
0010001 / 0000111

001
000
111
100




000
111

1
0
0
1
*/
