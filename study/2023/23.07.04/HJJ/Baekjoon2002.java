package study.nathan_algo_study.week60;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * 문제이름 : 추월
 * 링크 : https://www.acmicpc.net/problem/2002
 */

public class Baekjoon2002 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Map<String, Integer> startOrder = new HashMap<>();
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++)
            startOrder.put(br.readLine(), i);

        String[] finishOrder = new String[n];
        for (int i = 0; i < n; i++)
            finishOrder[i] = br.readLine();

        int cnt = 0;
        for (int i = 0; i < n; i++) {
            int startIdx = startOrder.get(finishOrder[i]);

            for (int j = i + 1; j < n; j++) {
                int idx = startOrder.get(finishOrder[j]);
                if (startIdx > idx) {
                    cnt++;
                    break;
                }
            }
        }

        System.out.println(cnt);

    }
}

/*
자신의 다음 순서에 자신보다 작은 순번이 오면 추월 한 것

1
2
3
4
5

2
5
4
1
3


1
2
3
4

4
1
2
3

1
3
2
4


*/
