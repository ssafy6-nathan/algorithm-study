package week32;

import java.io.*;
import java.util.*;

/**
 * 백준 1038번
 * 감소하는 수 (https://www.acmicpc.net/problem/1038)
 * 분류 : 브루트포스 알고리즘, 백트래킹
 **/

public class BOJ_1038 {

    static List<Long> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        list = new ArrayList<>(); // 감소하는 수를 저장할 리스트

        // 0~9 숫자 중 각 자릿수를 선택하거나 선택하지 않는 경우의 수는 (모두 선택하지 않는 경우를 제외한) 1023가지
        // 따라서 1023번째 부터는 감소하는 수가 있을 수 없다.
        if (N > 1022) System.out.println(-1);
        else if (N <= 10) System.out.println(N);
        else {
            for (int i = 0; i < 10; i++) { // 첫째 자리 수
                recur(i, 1);
            }
            list.sort(Comparator.naturalOrder()); // 오름차순 정렬
            System.out.println(list.get(N)); // N번째 감소하는 수 출력
        }
    }

    private static void recur(long num, int idx) {
        if (idx > 10) return; // 숫자 10개를 모두 선택하게 되면 재귀 종료

        list.add(num); // 현재 숫자 리스트에 저장
        for (int i = 0; i < num % 10; i++) { // 다음에 선택할 수는 현재 선택한 숫자(num % 10)보다 무조건 작아야함
            recur((num * 10) + i, idx + 1); // 자릿수를 늘리고 (idx+1)개의 숫자를 선택
        }
    }
}
