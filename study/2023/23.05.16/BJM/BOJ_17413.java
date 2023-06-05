package week56;

import java.io.*;
import java.util.*;

/**
 * 백준 17413번
 * 단어 뒤집기 2 (https://www.acmicpc.net/problem/17413)
 * 분류 : 구현, 자료 구조, 문자열, 스택
 **/

public class BOJ_17413 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Character> stack = new Stack<>(); // 문자열을 반대로 출력하기 위한 스택
        StringBuilder sb = new StringBuilder();
        String S = br.readLine();

        int idx = 0;
        while (idx < S.length()) {
            char c = S.charAt(idx);
            // 1. 부등호를 만난 경우 (뒤집지 않음)
            if (c == '<') {
                int i = 0;
                // 닫는 부호를 만날 때 까지 그대로 sb에 저장
                while (true) {
                    char token = S.charAt(idx + i);
                    if (token == '>') { // 종료 조건
                        sb.append(token);
                        idx += i + 1;
                        break;
                    }
                    sb.append(token);
                    i++;
                }
            }
            // 2. 일반 문자를 만난 경우 (뒤집음)
            else {
                int i = 0;
                while (true) {
                    // 최종 종료 조건: 마지막 문자까지 스택에 들어간 경우
                    if (idx + i > S.length() - 1) {
                        while (!stack.empty()) sb.append(stack.pop());
                        idx += i;
                        break;
                    }
                    char token = S.charAt(idx + i);
                    // 종료조건 1: 공백을 만난 경우 그대로 sb에 저장하고 종료
                    if (token == ' ') {
                        while (!stack.empty()) sb.append(stack.pop());
                        sb.append(token);
                        idx += i + 1;
                        break;
                    }
                    // 종료조건 2: 부등호를 만난 경우 다음 조건문에서 처리함
                    else if (token == '<') {
                        while (!stack.empty()) sb.append(stack.pop());
                        idx += i;
                        break;
                    }
                    // 스택에 순서대로 저장
                    else stack.push(token);
                    i++;
                }
            }
        }

        System.out.println(sb);
    }
}
