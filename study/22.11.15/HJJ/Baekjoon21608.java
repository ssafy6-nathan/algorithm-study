package study.nathan_algo_study.week36;

import java.io.*;
import java.util.*;

/**
 * 문제이름 : 상어 초등학교
 * 링크 : https://www.acmicpc.net/problem/21608
 */

public class Baekjoon21608 {
    static int N;
    static int[][] room;
    static int[][] dir = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
    static int[] points = {0, 1, 10, 100, 1000};
    static Map<Integer, Set<Integer>> students;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        room = new int[N + 1][N + 1];
        students = new LinkedHashMap<>();   //학생들을 입력 순서대로 저장하기위해 LinkedHashMap 사용

        for (int i = 0; i < N * N; i++) {
            st = new StringTokenizer(br.readLine());

            int student = Integer.parseInt(st.nextToken());
            Set<Integer> like = new HashSet<>();
            like.add(Integer.parseInt(st.nextToken()));
            like.add(Integer.parseInt(st.nextToken()));
            like.add(Integer.parseInt(st.nextToken()));
            like.add(Integer.parseInt(st.nextToken()));
            students.put(student, like);
        }

        for (Map.Entry<Integer, Set<Integer>> entry : students.entrySet())  //입력순서대로 학생들 자리배치
            seat(entry.getKey(), entry.getValue());

        System.out.println(likePoint());
    }

    public static void seat(int student, Set<Integer> like) {
        int r = -1;
        int c = -1;
        int likeCnt = -1;
        int emptyCnt = -1;
        for (int i = 1; i < N + 1; i++) {
            for (int j = 1; j < N + 1; j++) {   //3번규칙. 순회를 작은 행부터 작은 열순으로 하고 있어서 조건 충족
                if (room[i][j] != 0)
                    continue;

                int[] cnts = searchLike(i, j, like);
                if (likeCnt < cnts[0]) {    //1번규칙. 좋아하는 학생이 인접한 칸이 제일 많으면 갱신
                    r = i;
                    c = j;
                    likeCnt = cnts[0];
                    emptyCnt = cnts[1];
                } else if (likeCnt == cnts[0]) {
                    if (emptyCnt < cnts[1]) {   //2번규칙. 1번을 만족하는 칸이 여러개이면 비어있는 칸이 많은 칸을 선정
                        r = i;
                        c = j;
                        likeCnt = cnts[0];
                        emptyCnt = cnts[1];
                    }
                }
            }
        }
        
        room[r][c] = student;
    }

    public static int[] searchLike(int r, int c, Set<Integer> like) {
        int likeCnt = 0;
        int emptyCnt = 0;
        for (int i = 0; i < dir.length; i++) {
            int dr = r + dir[i][0];
            int dc = c + dir[i][1];

            if (dr < 1 || dr > N || dc < 1 || dc > N)
                continue;

            if (like.contains(room[dr][dc]))
                likeCnt++;

            if (room[dr][dc] == 0)
                emptyCnt++;
        }

        return new int[]{likeCnt, emptyCnt};
    }

    public static int likePoint() {
        int pointSum = 0;
        for (int i = 1; i < N + 1; i++) {
            for (int j = 1; j < N + 1; j++) {
                int[] cnts = searchLike(i,j, students.get(room[i][j]));
                pointSum += points[cnts[0]];
            }
        }

        return pointSum;
    }
}

/*
20 * 20 * 4 = 1600

1. 비어있는 칸 중에서 좋아하는 학생이 인접한 칸에 가장 많은 칸으로 자리를 정한다.
2. 1을 만족하는 칸이 여러 개이면, 인접한 칸 중에서 비어있는 칸이 가장 많은 칸으로 자리를 정한다.
3. 2를 만족하는 칸도 여러 개인 경우에는 행의 번호가 가장 작은 칸으로, 그러한 칸도 여러 개이면
    열의 번호가 가장 작은 칸으로 자리를 정한다.

 */
