package study.nathan_algo_study.week51;

import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

/**
 * 문제이름 : 센서
 * 링크 : https://www.acmicpc.net/problem/2212
 */

public class Baekjoon2212 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        System.out.println(minWidth(k, n, arr));
    }

    public static int minWidth(int k, int n, int[] arr) {
        if (k >= n)
            return 0;

        Arrays.sort(arr);
        Integer[] diff = new Integer[n - 1];
        for (int i = 0; i < n - 1; i++)
            diff[i] = arr[i+1] - arr[i];

        Arrays.sort(diff, Collections.reverseOrder());

        int min = 0;
        for (int i = k - 1; i < n - 1; i++)
            min += diff[i];

        return min;
    }
}

/*


1 3 6 6 7 9

diff
2 3 0 1 2

3 2 2 1 0




*/
