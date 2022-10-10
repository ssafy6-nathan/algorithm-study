package week31;
import java.io.*;

/**
 * 백준 1157번
 * 단어공부 (https://www.acmicpc.net/problem/1157)
 * 분류 : 구현, 문자열
 **/

public class BOJ_1157 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] alphabet = new int[27]; // 철자 개수 저장 배열 (중복값 초기 인덱스를 위해 26+1개 생성)
        String str; // 입력 받을 문자열
        int index = 0; // 가장 많이 나온 문자의 인덱스 저장
        int index2 = 26; // 중복된 값의 인덱스 저장 (초기값이 기존 알파벳 코드와 겹치지 않도록함)
        int max = 0; // 가장 높은 값 저장

        str = br.readLine();
        str = str.toUpperCase(); // 처리와 출력의 편의를 위해 모두 대문자로 변환

        // [1] 철자 개수 저장
        for (int i = 0; i < str.length(); i++)
            alphabet[str.charAt(i) - 65]++; // 대문자의 아스키코드값은 65~90이므로 인덱스 0부터 시작하게끔 계산

        // [2] 알파벳 배열 순회
        for (int i = 0; i < alphabet.length; i++) {
            // 2-1. 기존 최대값 보다 더 높은 값을 발견하면, max 값 갱신 후 인덱스 저장
            if (alphabet[i] > max) {
                max = alphabet[i];
                index = i;
            }
            // 2-2. 중복값을 발견하면, index2에 인덱스 저장
            else if (alphabet[i] == max) index2 = i;
        }

        // [3] 중복값 판별 후 문자 출력
        // 3-1. 최대값과 중복값이 같지 않은 경우, 이후에 최대값이 갱신된 것이므로 문자 출력
        if (alphabet[index] != alphabet[index2]) {
            char c = (char)(index + 65);
            bw.write(c);
        }
        // 3-2. 최대값과 중복값이 같은 경우, 같은 개수의 문자가 있으므로 '?' 출력
        else bw.write("?");

        bw.flush();
        bw.close();
    }
}