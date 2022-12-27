package study.nathan_algo_study.week36;

import java.io.*;

/**
 * 문제이름 : 방 번호
 * 링크 : https://www.acmicpc.net/problem/
 */

public class Baekjoon1475 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int[] cnt = new int[10];

        for (int i = 0; i < input.length(); i++) {
            int idx = input.charAt(i) - 48;
            if (idx == 9)
                cnt[6]++;
            else
                cnt[idx]++;
        }
        int max = 0;
        for (int i = 0; i < 9; i++) {
            if (i == 6)
                max = Math.max(max, (int)Math.ceil(cnt[i]/2.0));
            else
                max = Math.max(max, cnt[i]);
        }

        System.out.println(max);
    }
}

/*

 */
