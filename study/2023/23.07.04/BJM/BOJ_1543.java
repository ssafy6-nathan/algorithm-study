package week60;

import java.io.*;

/**
 * 백준 1543번
 * 문서 검색 (https://www.acmicpc.net/problem/1543)
 * 분류 : 문자열, 브루트포스 알고리즘
 **/

public class BOJ_1543 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = 0; // 같은 문자열 개수
        int idx = 0;
        String str = br.readLine();
        String word = br.readLine();

        // 단어길이만큼 남았을 경우 이후 인덱스는 확인할 필요가 없으므로 반복횟수 조정
        while (idx <= str.length() - word.length()) {
            String piece = str.substring(idx, idx + word.length());
            // 단어 길이만큼 문자열을 확인하여 일치하는지 판단
            if (piece.equals(word)) {
                idx += word.length();
                count++;
            }
            else idx++;
        }

        System.out.println(count);
    }
}
