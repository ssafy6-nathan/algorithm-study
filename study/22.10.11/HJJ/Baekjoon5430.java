package study.nathan_algo_study.week31;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

/**
 * 문제이름 : AC
 * 링크 : https://www.acmicpc.net/problem/5430
 */

public class Baekjoon5430 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        Deque<String> deque;
        int t = Integer.parseInt(br.readLine());
        String func;
        int n;
        String inputArr;
        for (int i = 0; i < t; i++) {
            func = br.readLine();
            n = Integer.parseInt(br.readLine());
            inputArr = br.readLine();
            deque = new ArrayDeque<>();
            st = new StringTokenizer(inputArr, ",[]");

            for (int j = 0; j < n; j++)
                deque.add(st.nextToken());

            bw.write(solution(func, deque));
        }
        bw.close();
    }

    public static String solution(String func, Deque<String> deque) {
        boolean error = false;
        boolean reverse = false;
        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < func.length(); j++) {
            if (func.charAt(j) == 'R')
                reverse = !reverse;
            else {  // 'D'
                if (deque.isEmpty()) {
                    error = true;
                    break;
                } else {
                    if (reverse)
                        deque.removeLast();
                    else
                        deque.removeFirst();
                }
            }
        }
        if (error)
            sb.append("error\n");
        else {
            sb.append("[");
            while (!deque.isEmpty()) {
                if (reverse)
                    sb.append(deque.removeLast());
                else
                    sb.append(deque.removeFirst());
                if (deque.size() > 0)
                    sb.append(",");
            }
            sb.append("]\n");
        }

        return sb.toString();
    }
}

/*

 */
