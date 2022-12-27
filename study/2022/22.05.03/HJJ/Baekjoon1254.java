package study.nathan_algo_study.week10;

import java.io.*;

/**
 * 문제이름 : 팰린드롬 만들기
 * 링크 : https://www.acmicpc.net/problem/1254
 */

public class Baekjoon1254 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        StringBuilder sb = new StringBuilder(str);
        int idx = str.length()-2;
        while (!palindrome(sb.toString())) {
            sb.delete(0,1);
        }

        int addLen = str.length() - sb.length();

        System.out.println(str.length() + addLen);

    }

    public static boolean palindrome(String str) {
        for (int front = 0, rear = str.length()-1; front < str.length()/2; front++,rear--) {
            if (str.charAt(front) != str.charAt(rear))
                return false;
        }

        return true;
    }
}

/*

abdfhdyrbdbsdfghjkllkjhgfds

sdfghjkllkjhgfds
27





*/
