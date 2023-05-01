package week51;

import java.io.*;
import java.util.*;

/**
 * 백준 2170번
 * 선 긋기 (https://www.acmicpc.net/problem/2170)
 * 분류 : 정렬, 스위핑
 **/
public class BOJ_2170 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[][] point = new int[N][2];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            point[i][0] = Integer.parseInt(st.nextToken());
            point[i][1] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(point, (o1, o2) -> {
            if (o1[0] == o2[0]) {
                return Integer.compare(o1[1], o2[1]);
            } else {
                return Integer.compare(o1[0], o2[0]);
            }
        });

        int start = point[0][0]; // x
        int end = point[0][1]; // y
        int length = 0; // 총 길이

        for (int i = 1; i < N; i++) {
            int curX = point[i][0];
            int curY = point[i][1];

            // 현재 시작점이 이전 끝점보다 크면 끊어진 선이므로 start, end 갱신 후 현재까지 구한 총 길이 저장
            if (curX > end) {
                length += end - start;
                start = curX;
                end = curY;
            }
            // 그렇지 않으면 curY와 end(이전의 최대 y값)을 비교하여 end 갱신
            else if (curY > end)
                end = curY;
        }

        length += end - start; // 반복 종료시 이제까지 계산한 선 길이 저장
        System.out.println(length);
    }
}