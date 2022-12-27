package study.nathan_algo_study.week14;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 문제이름 : 정렬
 * 링크 : https://www.acmicpc.net/problem/17074
 */

public class Baekjoon17074 {
    static int N;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        int idx = -1;
        int cnt = 0;
        for (int i = 0; i < N - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                idx = i;
                cnt++;
            }
        }

        System.out.println(check(idx, cnt));

    }

    public static int check(int idx, int cnt) {
        if (cnt >= 2)
            return 0;
        else if (cnt == 0)
            return N;
        else {
            if (idx == 0) {
                if (arr[idx] <= arr[idx + 2])
                    return 2;
                else
                    return 1;
            }
            if (idx == N - 2) {
                if (arr[idx - 1] <= arr[idx + 1])
                    return 2;
                else
                    return 1;
            }

            int result = 0;
            if (arr[idx-1] <= arr[idx+1])
                result++;
            if (arr[idx] <= arr[idx+2])
                result++;

            return result;
        }
    }
}

/*
1. 이미 정렬되어 있는 경우
- N개

2. 한 구간 빼고 정렬되어 있는 경우


3. 두 구간 이상 정렬되지 않은 경우
- 0개

1 2 3 2


*/
