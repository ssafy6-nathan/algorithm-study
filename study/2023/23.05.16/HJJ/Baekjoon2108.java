package study.nathan_algo_study.week56;

import java.io.*;
import java.util.*;

/**
 * 문제이름 : 통계학
 * 링크 : https://www.acmicpc.net/problem/2108
 */

public class Baekjoon2108 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        double sum = 0;
        int mid = -4001;
        int mode = -4001;
        int range = 0;

        Map<Integer, Integer> count = new HashMap<>();
        int max = -4001;
        int min = 4001;
        for (int i = 0; i < n; i++)  {
            arr[i] = Integer.parseInt(br.readLine());
            // 1.
            sum += arr[i];
            max = Math.max(max, arr[i]);
            min = Math.min(min, arr[i]);
            count.put(arr[i] ,count.getOrDefault(arr[i], 0) + 1);
        }

        // 2.
        Arrays.sort(arr);
        mid = arr[n/2];

        // 3.
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(count.entrySet());
        Collections.sort(list, (o1, o2) -> {
            if (o1.getValue() == o2.getValue()) {
                return o1.getKey() - o2.getKey();
            } else {
                return o2.getValue() - o1.getValue();
            }
        });

        if (list.size() > 1 && list.get(0).getValue() == list.get(1).getValue())
            mode = list.get(1).getKey();
        else
            mode = list.get(0).getKey();
        // 4.
        range = max - min;

        System.out.println(Math.round(sum/n));
        System.out.println(mid);
        System.out.println(mode);
        System.out.println(range);
    }
}

/*
0 -1
2  1


*/
