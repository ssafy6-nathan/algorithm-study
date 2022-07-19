package study.nathan_algo_study.week4;

import java.io.*;

/**
 * 문제이름 : 문자열 폭발
 * 링크 : https://www.acmicpc.net/problem/
 */

public class Baekjoon9935 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        String boomStr = br.readLine();

        String result = boom(str, boomStr);
        if (result.length() == 0)
            System.out.println("FRULA");
        else
            System.out.println(result);
    }

    public static String boom(String str, String boomStr) {
        int strLen = str.length();
        int boomLen = boomStr.length();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < strLen; i++) {
            sb.append(str.charAt(i));
            if (sb.length() >= boomLen) {
                boolean isEqual = true;
                for (int idx = 0; idx < boomLen; idx++) {
                    char strC = sb.charAt(sb.length() - boomLen + idx);
                    char boomC = boomStr.charAt(idx);

                    if (strC != boomC) {
                        isEqual = false;
                        break;
                    }
                }
                if (isEqual)
                    sb.delete(sb.length() - boomStr.length(), sb.length());
            }
        }


        return sb.toString();
    }
}

/*
abcedf


edf

*/
