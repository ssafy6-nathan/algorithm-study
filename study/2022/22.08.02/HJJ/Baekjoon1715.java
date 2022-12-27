package study.nathan_algo_study.week23;

import java.io.*;
import java.util.PriorityQueue;

/**
 * 문제이름 : 카드 정렬하기
 * 링크 : https://www.acmicpc.net/problem/1715
 */

public class Baekjoon1715 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> cards = new PriorityQueue<>();
        for (int i = 0; i < N; i++)
            cards.add(Integer.parseInt(br.readLine()));

        System.out.println(cardSort(cards));
    }

    public static int cardSort(PriorityQueue<Integer> cards) {
        int n1, n2, result;
        int sum = 0;
        while (cards.size() > 1) {
            n1 = cards.poll();
            n2 = cards.poll();
            result = n1 + n2;
            sum += result;
            if (cards.isEmpty())    //마지막 계산이었으면
                break;

            cards.add(result);
        }

        return sum;
    }
}

/*

3
2
1

10
20
40

10 20 = 30
30 40 = 70

100

10
20
40
60

30
100
130
260

10 20 = 30
30 40 = 70
70 60 = 130

230

10
50
80
150
200

10 50 = 60
60 80 = 140
140 150 = 290
290 200 = 490
490 490 = 980

10 50 = 60
80 150 = 230
60 230 = 290
290 200 = 490
580 490 = 1070

40
50
60
70
200

40 50 = 90
90 60 = 150
150 70 = 220
220 200 = 420
880

40 50 = 90
60 70 = 130
90 130 = 220
220 200 = 420
440 420 = 860



*/
