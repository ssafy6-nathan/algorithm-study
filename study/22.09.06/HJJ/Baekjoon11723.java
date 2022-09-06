package study.nathan_algo_study.week28;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 문제이름 : 집합
 * 링크 : https://www.acmicpc.net/problem/11723
 */

public class Baekjoon11723 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int M = Integer.parseInt(br.readLine());
        int S = 0;

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();
            int x;
            switch (cmd) {
                case "add":
                    x = Integer.parseInt(st.nextToken());
                    S |= 1 << (x - 1);
                    break;
                case "remove":
                    x = Integer.parseInt(st.nextToken());
                    S &= ~(1 << (x - 1));
                    break;
                case "check":
                    x = Integer.parseInt(st.nextToken());
                    bw.write(((S & (1 << (x-1))) > 0) ? 1 + "\n" : 0 + "\n");
                    break;
                case "toggle":
                    x = Integer.parseInt(st.nextToken());
                    S ^= 1 << (x-1);
                    break;
                case "all":
                    S = (1<<21) - 1;
                    break;
                case "empty":
                    S = 0;
            }
        }
        bw.close();
    }
}

/*
1011
0010

1001

1011
0100

1111


*/
