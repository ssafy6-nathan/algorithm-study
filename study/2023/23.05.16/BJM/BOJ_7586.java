package week56;

import java.io.*;
import java.util.*;

/**
 * 백준 7568번
 * 덩치 (https://www.acmicpc.net/problem/7568)
 * 분류 : 구현, 브루트포스 알고리즘
 **/

public class BOJ_7586 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int[][] info = new int[N][2];
        int[] rank = new int[N];
        Arrays.fill(rank, 1);
        StringTokenizer st;

        // 1. 정보 저장
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            info[i][0] = Integer.parseInt(st.nextToken()); // 몸무게
            info[i][1] = Integer.parseInt(st.nextToken()); // 키
        }

        // 2. 몸무게와 키를 하나씩 비교
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                // 키와 몸무게가 더 낮은 쪽에 카운팅
                if (info[i][0] < info[j][0] && info[i][1] < info[j][1])
                    rank[i]++;
                if (info[i][0] > info[j][0] && info[i][1] > info[j][1])
                    rank[j]++;
            }
        }

        for (int i : rank) bw.write(i + " ");
        bw.close();
    }
}
