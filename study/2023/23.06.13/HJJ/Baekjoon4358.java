package study.nathan_algo_study.week58;

import java.io.*;
import java.util.*;

/**
 * 문제이름 : 생태학
 * 링크 : https://www.acmicpc.net/problem/4358
 */

public class Baekjoon4358 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Map<String, Integer> treeMap = new TreeMap<>();
        String treeName = null;
        int cnt = 0;
        while ((treeName = br.readLine()) != null) {
            treeMap.put(treeName, treeMap.getOrDefault(treeName, 0) + 1);
            cnt++;
        }

        List<Map.Entry<String, Integer>> entryList = new ArrayList<>(treeMap.entrySet());

        for (Map.Entry<String, Integer> entry : entryList) {
            String name = entry.getKey();
            double value = (double)entry.getValue() / cnt * 100;

            bw.write(String.format("%s %.4f\n", name, value));
        }
        bw.close();
    }
}

/*

*/
