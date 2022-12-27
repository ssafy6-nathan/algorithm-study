package study.nathan_algo_study.week20;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 문제이름 : 부분수열의 합
 * 링크 : https://www.acmicpc.net/problem/1182
 */

public class Baekjoon1182 {
    static int N, S;
    static int[] arr;
    static int result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        result = 0;
        perm(0, new boolean[N], 0);

        System.out.println(result);
    }

    public static void perm(int cnt, boolean[] v, int pSum) {
        if (cnt == N) {
            if (!isEmptySet(v) && S == pSum)
                result++;

            return;
        }

        v[cnt] = true;
        pSum += arr[cnt];
        perm(cnt+1, v, pSum);

        v[cnt] = false;
        pSum -= arr[cnt];
        perm(cnt+1, v, pSum);
    }

    public static boolean isEmptySet(boolean[] v) {
        for (int i = 0; i < N; i++) {
            if (v[i])
                return false;
        }
        return true;
    }
}

/*

*/
