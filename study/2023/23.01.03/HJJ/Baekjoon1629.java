package study.nathan_algo_study.week43;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 문제이름 : 곱셈
 * 링크 : https://www.acmicpc.net/problem/1629
 */

public class Baekjoon1629 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());
        long C = Long.parseLong(st.nextToken());

        System.out.println(pow(A, B, C));
    }

    public static long pow(long A, long B, long C) {
        if (B == 1)
            return A % C;

        //지수를 절반으로 나눔
        long half = pow(A, B / 2, C);

        //지수가 홀수이면 A를 한번 더 곱해줌
        if (B % 2 == 1)
            return (half * half % C) * A % C;

        return half * half % C;
    }
}

/*



 */
