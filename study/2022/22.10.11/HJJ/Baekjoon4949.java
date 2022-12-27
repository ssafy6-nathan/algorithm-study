package study.nathan_algo_study.week31;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

/**
 * 문제이름 : 균형잡힌 세상
 * 링크 : https://www.acmicpc.net/problem/4949
 */

public class Baekjoon4949 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        String input;
        while (!(input = br.readLine()).equals(".")) {
            if (isValidation(input))
                bw.write("yes\n");
            else
                bw.write("no\n");

        }
        bw.close();
    }

    public static boolean isValidation(String str) {
        Deque<Character> stack = new ArrayDeque<>();

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else if (c == ')') {
                if (stack.isEmpty() || stack.peek() != '(')
                    return false;
                else
                    stack.pop();
            } else if (c == '}') {
                if (stack.isEmpty() || stack.peek() != '{')
                    return false;
                else
                    stack.pop();
            } else if (c == ']') {
                if (stack.isEmpty() || stack.peek() != '[')
                    return false;
                else
                    stack.pop();
            }
        }

        if (stack.isEmpty())
            return true;
        else
            return false;
    }
}

/*



*/
