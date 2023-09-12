package study.nathan_algo_study.week64;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 문제이름 : 폭탄 구현하기 (2)
 * 링크 : https://level.goorm.io/exam/195691/%ED%8F%AD%ED%83%84-%EA%B5%AC%ED%98%84%ED%95%98%EA%B8%B0-2/quiz/1
 */

public class Goorm195691 {
    static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static int[][] bombPoint;
    static char[][] map;
    static int N, K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new char[N][N];
        bombPoint = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++)
                map[i][j] = st.nextToken().charAt(0);
        }

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;

            boom(r, c);
        }

        int maxPoint = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++)
                maxPoint = Math.max(maxPoint, bombPoint[i][j]);
        }

        System.out.println(maxPoint);
    }

    public static void boom(int r, int c) {
        if (r >= 0 && r < N && c >= 0 && c < N && map[r][c] != '#') {
            if (map[r][c] == '0')
                bombPoint[r][c]++;
            else if (map[r][c] == '@')
                bombPoint[r][c] += 2;
        }

        for (int i = 0; i < dir.length; i++) {
            int dr = r + dir[i][0];
            int dc = c + dir[i][1];

            if (dr < 0 || dr >= N || dc < 0 || dc >= N || map[dr][dc] == '#')
                continue;

            if (map[dr][dc] == '0')
                bombPoint[dr][dc]++;
            else if (map[dr][dc] == '@')
                bombPoint[dr][dc] += 2;
        }
    }
}

/*

 */
