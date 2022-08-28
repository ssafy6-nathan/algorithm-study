package study.nathan_algo_study.week27;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * 문제이름 : 킹
 * 링크 : https://www.acmicpc.net/problem/1063
 */

public class Baekjoon1063 {
    static int N;
    static int[] king;
    static int[] stone;
    static Map<String, int[]> dir;
    static String[] input;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        king = new int[2];
        stone = new int[2];
        dir = new HashMap<>();
        dir.put("R", new int[]{0, 1});  //오른쪽
        dir.put("L", new int[]{0, -1}); //왼쪽
        dir.put("B", new int[]{-1, 0}); //아래
        dir.put("T", new int[]{1, 0});  //위
        dir.put("RT", new int[]{1, 1}); //오른쪽 위
        dir.put("LT", new int[]{1, -1});//왼쪽 위
        dir.put("RB", new int[]{-1, 1});//오른쪽 아래
        dir.put("LB", new int[]{-1, -1});//왼쪽 아래

        String str = st.nextToken();
        king[1] = str.charAt(0) - 'A';
        king[0] = str.charAt(1) - '1';

        str = st.nextToken();
        stone[1] = str.charAt(0) - 'A';
        stone[0] = str.charAt(1) - '1';

        N = Integer.parseInt(st.nextToken());
        input = new String[N];
        for (int i = 0; i < N; i++)
            input[i] = br.readLine();

        solution();
        String kingPos = String.valueOf((char) ('A' + king[1])) + (king[0] + 1);
        String stonePos = String.valueOf((char) ('A' + stone[1])) + (stone[0] + 1);

        System.out.println(kingPos);
        System.out.println(stonePos);
    }

    public static void solution() {
        for (int i = 0; i < N; i++) {

            int[] moveDir = dir.get(input[i]);

            int dr = king[0] + moveDir[0];
            int dc = king[1] + moveDir[1];

            if (dr < 0 || dr >= 8 || dc < 0 || dc >= 8)
                continue;

            if (stone[0] == dr && stone[1] == dc) {
                int sr = stone[0] + moveDir[0];
                int sc = stone[1] + moveDir[1];

                if (sr < 0 || sr >= 8 || sc < 0 || sc >= 8)
                    continue;

                stone[0] = sr;
                stone[1] = sc;
            }

            king[0] = dr;
            king[1] = dc;
        }
    }
}

/*

 */
