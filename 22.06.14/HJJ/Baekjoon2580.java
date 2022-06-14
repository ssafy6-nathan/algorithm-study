package study.nathan_algo_study.week16;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * 문제이름 : 스도쿠
 * 링크 : https://www.acmicpc.net/problem/2580
 */

public class Baekjoon2580 {
    static final int N = 9;
    static int[][] sudoku;
    static boolean[][] rowUsed;
    static boolean[][] colUsed;
    static boolean[][] squareUsed;
    static ArrayList<int[]> blanks;
    static boolean isPrint;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        sudoku = new int[N][N];
        rowUsed = new boolean[N][N + 1];
        colUsed = new boolean[N][N + 1];
        squareUsed = new boolean[N][N + 1];
        blanks = new ArrayList<>();
        isPrint = false;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                sudoku[i][j] = Integer.parseInt(st.nextToken());
                if (sudoku[i][j] != 0) {
                    rowUsed[i][sudoku[i][j]] = true;
                    colUsed[j][sudoku[i][j]] = true;
                    squareUsed[squarePoint(i,j)][sudoku[i][j]] = true;
                } else
                    blanks.add(new int[]{i, j});
            }
        }

        search(0);

    }

    public static void search(int cnt) {
        if (cnt == blanks.size()) {
            if (!isPrint) {
                for (int i = 0; i < N; i++) {
                    for (int j = 0; j < N; j++)
                        System.out.print(sudoku[i][j] + " ");
                    System.out.println();
                }
                isPrint = true;
            }
            return;
        }

        int[] p = blanks.get(cnt);
        int r = p[0];
        int c = p[1];
        for (int i = 1; i <= N; i++) {
            if (rowUsed[r][i] || colUsed[c][i] || squareUsed[squarePoint(r,c)][i])
                continue;

            rowUsed[r][i] = true;
            colUsed[c][i] = true;
            squareUsed[squarePoint(r,c)][i] = true;
            sudoku[r][c] = i;

            search(cnt + 1);

            rowUsed[r][i] = false;
            colUsed[c][i] = false;
            squareUsed[squarePoint(r,c)][i] = false;
            sudoku[r][c] = 0;

            if (isPrint)
                return;
        }

    }

    private static int squarePoint(int row, int col) {
        int r = row / 3;
        int c = col / 3;

        return r * 3 + c;
    }
}

/*
00 01 02  03 04 05  06 07 08
10 11 12  13 14 15  16 17 18
20 21 22  23 24 25  26 27 28

30 31 32  33 34 35  36 37 38
40 41 42  43 44 45  46 47 48
50 51 52  53 54 55  56 57 58

60 61 62  63 64 65  66 67 68
70 71 72  73 74 75  76 77 78
80 81 82  83 84 85  86 87 88

00 01 02
10 11 12
20 21 22

0 1 2
3 4 5
6 7 8
 */
