package week54;

import java.io.*;
import java.util.*;

/**
 * 백준 9996번
 * 한국이 그리울 땐 서버에 접속하지 (https://www.acmicpc.net/problem/9996)
 * 분류 : 문자열, 정규 표현식
 **/
public class BOJ_9996 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), "*"); // 패턴 입력
        String startPattern = st.nextToken(); // 시작패턴
        String endPattern = st.nextToken(); // 끝패턴

        boolean isCorrect;
        for (int n = 0; n < N; n++) {
            String str = br.readLine();
            // 0. 문자열의 길이가 유효한지 확인
            if ((startPattern.length() + endPattern.length()) > str.length()) {
                bw.write("NE\n");
                continue;
            }
            isCorrect = true;
            // 1. 시작패턴 확인
            for (int i = 0; i < startPattern.length(); i++) {
                if (startPattern.charAt(i) != str.charAt(i)) {
                    bw.write("NE\n");
                    isCorrect = false;
                    break;
                }
            }
            if (!isCorrect) continue; // 시작패턴부터 같지 않으면 즉시 확인 종료
            // 2. 끝패턴 확인
            for (int i = endPattern.length() - 1; i >= 0; i--) {
                if (endPattern.charAt(i) != str.charAt(str.length() - endPattern.length() + i)) {
                    bw.write("NE\n");
                    isCorrect = false;
                    break;
                }
            }
            if (isCorrect) bw.write("DA\n"); // 양끝패턴이 모두 일치할 경우에만 "DA" 출력
        }
        bw.close();
    }
}