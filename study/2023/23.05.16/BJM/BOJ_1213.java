package week56;

import java.util.Scanner;

/**
 * 백준 1213번
 * 팰린드롬 만들기 (https://www.acmicpc.net/problem/1213)
 * 분류 : 구현, 문자열, 그리디 알고리즘
 **/
public class BOJ_1213 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[] count = new int[26];
        StringBuilder sb = new StringBuilder();
        String str = input.nextLine();

        // 1. 알파벳 카운팅
        for (int i = 0; i < str.length(); i++)
            count[str.charAt(i) - 'A']++;

        // 2. 홀수개인 알파벳 찾기
        int oddCnt = 0;
        int oddWord = 0; // 홀수인 알파벳 아스키코드
        for (int i = 0; i < count.length; i++) {
            if (oddCnt >= 2) break; // 홀수개인 알파벳이 2개 이상이 되면 팰린드롬을 만들 수 없음

            if ((count[i] % 2) != 0) {
                oddWord = i + 'A';
                oddCnt++;
            }
        }

        // 3. 팰린드롬 만들기
        if (oddCnt < 2) {
            if (oddWord != 0) { // 홀수개인 알파벳이 있는 경우 우선 배치
                sb.append((char)oddWord);
                count[oddWord - 'A']--;
            }
            // 사전 순으로 앞서게 출력하기위해 마지막 인덱스부터 순회하여 앞뒤로 알파벳을 추가함
            for (int i = count.length - 1; i >= 0; i--) {
                if (count[i] != 0) {
                    for (int j = 0; j < count[i] / 2; j++) {
                        sb.insert(0, (char)(i + 'A'));
                        sb.insert(sb.length(), (char)(i + 'A'));
                    }
                }
            }
            System.out.println(sb);
        }
        else
            System.out.println("I'm Sorry Hansoo");
    }
}