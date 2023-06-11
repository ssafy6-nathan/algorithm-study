package study.nathan_algo_study.week58;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 문제이름 : 연산자 끼워넣기
 * 링크 : https://www.acmicpc.net/problem/14888
 */

public class Baekjoon14888 {
    static int N;
    static int[] nums;
    static int[] op;
    static int min, max;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        op = new int[4];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            op[i] = Integer.parseInt(st.nextToken());
        }

        min = Integer.MAX_VALUE;
        max = Integer.MIN_VALUE;

        dfs(0, new int[N - 1]);
        System.out.println(max);
        System.out.println(min);
    }

    public static void dfs(int curr, int[] p) {
        if (curr == N - 1) {
            int result = calc(p);
            min = Math.min(min, result);
            max = Math.max(max, result);
            return;
        }

        for (int i = 0; i < op.length; i++) {
            if (op[i] == 0)
                continue;

            p[curr] = i;
            op[i]--;
            dfs(curr + 1, p);
            op[i]++;
        }
    }

    public static int calc(int[] p) {
        int result = nums[0];
        for (int i = 0; i < N - 1; i++) {
            switch (p[i]) {
                case 0:
                    result += nums[i + 1];
                    break;
                case 1:
                    result -= nums[i + 1];
                    break;
                case 2:
                    result *= nums[i + 1];
                    break;
                case 3:
                    result /= nums[i + 1];
                    break;
            }
        }

        return result;
    }
}

/*

 */
