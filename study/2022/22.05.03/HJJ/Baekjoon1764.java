package study.nathan_algo_study.week10;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.StringTokenizer;

/**
 * 문제이름 : 듣보잡
 * 링크 : https://www.acmicpc.net/problem/1764
 */

public class Baekjoon1764 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        HashSet<String> set = new HashSet<>();
        ArrayList<String> people = new ArrayList<>();

        for (int i = 0; i < N; i++)
            set.add(br.readLine());

        for (int i = 0; i < M; i++) {
            String input = br.readLine();
            if (set.contains(input))
                people.add(input);
        }

        Collections.sort(people);
        System.out.println(people.size());
        for (String person : people) {
            System.out.println(person);
        }

    }
}

/*

 */
