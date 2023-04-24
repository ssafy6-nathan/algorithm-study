package study.nathan_algo_study.week54;

import java.io.*;
import java.util.regex.Pattern;

/**
 * 문제이름 : 한국이 그리울 땐 서버에 접속하지
 * 링크 : https://www.acmicpc.net/problem/9996
 */

public class Baekjoon9996 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        String patternStr = br.readLine().replace("*",".*");

        Pattern pattern = Pattern.compile(patternStr);

        for (int i = 0; i < n; i++) {
            if (pattern.matcher(br.readLine()).matches())
                bw.write("DA\n");
            else
                bw.write("NE\n");
        }

        bw.close();
    }
}

/*
3
a.*d
abcd
anestonestod
facebook
*/
