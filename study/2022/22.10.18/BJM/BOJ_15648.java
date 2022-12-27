package week32;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 백준 15649번
 * N과 M (1) (https://www.acmicpc.net/problem/15649)
 * 분류 : 백트래킹
 **/
public class BOJ_15648 {

    static BufferedWriter bw;
    static int N, M; // N: 숫자 범위, M: 출력 개수
    static int[] seq; // 수열 저장
    static boolean[] visited; // 방문 체크

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        visited = new boolean[N+1];
        seq = new int[M];
        dfs(0);
        bw.close();
    }

    private static void dfs(int count) throws IOException {
        if (count == M) { // M개를 모두 골랐을 경우 한 줄 출력
            for (int i = 0; i < seq.length; i++)
                bw.write(seq[i] + " ");
            bw.newLine();
        }

        else { // 이전에 사용되었던 숫자인지 확인 후 배열에 저장
            for (int i = 1; i <= N; i++) {
                if(!visited[i]) {
                    seq[count] = i;
                    visited[i] = true;
                    dfs(count+1);
                    visited[i] = false;
                }
            }
        }
    }
}
