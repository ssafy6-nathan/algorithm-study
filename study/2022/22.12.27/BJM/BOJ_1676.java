package week42;

import java.io.*;

/**
 * 백준 1676번
 * 팩토리얼 0의 개수 (https://www.acmicpc.net/problem/1676)
 * 분류 : 수학, 임의 정밀도 / 큰 수 연산
 **/
public class BOJ_1676 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int answer = 0;
        // 인수 2, 5의 조합이 존재할 경우 경우 뒷 자리 0, 즉 10이 될 수 있음
        // 5는 2보다 수가 적으므로, 5의 제곱수로 나누어지는지 확인
        // 문제의 최대 범위가 500이므로 5의 제곱수는 125까지만 고려
        for (int i = 5; i <= N; i++) {
            if (i % 125 == 0) {
                answer += 3;
            } else if (i % 25 == 0) {
                answer += 2;
            } else if (i % 5 == 0){
                answer++;
            }
        }
        System.out.println(answer);
    }
}
