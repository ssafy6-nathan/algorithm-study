package study.nathan_algo_study.week25;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 문제이름 : 세 용액
 * 링크 : https://www.acmicpc.net/problem/2473
 */

public class Baekjoon2473 {
    static long[] minValue;
    static long minSum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        long[] solutions = new long[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            solutions[i] = Long.parseLong(st.nextToken());

        minValue = new long[3];
        minSum = Long.MAX_VALUE;

        Arrays.sort(solutions);

        for (int i = 0; i < N - 2; i++) //3개의 인덱스를 검색하기 때문에 N-3까지만 순회
            solution(solutions, i, N);  //i번째 인덱스를 고정하고 나머지 2개를 투포인터 탐색

        Arrays.sort(minValue);

        for (long i : minValue)
            System.out.print(i + " ");
        System.out.println();

    }

    public static void solution(long[] arr, int idx, int N) {
        int left = idx + 1;
        int right = N - 1;

        while (left < right) {
            long sum = arr[left] + arr[right] + arr[idx];

            if (Math.abs(sum) < minSum) {
                minValue[0] = arr[left];
                minValue[1] = arr[right];
                minValue[2] = arr[idx];
                minSum = Math.abs(sum);
            }

            if (sum > 0)    //용액의 합이 양수이면 오른쪽 인덱스를 감소
                right--;
            else            //용액의 합이 음수이거나 같으면 왼쪽 인덱스를 증가
                left++;
        }
    }
}

/*
-97 -6 -2 6 98



*/
