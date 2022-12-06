package week32;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 백준 14712번
 * 넴모넴모 (Easy) (https://www.acmicpc.net/problem/14712)
 * 분류 : 브루트포스 알고리즘, 백트래킹
 **/

public class BOJ_14712 {

    static int N, M, result; // N: 행, M: 열, result: 문제 조건에 만족하는 경우의 수
    static boolean[][] check; // 네모 체크

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        check = new boolean[N][M];
        recur(0);
        System.out.println(result);


    }

    private static void recur(int cnt) {
        // 2차원 배열을 순회하는 인덱스 계산 (좌 -> 우)
        int row = cnt / M;
        int col = cnt % M;

        // 0. 종료조건: 격자판을 모두 순회한 경우
        // 재귀 말단에서 조건에 만족하는 격자판의 상태가 만들어지면서 result 카운트
        if (cnt == N * M) {
            result++;
            return;
        }

        // 1. 배치할 수 없는 경우 -> 네모를 놓지 않고 다음 칸 확인 (좌단과 상단 마진은 모두 배치가능)
        if (row > 0 && col > 0 && check[row][col - 1] && check[row - 1][col - 1] && check[row - 1][col])
            recur(cnt + 1);
        // 2. 배치 가능한 경우 -> 해당 칸에 네모를 놓았을 때와 놓지 않았을 때, 다음 칸 배치 가능 여부를 모두 확인
        else {
            check[row][col] = true;
            recur(cnt + 1);
            check[row][col] = false;
            recur(cnt + 1);
        }
    }
}
