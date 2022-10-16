package week32;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 백준 15652번
 * N과 M (4) (https://www.acmicpc.net/problem/15652)
 * 분류 : 백트래킹
 **/
public class BOJ_15652 {

    static BufferedWriter bw;
    static int N, M; // N: 숫자 범위, M: 출력 개수
    static int[] seq; // 수열 저장

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        seq = new int[M];
        dfs(0);
        bw.close();
    }

    private static void dfs(int count) throws IOException {
        if (count == M) { // M개를 모두 골랐을 경우 한 줄 출력
            for (int i = 0; i < seq.length; i++)
                bw.write(seq[i] + " ");
            bw.newLine();
        } else {
            for (int i = 1; i <= N; i++) {
                // 조건1: seq[0] 채우기
                // 조건2: seq[count]의 숫자는 seq[count-1]의 숫자보다 무조건 크거나 같음
                if (count == 0 || (count != 0 && seq[count - 1] <= i)) {
                    seq[count] = i;
                    dfs(count + 1);
                }
            }
        }
    }
}
