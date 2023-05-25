package study.nathan_algo_study.week56;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 문제이름 : 덩치
 * 링크 : https://www.acmicpc.net/problem/7568
 */

public class Baekjoon7568 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        int[][] people = new int[n][2];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            people[i][0] = Integer.parseInt(st.nextToken());
            people[i][1] = Integer.parseInt(st.nextToken());
        }

        int cnt;
        for (int i = 0; i < n; i++) {
            cnt = 0;
            for (int j = 0; j < n; j++) {
                if (j == i)
                    continue;

                if (people[i][0] < people[j][0] && people[i][1] < people[j][1])
                    cnt++;
            }
            bw.write((cnt + 1) + " ");
        }

        bw.close();
    }
}

/*

 */
