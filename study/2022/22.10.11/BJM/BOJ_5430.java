package week31;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

/**
 * 백준 5430번
 * AC (https://www.acmicpc.net/problem/5430)
 * 분류 : 구현, 자료 구조, 문자열, 파싱, 덱
 **/

public class BOJ_5430 {

    static BufferedWriter bw  = new BufferedWriter(new OutputStreamWriter(System.out));
    static Deque<Integer> deque;
    static boolean reverse; // 덱 방향 판별
    static boolean error; // 오류 판별

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T, n; // T: 테스트케이스 개수 & n: 배열의 숫자 개수
        String command, number; // command: 명령어 문자열 & number: 숫자 배열
        StringTokenizer st; // 숫자 배열 분리용

        T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            // 0. 초기화
            reverse = false;
            error = false;

            // 1. 입력 (명령어, 숫자 개수, 숫자 배열)
            command = br.readLine();
            n = Integer.parseInt(br.readLine());
            number = br.readLine();

            // 2. 덱 생성, 숫자 배열 파싱 후 데이터 입력
            deque = new ArrayDeque<>();
            if (n != 0) { // 빈 배열이 아닐 경우에만 파싱
                number = number.substring(1, number.length() - 1); // 대괄호 분리 (첫 문자와 끝 문자)
                st = new StringTokenizer(number, ","); // 반점 기준으로 분리
                for (int j = 0; j < n; j++)
                    deque.add(Integer.parseInt(st.nextToken()));
            }
            // 3. 명령어 수행
            for (int j = 0; j < command.length(); j++) {
                char c = command.charAt(j);
                switch(c) {
                    case 'R':
                        R();
                        break;
                    case 'D':
                        D();
                        break;
                    default:
                        break;
                }
            }
            // 4. 출력
            print();
            bw.flush();
            bw.newLine();
        }
        bw.close();

    }

    // Reverse
    static void R() {
        reverse = !reverse;
    }

    // Delete
    static void D() {
        if (deque.isEmpty()) error = true; // 비어 있는 덱이라면 오류
        else if (!reverse) deque.remove(); // 정방향 삭제
        else deque.removeLast(); // 역방향 삭제
    }

    // Print
    static void print() throws IOException {
        // 에러 발생
        if (error) bw.write("error");

        // 정방향 출력
        else if (!reverse) {
            bw.write("[");
            while(!deque.isEmpty()) {
                bw.write(deque.removeFirst()+"");
                if(deque.isEmpty()) break;
                bw.write(",");
            }
            bw.write("]");
        }

        // 역방향 출력
        else {
            bw.write("[");
            while(!deque.isEmpty()) {
                bw.write(deque.removeLast()+"");
                if(deque.isEmpty()) break;
                bw.write(",");
            }
            bw.write("]");
        }
    }
}
