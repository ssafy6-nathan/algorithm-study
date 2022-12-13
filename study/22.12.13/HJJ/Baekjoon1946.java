package study.nathan_algo_study.week40;

import java.io.*;
import java.util.*;

/**
 * 문제이름 : 신입 사원
 * 링크 : https://www.acmicpc.net/problem/1946
 */

public class Baekjoon1946 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int tc = Integer.parseInt(br.readLine());
        Grade[] grades;
        int result;
        for (int t = 0; t < tc; t++) {
            int n = Integer.parseInt(br.readLine());
            grades = new Grade[n];
            result = 0;
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                int doc = Integer.parseInt(st.nextToken());
                int itv = Integer.parseInt(st.nextToken());

                grades[i] = new Grade(doc, itv);
            }

            Arrays.sort(grades, Comparator.comparingInt(o -> o.document));

            result++;
            int lastPickIdx = 0; //서류 1등은 무조건 뽑음
            for (int i = 1; i < n; i++) {
                if (grades[i].interview < grades[lastPickIdx].interview) {
                    result++;
                    lastPickIdx = i;
                }
            }

            bw.write(result+"\n");
        }
        bw.close();
    }
}

class Grade {
    int document;
    int interview;

    public Grade(int document, int interview) {
        this.document = document;
        this.interview = interview;
    }

}

/*
서류 오름차순 정렬




*/
