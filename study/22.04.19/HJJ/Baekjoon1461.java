package study.nathan_algo_study.week8;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 문제이름 : 도서관
 * 링크 : https://www.acmicpc.net/problem/
 */

public class Baekjoon1461 {
    static int N, M;
    static int[] books;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        books = new int[N];

        st = new StringTokenizer(br.readLine());
        int maxValue = 0;
        for (int i = 0; i < N; i++) {
            books[i] = Integer.parseInt(st.nextToken());
            if (Math.abs(books[i]) > Math.abs(maxValue))
                maxValue = books[i];
        }

        Arrays.sort(books);

        Queue<Integer> pos = new LinkedList<>();
        Queue<Integer> neg = new LinkedList<>();

        for (int i = N - 1; i >= 0; i--) {
            if (books[i] < 0)
                break;
            pos.add(books[i]);
        }

        for (int i = 0; i < N; i++) {
            if (books[i] > 0)
                break;
            neg.add(Math.abs(books[i]));
        }

        int result = 0;
        result += getResult(pos);
        result += getResult(neg);

        result -= Math.abs(maxValue);
        System.out.println(result);
    }

    private static int getResult(Queue<Integer> q) {
        int result = 0;
        while (!q.isEmpty()) {
            int book = q.poll();
            for (int i = 0; i < M - 1; i++) {
                q.poll();
                if (q.isEmpty())
                    break;
            }

            result += book * 2;
        }
        return result;
    }
}

/*
-39 -37 -29 -28 -6 2 11

22
12
58
39

34 + 58 + 39 = 92 + 39 = 131


*/
