package study.nathan_algo_study.week17;

import java.io.*;

/**
 * 문제이름 : 책 페이지
 * 링크 : https://www.acmicpc.net/problem/1019
 */

public class Baekjoon1019 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] nums = new int[10];
        int start = 1;
        int point = 1;

        while (start <= n) {
            while (n % 10 != 9 && start <= n) {
                cal(n, nums, point);
                n--;
            }

            if (n < start)
                break;

            while (start % 10 != 0 && start <= n) {
                cal(start, nums, point);
                start++;
            }

            start /= 10;
            n /= 10;

            for (int i = 0; i < 10; i++)
                nums[i] += (n - start + 1) * point;

            point *= 10;
        }

        for (int i = 0; i < 10; i++)
            System.out.print(nums[i] + " ");
        System.out.println();
    }

    public static void cal(int n, int[] arr, int idx) {
        while (n > 0) {
            arr[n % 10] += idx;
            n /= 10;
        }
    }
}

/*
1 ~ 10
1 2 3 4 5 6 7 8 9 10
1 2 1 1 1 1 1 1 1 1

1 ~ 9
0 1 1 1 1 1 1 1 1 1

11 ~ 20
11 12 13 14 15 16 17 18 19 20

1 10 2 1 1 1 1 1 1 1

1 ~`19
1 12 2 2 2 2 2 2 2 2




*/
