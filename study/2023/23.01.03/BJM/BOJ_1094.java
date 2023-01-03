import java.io.*;

/**
 * 백준 1094번
 * 막대기 (https://www.acmicpc.net/problem/1094)
 * 분류 : 수학, 비트마스킹
 **/
public class BOJ_1094 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int X = Integer.parseInt(br.readLine());
        int stick = 64; // 반으로 자른 막대기 길이
        int count = 1; // 막대기 개수
        int goal = 0; // 이어붙인 막대기 길이

        // 1. X보다 작거나 같은 2의 제곱수 찾기 (작아지는 시점에서 바로 반복종료)
        while (stick >= X) {
            if (stick == X) break;
            stick = stick >> 1;
        }
        // 2. 위의 결과를 저장
        goal = stick;

        // 3. 길이가 X가 될 때 까지 자르고 붙이기를 반복
        while (goal != X) {
            int part = stick >> 1; // 자르기
            // 3-1. 자르고 붙인 결과가 X보다 크면, 붙이지 않음
            if (goal + part > X) {
                stick = stick >> 1;
            }
            // 3-2. 자르고 붙인 결과가 X보다 작으면, 붙임
            else if (goal + part < X) {
                goal += part;
                stick = stick >> 1;
                count++;
            }
            // 3-3. goal = X 가 된 경우 마지막 막대기 개수 카운트 후 종료
            else {
                goal += part;
                count++;
                break;
            }
        }
        System.out.println(count);
    }
}