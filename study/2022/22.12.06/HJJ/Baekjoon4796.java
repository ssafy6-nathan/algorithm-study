package study.nathan_algo_study.week39;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 문제이름 : 캠핑
 * 링크 : https://www.acmicpc.net/problem/4796
 */

public class Baekjoon4796 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int t = 1;
        while (true) {
            st = new StringTokenizer(br.readLine());
            int L = Integer.parseInt(st.nextToken());
            int P = Integer.parseInt(st.nextToken());
            int V = Integer.parseInt(st.nextToken());

            if (L == 0)
                break;

            int quotient = V / P;
            int remainder = V % P;

            int result = L * quotient;
            result += (remainder < L) ? remainder : L;

            bw.write(String.format("Case %d: %d\n", t++, result));
        }
        bw.close();
    }
}

/*
연속하는 P일 중 L일 동안 사용가능
V일 휴가

L P V
5 8 20

8일 중 5일 사용 가능

16 10



*/
