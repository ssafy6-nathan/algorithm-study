package study.nathan_algo_study.week9;

import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * 문제이름 : 회의실 배정
 * 링크 : https://www.acmicpc.net/problem/1931
 */

public class Baekjoon1931 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        PriorityQueue<Time> pq = new PriorityQueue<>();
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            pq.add(new Time(start,end));
        }

        int endTime = 0;
        int cnt = 0;
        while (!pq.isEmpty()) {
            Time curr = pq.poll();
            if (curr.start >= endTime) {
                endTime = curr.end;
                cnt++;
            }
        }

        System.out.println(cnt);
    }
}

class Time implements Comparable<Time>{
    int start;
    int end;

    public Time(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public int compareTo(Time o) {
        if (this.end == o.end)
            return this.start - o.start;
        else
            return this.end - o.end;
    }
}

/*

*/
