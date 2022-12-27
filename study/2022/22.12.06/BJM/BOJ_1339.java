package week39;

import java.io.*;
import java.util.Arrays;

/**
 * 백준 1339번
 * 단어 수학 (https://www.acmicpc.net/problem/1339)
 * 분류 : 그리디 알고리즘
 **/
public class BOJ_1339 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] alphabet = new int[26];

        for (int i = 0; i < N; i++) {
            // 1. 단어 입력
            String word = br.readLine();
            int len = word.length();
            // 2. 알파벳 자리에 맞게 10의 제곱수 누적
            for (int j = 0; j < len; j++) {
                int n = word.charAt(j) - 'A'; // 알파벳 아스키코드 (= 배열 인덱스)
                alphabet[n] += Math.pow(10, (len-1) - j);
            }
        }
        // 3. 알파벳 배열 정렬
        Arrays.sort(alphabet);

        // 4. 배열 내림차순으로 가장 값이 높은 숫자 배정
        int answer = 0;
        int num = 9;
        for (int i = alphabet.length - 1; i >= 0; i--) {
            if (alphabet[i] <= 0) continue;
            answer += alphabet[i] * (num--);
        }
        System.out.println(answer);
    }
}
