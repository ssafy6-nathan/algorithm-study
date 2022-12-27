package study.nathan_algo_study.week21;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 문제이름 : 가장 긴 증가하는 부분 수열 2
 * 링크 : https://www.acmicpc.net/problem/12015
 */

public class Baekjoon12015 {
    static int N;
    static int[] arr;
    static int[] seq;
    static int seqLastIdx;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        seq = new int[N + 1];
        seqLastIdx = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            arr[i] = Integer.parseInt(st.nextToken());


        for (int i = 0; i < N; i++) {
            int curr = arr[i];
            if (curr > seq[seqLastIdx])    //수열 추가
                seq[++seqLastIdx] = curr;
            else {    //수열 값 변경
                int changeIdx = binarySearch(curr);
                seq[changeIdx] = curr;
            }
        }

        System.out.println(seqLastIdx);
    }

    private static int binarySearch(int currValue) {
        int left = 0;
        int right = seqLastIdx;

        while (left < right) {
            int mid = (left + right) / 2;

            if (seq[mid] < currValue)
                left = mid + 1;
            else   // seq[mid]의 값과 같거나 이보다 작으면
                right = mid;
        }

        return left;
    }
}

/*

 */
