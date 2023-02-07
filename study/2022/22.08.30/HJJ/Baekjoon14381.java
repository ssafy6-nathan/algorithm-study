package study.nathan_algo_study.week27;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 문제이름 : 종이 조각
 * 링크 : https://www.acmicpc.net/problem/14391
 */

public class Baekjoon14381 {
    static int N, M;
    static int[][] paper;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        paper = new int[N][M];

        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < M; j++) {
                paper[i][j] = input.charAt(j) - '0';
            }
        }

        System.out.println(solution());
    }

    public static int solution() {
        int result = 0;

        for (int bit = 0; bit < (1 << N * M); bit++) {
            int sum = 0;

            for (int i = 0; i < N; i++) {
                int curr = 0;
                for (int j = 0; j < M; j++) {
                    int k = i * M + j;
                    if ((bit & (1 << k)) == 0) {  //해당 비트가 0이면 가로
                        curr *= 10;
                        curr += paper[i][j];
                    } else {    //0이 아니면 세로
                        sum += curr;    //현재까지 저장한 수를 sum에 더함
                        curr = 0;
                    }
                }
                sum += curr;
            }

            for (int j = 0; j < M; j++) {
                int curr = 0;
                for (int i = 0; i < N; i++) {
                    int k = i * M + j;
                    if ((bit & (1<<k)) != 0) {
                        curr *= 10;
                        curr += paper[i][j];
                    } else {
                        sum += curr;
                        curr = 0;
                    }
                }
                sum += curr;
            }
            result = Math.max(result, sum);
        }


        return result;
    }
}

/*

 */
