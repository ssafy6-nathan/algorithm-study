package study.nathan_algo_study.week12;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 문제이름 : 두 용액
 * 링크 : https://www.acmicpc.net/problem/2470
 */

public class Baekjoon2470 {
    static int N;
    static int[] arr;
    static int minSum;
    static int minIdx1;
    static int minIdx2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            arr[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(arr);

        toPointer();

        System.out.println(arr[minIdx1]+" "+arr[minIdx2]);
    }

    public static void toPointer() {
        int front = 0;
        int back = N - 1;
        minSum = Integer.MAX_VALUE;
        minIdx1 = -1;
        minIdx2 = -1;

        while (front < back) {
            int sum = arr[front] + arr[back];
            if (Math.abs(sum) < minSum) {
                minSum = Math.abs(sum);
                minIdx1 = front;
                minIdx2 = back;
            }

            if (sum > 0)
                back--;
            else if (sum < 0)
                front++;
            else
                break;
        }
    }

}

/*

-99 -2 -1 4 98

-50 -30 -5 -3 -2  70 90 150

-50 150 = 100
-50 90 = 40
-50 70 = 20
-50 -2 = -52
-30 -2 = -32
-5 -2 = -7
-3 -2 = -5

0 1 2 3 4 5 6 7 8 9

3 1 3

 */
