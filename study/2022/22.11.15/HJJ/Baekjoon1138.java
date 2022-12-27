package study.nathan_algo_study.week36;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * 문제이름 : 한 줄로 서기
 * 링크 : https://www.acmicpc.net/problem/1138
 */

public class Baekjoon1138 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        ArrayList<Integer> arr = new ArrayList<>();
        int N = Integer.parseInt(br.readLine());
        int[] input = new int[N];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++)
            input[i] = Integer.parseInt(st.nextToken());

        for (int i = N - 1; i >= 0; i--)
            arr.add(input[i],i+1);

        for(int n : arr)
            System.out.print(n + " ");

    }
}

/*
2 1 1 0
1 2 3 4

4
4 3
4 2 3
4 2 1 3


*/
