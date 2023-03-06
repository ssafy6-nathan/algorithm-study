package study.nathan_algo_study.week48;

import java.io.*;
import java.util.*;

/**
 * 문제이름 : 컨베이어 벨트 위의 로봇
 * 링크 : https://www.acmicpc.net/problem/20055
 */

public class Baekjoon20055 {
    static int N, K;
    static int[] belt;
    static boolean[] robots;
    static int firstIdx, lastIdx;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        belt = new int[2 * N];
        robots = new boolean[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 2 * N; i++)
            belt[i] = Integer.parseInt(st.nextToken());

        firstIdx = 0;
        lastIdx = N - 1;
        int turn = 0;

        while (countingK() < K) {
            turn++;
            moveBelt();
            moveRobot();
            addRobot();
        }

        System.out.println(turn);
    }

    public static void moveBelt() {
        //1.컨베이어벨트 움직임
        firstIdx = ((2 * N + firstIdx) - 1) % (2 * N);
        lastIdx = ((2 * N + lastIdx) - 1) % (2 * N);

        for (int i = N - 1; i > 0; i--) {
            robots[i] = robots[i - 1];
            robots[i - 1] = false;
        }

        robots[N - 1] = false;
    }

    public static void moveRobot() {
        //2.로봇 움직임
        for (int i = N - 1; i > 0; i--) {
            if (!robots[i] && belt[(firstIdx + i) % (2 * N)] > 0 && robots[i - 1]) {
                robots[i] = robots[i - 1];
                robots[i - 1] = false;
                belt[(firstIdx + i) % (2 * N)]--;
            }
        }
    }

    public static void addRobot() {
        //3.올리는 위치에 로봇 올리기
        if (belt[firstIdx] > 0) {
            robots[0] = true;
            belt[firstIdx]--;
        }
    }

    public static int countingK() {
        int cnt = 0;
        for (int i = 0; i < 2 * N; i++) {
            if (belt[i] == 0)
                cnt++;
        }

        return cnt;
    }
}


/*
1 2 1
2 1 2

1.
2 1 2
1 2 1

2.
2 1 2
1 2 1

3.
v
1 1 2
1 2 1

1.
  v
1 1 1
2 1 2

2.
    v
1 1 0
2 1 2

3.
v   v
0 1 0
2 1 2

v   v
1 2 1 2 1 2

v   v
1 2 1 2 1 2
 */
