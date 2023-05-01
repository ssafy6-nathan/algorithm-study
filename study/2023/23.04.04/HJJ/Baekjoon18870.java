package study.nathan_algo_study.week51;

import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * 문제이름 : 좌표 압축
 * 링크 : https://www.acmicpc.net/problem/18870
 */

public class Baekjoon18870 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] pos = new int[n];
        for (int i = 0; i < n; i++)
            pos[i] = Integer.parseInt(st.nextToken());

        int[] sortPos = pos.clone();
        int[] compress = new int[n];
        Map<Integer, Integer> map = new HashMap<>();
        Arrays.sort(sortPos);

        int prev = sortPos[0];
        int idx = 0;
        map.put(sortPos[0], 0);
        for (int i = 1; i < n; i++) {
            if (prev != sortPos[i]) {
                idx++;
            }

            compress[i] = idx;
            prev = sortPos[i];
            map.put(sortPos[i], compress[i]);
        }

        for (int i = 0; i < n; i++) {
            bw.write(map.get(pos[i]) + " ");
        }
        bw.close();

    }
}

/*
-10 -9 2 4 4
  0  1 2 3 3

999 999 999 1000 1000 1000
  0   0   0    1    1    1


*/
