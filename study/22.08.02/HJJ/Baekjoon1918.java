package study.nathan_algo_study.week23;

import java.io.*;
import java.util.Stack;

/**
 * 문제이름 : 후위 표기식
 * 링크 : https://www.acmicpc.net/problem/
 */

public class Baekjoon1918 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        System.out.println(infixToPostfix(input));
    }

    public static String infixToPostfix(String infixStr) {
        StringBuilder sb = new StringBuilder();
        Stack<Character> s = new Stack<>();
        char c;
        for (int i = 0; i < infixStr.length(); i++) {
            c = infixStr.charAt(i);
            if (Character.isAlphabetic(c)) {    //알파벳일때 (피연산자)
                sb.append(c);
            } else if (isOp(c)) {   //연산자일때
                while (!s.isEmpty() && isPriority(s.peek()) >= isPriority(c))  //현재 연산자가 스택의 top 우선순위보다 크거나 같으면 pop
                    sb.append(s.pop());

                s.add(c);
            } else if (c == '(') {  //여는 괄호이면
                s.add(c);
            } else if (c == ')') {  //닫는 괄호이면
                while (!s.isEmpty() && s.peek() != '(') //여는 괄호 만나기 전까지 스택 pop
                    sb.append(s.pop());
                s.pop();    //여는 괄호 제거
            }
        }

        while (!s.isEmpty())    //스택에 남은 문자 pop
            sb.append(s.pop());

        return sb.toString();
    }

    private static boolean isOp(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/';
    }

    private static int isPriority(char c) {
        if (c == '(')
            return 0;
        else if (c == '+' || c == '-')
            return 1;
        else
            return 2;
    }

}

/*

*/
