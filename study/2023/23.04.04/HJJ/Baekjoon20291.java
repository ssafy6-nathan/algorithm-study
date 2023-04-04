package study.nathan_algo_study.week51;

import java.io.*;
import java.util.Map;
import java.util.TreeMap;

/**
 * 문제이름 : 파일 정리
 * 링크 : https://www.acmicpc.net/problem/20291
 */

public class Baekjoon20291 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Map<String, Integer> map = new TreeMap<>();

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            String ext = br.readLine().split("\\.")[1];
            map.put(ext, map.getOrDefault(ext, 0) + 1);
        }

        for (Map.Entry<String, Integer> entry : map.entrySet())
            bw.write(entry.getKey() + " " + entry.getValue() + "\n");

        bw.close();
    }
}

/*

*/
