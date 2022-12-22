package week42;

import java.io.*;

/**
 * 백준 17175번
 * 피보나치는 지겨웡~ (https://www.acmicpc.net/problem/17175)
 * 분류 : 다이나믹 프로그래밍
 **/
public class BOJ_17175 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        if (n < 2) System.out.println(1);

        // fibo(n)의 호출 횟수 = (fibo(n-2)의 호출 횟수 + fibo(n-1)의 호출 횟수) + 1
        else {
            int[] count = new int[n+1];
            count[0] = 1;
            count[1] = 1;
            for (int i = 2; i <= n; i++) {
                count[i] = (count[i-2] + count[i-1] + 1) % 1000000007;
            }
            System.out.println(count[n]);
        }
    }
}
