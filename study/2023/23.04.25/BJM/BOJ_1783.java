package week54;

import java.io.*;
import java.util.*;

/**
 * 백준 1783번
 * 병든 나이트 (https://www.acmicpc.net/problem/1783)
 * 분류 : 구현, 그리디 알고리즘, 많은 조건 분기
 **/
public class BOJ_1783 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken()); // 행 길이 = 세로 길이
        int c = Integer.parseInt(st.nextToken()); // 열 길이 = 가로 길이

        // 1. 행 길이가 1인 경우: 이동방법 4가지 모두 사용 불가
        if (r == 1) System.out.println(1);
        // 2. 행 길이가 2인 경우: 이동방법 2와 3만 사용 가능 (대신 이동 횟수 4번 미만으로 제한)
        if (r == 2) System.out.println(Math.min((c+1)/2, 4));
        // 3. 행 길이가 3 이상일 경우 두 경우로 분기
        if (r >= 3) {
            // 3-1. 열 길이가 7 미만인 경우: 우측으로 한 칸씩만 움직일 수 있는 1, 4번 이동방법 사용 (횟수 4번 미만 제한)
            if (c < 7) System.out.println(Math.min(c, 4));
                // 3-2. 열 길이가 7 이상인 경우: c = 7일때 1 ~ 4번을 모두 사용 가능(5칸 확보)
                // 그 이후는 우측으로 한 칸씩 움직이는 1, 4번 사용
            else System.out.println(c-2); // 5+(c-7)
        }
    }
}