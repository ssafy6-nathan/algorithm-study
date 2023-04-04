package study.nathan_algo_study.week51;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 문제이름 : 선긋기
 * 링크 : https://www.acmicpc.net/problem/2170
 */

public class Baekjoon2170 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[][] pos = new int[n][2];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            pos[i][0] = Integer.parseInt(st.nextToken());
            pos[i][1] = Integer.parseInt(st.nextToken());

        }
        Arrays.sort(pos, ((o1, o2) -> {
            return o1[0] - o2[0];
        }));

        int currX;
        int currY;
        int prevX = pos[0][0];
        int prevY = pos[0][1];
        int cnt = 0;
        for (int i = 1; i < n; i++) {
            currX = pos[i][0];
            currY = pos[i][1];

            if (currX > prevY) {    //현재 시작지점이 이전 끝지점보다 크면 선이 끊김
                cnt += prevY - prevX;
                prevX = currX;
                prevY = currY;
            } else {    //아닐 때는 선 계속 이어감
                prevY = Math.max(prevY, currY);
            }
        }

        cnt += prevY - prevX;

        System.out.println(cnt);
    }
}

/*

0 0
1 3
2 5

4
5 10
15 20
25 30
7 35

5 10
7 35

*/
