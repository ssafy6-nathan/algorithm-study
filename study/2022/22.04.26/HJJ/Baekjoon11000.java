package study.nathan_algo_study.week9;

import java.io.*;
import java.util.*;

/**
 * 문제이름 : 강의실 배정
 * 링크 : https://www.acmicpc.net/problem/11000
 */

public class Baekjoon11000 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Class> pq = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            pq.add(new Class(start, end));
        }

        PriorityQueue<Integer> rooms = new PriorityQueue<>();
        rooms.offer(pq.poll().end);
        while (!pq.isEmpty()) {
            Class curr = pq.poll();
            if (rooms.peek() <= curr.start)
                rooms.poll();

            rooms.add(curr.end);
        }

        System.out.println(rooms.size());
    }
}

class Class implements Comparable<Class> {
    int start;
    int end;

    public Class(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public int compareTo(Class o) {
        if (this.start == o.start)
            return this.end - o.end;
        else
            return this.start - o.start;
    }
}

/*

11
1 4
3 5
0 6
5 7
3 8
5 9
6 10
8 11
8 12
2 13
12 14

4
2 2
2 2
2 2
2 2

4
1 2
1 4
2 6
4 5

 */
