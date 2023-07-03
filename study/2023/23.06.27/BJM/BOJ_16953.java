package week59;

import java.io.*;
import java.util.*;

/**
 * 백준 16953번
 * A → B (https://www.acmicpc.net/problem/16953)
 * 분류 : 그래프 이론, 그리디 알고리즘, 그래프 탐색, 너비 우선 탐색
 **/
public class BOJ_16953 {
    static int numA, numB, answer;
    static boolean isCorrect;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        numA = Integer.parseInt(st.nextToken());
        numB = Integer.parseInt(st.nextToken());
        isCorrect = false;
        answer = Integer.MAX_VALUE;

        recur(1, numA, numB);

        if(isCorrect) System.out.println(answer);
        else System.out.println(-1);
    }

    public static void recur(int cnt, long start, long goal) {
        if (start >= goal) {
            if (start == goal) {
                isCorrect = true;
                answer = Math.min(answer, cnt);
            }
        } else {
            recur(cnt + 1, start * 2, goal);
            if (!isCorrect)
                recur(cnt + 1, start * 10 + 1, goal);
        }
    }

}
