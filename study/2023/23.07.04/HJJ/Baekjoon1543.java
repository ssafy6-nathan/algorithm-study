package study.nathan_algo_study.week60;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 문제이름 : 문서 검색
 * 링크 : https://www.acmicpc.net/problem/1543
 */

public class Baekjoon1543 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        String str = br.readLine();
        String keyword = br.readLine();

        int cnt = 0;
        for (int i = 0; i < str.length(); i++) {
            boolean isEqual = true;
            for (int j = 0; j < keyword.length(); j++) {
                if (i+j >= str.length() || str.charAt(i+j) != keyword.charAt(j)) {
                    isEqual = false;
                    break;
                }

            }

            if (isEqual) {
                cnt++;
                i += keyword.length() - 1;
            }
        }

        System.out.println(cnt);
    }
}

/*

*/
