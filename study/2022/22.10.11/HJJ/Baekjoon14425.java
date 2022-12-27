package study.nathan_algo_study.week31;

import java.io.*;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

/**
 * 문제이름 : 문자열 집합
 * 링크 : https://www.acmicpc.net/problem/14425
 */

public class Baekjoon14425 {
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        Set<String> set = new HashSet<>();
        for (int i = 0; i < N; i++)
            set.add(br.readLine());

        int result = 0;
        for (int i = 0; i < M; i++) {
            if (set.contains(br.readLine()))
                result++;
        }

        System.out.println(result);
    }
}


/*
baekjoononlinejudge
startlink
codeplus
sundaycoding
codingsh


baekjoon X
codeplus O
codeminus X
startlink O
starlink X
sundaycoding O
codingsh O
codinghs X
sondaycoding X
startrink X
icerink X

*/
