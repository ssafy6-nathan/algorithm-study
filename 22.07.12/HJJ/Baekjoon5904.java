package study.nathan_algo_study.week20;

import java.io.*;

/**
 * 문제이름 : Moo 게임
 * 링크 : https://www.acmicpc.net/problem/5904
 */

public class Baekjoon5904 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        searchMoo(n, 1, 3);
    }

    public static void searchMoo(int n, int k, int len) {
        int nextLen = 2 * len + k + 3;

        if (n <= 3) {
            System.out.println("moo".charAt(n - 1));
            System.exit(0);
        }

        if (nextLen < n)    //현재 moo수열의 길이가 n보다 작으면 크게 만들어줌
            searchMoo(n, k + 1, nextLen);
        else {  //n이 nextLen과 같거나 크면
            if (n > len && n <= len + k + 3) {  //moo수열의 중간에 n이 위치할 때
                if (n - len != 1)   //중간의 첫번째 문자는 m이므로 첫번째가 아니면 o
                    System.out.println("o");
                else
                    System.out.println("m");
                System.exit(0);
            } else  //n이 moo수열의 뒷쪽에 있으면 n의 앞부분(len+k+3)을 자르고 처음부터 다시 재귀 탐색
                searchMoo(n - (len + k + 3), 1, 3);
        }

    }
}

/*

S(k) = S(k-1) + "m" + ("o" x (k+2)) + S(k-1)
S(0) = 3
S(1) = 3 4 3 = 10
S(2) = 10 5 10 = 25
S(3) = 25 6 25 = 56
S(4) = 56 7 56 = 119

0 moo
1 moo mooo moo
2 moomooomoo moooo moomooomoo
3 moomooomoomoooomoomooomoo mooooo moomooomoomoooomoomooomoo



*/
