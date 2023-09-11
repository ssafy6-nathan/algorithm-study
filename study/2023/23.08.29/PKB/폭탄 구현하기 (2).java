/*
 * 문제 : 폭탄 구현하기 (2)
 * 링크 : https://level.goorm.io/exam/195691/%ED%8F%AD%ED%83%84-%EA%B5%AC%ED%98%84%ED%95%98%EA%B8%B0-2/quiz/1
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_195691 {

    static char[][] map;
    static int[][] bombs;
    static int N, K;
    static int[] dr = {0, -1, 1, 0, 0};
    static int[] dc = {0, 0, 0, -1, 1};

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new char[N][N];
        bombs = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {
                map[i][j] = st.nextToken().charAt(0);
            }
        }

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());

            int y = Integer.parseInt(st.nextToken()) - 1;
            int x = Integer.parseInt(st.nextToken()) - 1;

            pop(y, x);
        }

        int max = Integer.MIN_VALUE;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                max = Math.max(max, bombs[i][j]);
            }
        }

        System.out.println(max);

    }

    static void pop(int y, int x) {

        for (int d = 0; d < 5; d++) {
            int ny = y + dr[d];
            int nx = x + dc[d];

            if (ny < 0 || ny >= N || nx < 0 || nx >= N) continue;

            if (map[ny][nx] == '0') bombs[ny][nx]++;
            else if (map[ny][nx] == '@') bombs[ny][nx] += 2;
        }

    }

}
