package study.nathan_algo_study.week63;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * 문제이름 : 체크판 다시 칠하기
 * 링크 : https://www.acmicpc.net/problem/1018
 */

public class Baekjoon1018 {
    static int N, M;
    static char[][] board;
    static int[][] whiteFirstCost;
    static int[][] blackFirstCost;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new char[N][];
        for (int i = 0; i < N; i++)
            board[i] = br.readLine().toCharArray();

        whiteFirstCost = new int[N][M];
        blackFirstCost = new int[N][M];

        calCostArr('W', whiteFirstCost);
        calCostArr('B', blackFirstCost);

        System.out.println(Math.min(calMinCostSum(whiteFirstCost), calMinCostSum(blackFirstCost)));
    }

    public static void calCostArr(char firstCharacter, int[][] costs) {
        for (int i = 0; i < costs.length; i++) {
            for (int j = 0; j < costs[i].length; j++) {
                if (((i + j) % 2 == 0 && board[i][j] != firstCharacter)
                        || ((i + j) % 2 == 1 && board[i][j] == firstCharacter))
                    costs[i][j] = 1;
            }
        }
    }

    public static int calMinCostSum(int[][] costArr) {
        int costSum = 0;
        int minSum = Integer.MAX_VALUE;
        for (int i = 0; i <= N - 8; i++) {
            for (int j = 0; j <= M - 8; j++) {
                costSum = 0;
                for (int k = 0; k < 8; k++)
                    for (int l = 0; l < 8; l++)
                        costSum += costArr[i + k][j + l];

                minSum = Math.min(minSum, costSum);
            }
        }

        return minSum;
    }
}

/*
1. 케이스 분리해서 코스트 계산
1-1. 맨 왼쪽 위 칸이 흰색인 경우
1-2. 맨 왼쪽 위 칸이 검은색인 경우

2. 맨 왼쪽 위칸 기준 8x8칸안에 색칠해야할 코스트의 총합 계산
2-1. 오른쪽과 아래로 8x8범위의 그룹을 한칸씩 이동하면서 해당 부분의 코스트 총합 계산해서 최소 코스트 총합 저장

3. 최소 코스트총합 반환


00 01 02 03
10 11 12 13
20 21 22 23
30 31 32 33
*/
