package week58;

import java.io.*;
import java.util.*;

/**
 * 백준 14888번
 * 연산자 끼워넣기 (https://www.acmicpc.net/problem/14888)
 * 분류 : 브루트포스 알고리즘, 백트래킹
 **/
public class BOJ_14888 {
    static int N; // 숫자 개수
    static int max; // 최대 결과
    static int min; // 최소 결과
    static int[] number; // 숫자
    static int[] operator; // 연산자

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        max = Integer.MIN_VALUE;
        min = Integer.MAX_VALUE;

        // 숫자 입력받기
        N = Integer.parseInt(br.readLine());
        number = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            number[i] = Integer.parseInt(st.nextToken());

        // 연산자 입력받기
        // 연산자 4개 (0: 덧셈, 1: 뺄셈, 2: 곱셈, 3: 나눗셈) 순서대로 연산자의 개수 입력
        operator = new int[4];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++)
            operator[i] = Integer.parseInt(st.nextToken());

        dfs(number[0], 1);
        System.out.println(max);
        System.out.println(min);
    }

    public static void dfs (int num, int idx) {
        // 모든 숫자를 사용한 경우 최대, 최소값 판별하여 정답 갱신
        if (idx == N) {
            max = Math.max(max, num);
            min = Math.min(min, num);
            return;
        }
        
        // i: 연산자 인덱스
        for (int i = 0; i < 4; i++) {
            // 연산자가 하나라도 있을 경우 진행
            if (operator[i] > 0) {
                operator[i]--;
                // 연산자에 따라 분기
                switch (i) {
                    case 0: // 덧셈
                        dfs(num + number[idx], idx + 1);
                        break;
                    case 1: // 뺄셈
                        dfs(num - number[idx], idx + 1);
                        break;
                    case 2: // 곱셈
                        dfs(num * number[idx], idx + 1);
                        break;
                    case 3: // 나눗셈
                        dfs(num / number[idx], idx + 1);
                        break;
                }
                // 재귀 종료 후, 다른 경로 탐색을 위해 연산자 개수 복구
                operator[i]++;
            }
        }
    }
}