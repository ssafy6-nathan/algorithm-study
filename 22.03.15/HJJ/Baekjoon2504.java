package study.nathan_algo_study.week3;

import java.io.*;
import java.util.Stack;

/**
 * 문제이름 : 괄호의 값
 * 링크 : https://www.acmicpc.net/problem/2504
 */

public class Baekjoon2504 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();

        Stack<Character> s = new Stack<>();

        boolean isValid = true;

        int result = 0;
        int tempNum = 1;
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c == '(') {
                s.push(c);
                tempNum *= 2;
            } else if (c == '[') {
                s.push(c);
                tempNum *= 3;
            } else if (c == ')') {
                if (!s.isEmpty() && s.peek() == '(') {  //제대로 쌍을 이루면
                    s.pop();

                    if (input.charAt(i - 1) == '(')    //이전에 push 했으면
                        result += tempNum;

                    tempNum /= 2;
                } else {
                    isValid = false;
                    break;
                }
            } else if (c == ']') {
                if (!s.isEmpty() && s.peek() == '[') {  //제대로 쌍을 이루면
                    s.pop();

                    if (input.charAt(i - 1) == '[')    //이전에 push 했으면
                        result += tempNum;

                    tempNum /= 3;
                } else {
                    isValid = false;
                    break;
                }
            }
        }

        if (isValid && s.isEmpty())
            System.out.println(result);
        else
            System.out.println(0);
        br.close();
    }
}

/*
(()[[]])

( () [[]] )
2 42 6126
(())[][]


( () [[]] )([])
   2   9    6

[[()[]()]]

[[(

2 3 2

스택을 pop했을 때 맨 위 문자와 다른 닫는 괄호이면 올바르지 않음
스택을 pop했을 때 맨 위 문자와 쌍이 되는 닫는 괄호이면 덧셈 값

스택을 2연속 이상 pop하는 경우 곱하기 연산


5조 3


*/
