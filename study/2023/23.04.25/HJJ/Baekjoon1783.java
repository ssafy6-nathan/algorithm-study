package study.nathan_algo_study.week54;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 문제이름 : 병든 나이트
 * 링크 : https://www.acmicpc.net/problem/1783
 */

public class Baekjoon1783 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int result = 0;
        if (r < 3) {
            if (r == 1)     //행이 1이면 이동 못함
                result = 1;
            else if (r == 2)  //열도 7미만이면 최대 4번까지 문제의 2,3번 방법으로만 이동 가능
                result = Math.min((c + 1) / 2, 4);
        }
        else if (c < 7)
            result = Math.min(c, 4);   //행이 3이상이면 최대 4번까지만 이동 가능
         else
            result = 5 + (c - 7);


        System.out.println(result);
    }
}

/*
최소 열이 7칸은 되야 5번 이동가능

행이 3칸 미만일 경우

열이 7칸 미만일 경우

43

5

*/
