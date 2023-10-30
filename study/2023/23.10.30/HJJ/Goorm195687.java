package study.nathan_algo_study.week66;

import java.io.*;
import java.util.*;

/**
 * 문제이름 : 이진수 정렬
 * 링크 : https://level.goorm.io/exam/195687/%EC%9D%B4%EC%A7%84%EC%88%98-%EC%A0%95%EB%A0%AC/quiz/1
 */

public class Goorm195687 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N, K;
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < N; i++)
            list.add(Integer.parseInt(st.nextToken()));

        list.sort((o1, o2) ->
            (Integer.bitCount(o1) != Integer.bitCount(o2))
                    ? Integer.bitCount(o2) - Integer.bitCount(o1)
                    : o2 - o1);

        System.out.println(list.get(K-1));
    }
}

/*

*/
