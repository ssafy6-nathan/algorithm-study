package week31;

import java.io.*;
import java.util.Stack;

/**
 * 백준 4949번
 * 균형잡힌 세상 (https://www.acmicpc.net/problem/4949)
 * 분류 : 자료구조, 문자열, 스택
 **/

public class BOJ_4949 {
    
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static Stack<Character> stack;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String str = br.readLine();
            if (str.equals(".")) break; // 테스트 케이스 종료조건

            stack = new Stack<>();
            balance(str);
        }
        bw.flush();
        bw.close();
    }

    static void balance(String s) throws IOException {
        boolean flag = true;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            // 1. 스택이 빈 상태에서 닫는 괄호가 나오면 불균형
            if (stack.empty() && (c == ')' || c == ']')) {
                flag = false;
                break;
            }
            // 2. 닫는 괄호가 들어왔을 때 짝이 맞지 않으면 불균형
            else if (!stack.empty() && ((c == ')' && stack.peek() != '(')) || (c == ']' && stack.peek() != '[')) {
                flag = false;
                break;
            }
            // 3. 여는 괄호는 무조건 push
            else if (c == '(' || c == '[') stack.push(c);

            // 4. 짝이 맞는 닫는 괄호이면 무조건 pop
            else if (!stack.empty() && c == ')' && stack.peek() == '(') stack.pop();
            else if (!stack.empty() && c == ']' && stack.peek() == '[') stack.pop();

            // 5. 나머지 문자는 모두 무시
            else continue;
        }
        // 균형 판정 후 출력
        if (!stack.empty() || !flag) bw.write("no" + "\n");
        else bw.write("yes" + "\n");
    }
}
