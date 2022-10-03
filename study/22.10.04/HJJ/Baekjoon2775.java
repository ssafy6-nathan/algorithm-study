package study.nathan_algo_study.week30;

import java.io.*;

/**
 * 문제이름 : 부녀회장이 될테야
 * 링크 : https://www.acmicpc.net/problem/2775
 */

public class Baekjoon2775 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[][] arr = new int[15][15];
        for (int i = 0; i < 15; i++) {
            for (int j = 1; j < 15; j++) {
                if (i == 0)
                    arr[i][j] = j;
                else
                    arr[i][j] = arr[i][j-1] + arr[i-1][j];
            }
        }

        int tc = Integer.parseInt(br.readLine());
        for (int t = 0; t < tc; t++) {
            int k = Integer.parseInt(br.readLine());
            int n = Integer.parseInt(br.readLine());

            bw.write(arr[k][n]+"\n");
        }
        bw.close();
    }
}

/*
1 4 10
1 3 6 10 15 21
1 2 3  4  5  6
*/
