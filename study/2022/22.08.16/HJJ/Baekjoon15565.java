package study.nathan_algo_study.week25;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * 문제이름 : 귀여운 라이언
 * 링크 : https://www.acmicpc.net/problem/15565
 */

public class Baekjoon15565 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] dolls = new int[N];
        ArrayList<Integer> index = new ArrayList<>();
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            dolls[i] = Integer.parseInt(st.nextToken());
            if (dolls[i] == 1)
                index.add(i);
        }

        System.out.println(solution(index, K));
    }

    public static int solution(ArrayList<Integer> index, int K) {
        if (index.size() < K)   //라이언 인형이 K개 이하이면
            return -1;

        int idx1 = 0;
        int idx2 = K - 1;
        int minLen = index.get(idx2) - index.get(idx1) + 1;

        for (idx2 = idx2 + 1, idx1 = idx1 + 1; idx2 < index.size(); idx2++, idx1++) {
            int currLen = index.get(idx2) - index.get(idx1) + 1;
            minLen = Math.min(currLen, minLen);
        }

        return minLen;
    }
}

/*
1 2 2 2 1 2 1 2 2 1
0 1 2 3 4 5 6 7 8 9

0 4 6 9


1 2 1 2 2 1

1 2 2 2 1 2 1





*/
