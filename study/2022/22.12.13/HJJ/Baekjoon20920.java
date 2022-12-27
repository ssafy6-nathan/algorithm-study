package study.nathan_algo_study.week40;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

/**
 * 문제이름 : 영단어 암기는 괴로워
 * 링크 : https://www.acmicpc.net/problem/20920
 */

public class Baekjoon20920 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            if (input.length() >= m)
                map.put(input, map.getOrDefault(input, 0) + 1);
        }

        List<String> words = map.keySet().stream().collect(Collectors.toList());

        words.sort((w1, w2) -> {
            int cnt1 = map.get(w1);
            int cnt2 = map.get(w2);

            if (cnt1 == cnt2) {
                if (w1.length() == w2.length())
                    return w1.compareTo(w2);    //사전순으로 앞에 있는 단어일수록
                else
                    return w2.length() - w1.length();   //단어 길이가 길수록
            }
            return cnt2 - cnt1; //자주나올수록
        });

        for (String s : words)
            bw.write(s+"\n");
        bw.close();
    }
}

/*

 */
