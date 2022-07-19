package study.nathan_algo_study.week18;

import java.io.*;
import java.util.Arrays;

/**
 * 문제이름 : 검문
 * 링크 : https://www.acmicpc.net/problem/2981
 */

public class Baekjoon2981 {
    static int N;
    static int[] nums;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        nums = new int[N];
        for (int i = 0; i < N; i++)
            nums[i] = Integer.parseInt(br.readLine());

        Arrays.sort(nums);

        int gcdNum = nums[1] - nums[0];
        for (int i = 2; i < N; i++)
            gcdNum = gcd(gcdNum, nums[i] - nums[i-1]);

        //최대공약수의 약수찾기
        for (int i = 2; i <= gcdNum; i++) {
            if (gcdNum % i == 0)
                System.out.print(i+" ");
        }
    }

    public static int gcd(int n1, int n2) {
        int remainder = n1 % n2;

        if (remainder == 0)
            return n2;
        else
            return gcd(n2, remainder);
    }
}

/*




*/
