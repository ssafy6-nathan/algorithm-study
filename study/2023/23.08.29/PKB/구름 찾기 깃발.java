/*
 * 문제 : 구름 찾기 깃발
 * 링크 : https://level.goorm.io/exam/195689/%EA%B5%AC%EB%A6%84-%EC%B0%BE%EA%B8%B0-%EA%B9%83%EB%B0%9C/quiz/1
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_195689 {

    static int[][] M;
    static int[] dr = {-1, -1, -1, 0, 0, 1, 1, 1};
    static int[] dc = {-1, 0, 1, -1, 1, -1, 0, 1};
    static int N, K, answer;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        M = new int[N][N];
        answer = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {
                M[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                if (M[r][c] == 1) continue;

                int cnt = 0;

                for (int i = 0; i < 8; i++) {
                    int nr = r + dr[i];
                    int nc = c + dc[i];

                    if (nr < 0 || nr >= N || nc < 0 || nc >= N) continue;

                    if (M[nr][nc] == 1) cnt++;
                }

                if (cnt == K) answer++;
            }
        }

        System.out.println(answer);

    }

}
