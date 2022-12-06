package study.nathan_algo_study.week19;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 문제이름 : 2048 (Easy)
 * 링크 : https://www.acmicpc.net/problem/12100
 */

public class Baekjoon12100 {
    static int N;
    static int[][] map;
    static int[][] tempMap;
    static int[][] dir = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};    // 좌 우 상 하
    static int maxBlock;
    static int simulationResult;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++)
                map[i][j] = Integer.parseInt(st.nextToken());
        }

        perm(0, new int[5]);

        System.out.println(maxBlock);
    }

    public static void perm(int cnt, int[] p) {
        if (cnt == 5) {
            simulationResult = 0;
            simulation(p);
            maxBlock = Math.max(simulationResult, maxBlock);
            return;
        }

        for (int i = 0; i < dir.length; i++) {

            p[cnt] = i;
            perm(cnt + 1, p);
        }
    }

    private static void simulation(int[] p) {
        initTempMap();

        for (int i = 0; i < p.length; i++) {
            combine(p[i]);
            move(p[i]);
        }

        simulationResult = findMaxValue();
    }

    private static int findMaxValue() {
        int max = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (tempMap[i][j] > max)
                    max = tempMap[i][j];
            }
        }
        return max;
    }

    private static void initTempMap() {
        tempMap = new int[N][N];
        for (int i = 0; i < N; i++)
            System.arraycopy(map[i], 0, tempMap[i], 0, N);

    }

    private static void combine(int d) {
        int currValue;
        int currIdx;
        switch (d) {
            case 0:    //좌
                for (int i = 0; i < N; i++) {
                    currValue = -1;
                    currIdx = -1;
                    for (int j = 0; j < N; j++) {
                        if (tempMap[i][j] != 0) {
                            if (currValue == -1) {
                                currValue = tempMap[i][j];
                                currIdx = j;
                            } else {
                                if (tempMap[i][j] == currValue) {
                                    tempMap[i][j] += currValue;
                                    tempMap[i][currIdx] = 0;
                                    currValue = -1;
                                    currIdx = -1;
                                } else {
                                    currValue = tempMap[i][j];
                                    currIdx = j;
                                }
                            }
                        }
                    }
                }
                break;
            case 1:    //우
                for (int i = 0; i < N; i++) {
                    currValue = -1;
                    currIdx = -1;
                    for (int j = N - 1; j >= 0; j--) {
                        if (tempMap[i][j] != 0) {
                            if (currValue == -1) {
                                currValue = tempMap[i][j];
                                currIdx = j;
                            } else {
                                if (tempMap[i][j] == currValue) {
                                    tempMap[i][j] += currValue;
                                    tempMap[i][currIdx] = 0;
                                    currValue = -1;
                                    currIdx = -1;
                                } else {
                                    currValue = tempMap[i][j];
                                    currIdx = j;
                                }
                            }
                        }
                    }
                }
                break;
            case 2:    //상
                for (int i = 0; i < N; i++) {
                    currValue = -1;
                    currIdx = -1;
                    for (int j = 0; j < N; j++) {
                        if (tempMap[j][i] != 0) {
                            if (currValue == -1) {
                                currValue = tempMap[j][i];
                                currIdx = j;
                            } else {
                                if (tempMap[j][i] == currValue) {
                                    tempMap[j][i] += currValue;
                                    tempMap[currIdx][i] = 0;
                                    currValue = -1;
                                    currIdx = -1;
                                } else {
                                    currValue = tempMap[j][i];
                                    currIdx = j;
                                }
                            }
                        }
                    }
                }
                break;
            case 3:    //하
                for (int i = 0; i < N; i++) {
                    currValue = -1;
                    currIdx = -1;
                    for (int j = N - 1; j >= 0; j--) {
                        if (tempMap[j][i] != 0) {
                            if (currValue == -1) {
                                currValue = tempMap[j][i];
                                currIdx = j;
                            } else {
                                if (tempMap[j][i] == currValue) {
                                    tempMap[j][i] += currValue;
                                    tempMap[currIdx][i] = 0;
                                    currValue = -1;
                                    currIdx = -1;
                                } else {
                                    currValue = tempMap[j][i];
                                    currIdx = j;
                                }
                            }
                        }
                    }
                }
                break;
        }
    }

    private static void move(int d) {
        int emptyIdx;
        switch (d) {
            case 0:    //좌
                for (int i = 0; i < N; i++) {
                    emptyIdx = -1;
                    for (int j = 0; j < N; j++) {
                        if (tempMap[i][j] == 0) {
                            if (emptyIdx == -1)
                                emptyIdx = j;
                        } else {
                            if (emptyIdx != -1) {
                                tempMap[i][emptyIdx] = tempMap[i][j];
                                tempMap[i][j] = 0;
                                emptyIdx = -1;
                                for (int k = 0; k < N; k++) {
                                    if (tempMap[i][k] == 0) {
                                        emptyIdx = k;
                                        break;
                                    }
                                }
                            }
                        }
                    }
                }
                break;
            case 1:    //우
                for (int i = 0; i < N; i++) {
                    emptyIdx = -1;
                    for (int j = N - 1; j >= 0; j--) {
                        if (tempMap[i][j] == 0) {
                            if (emptyIdx == -1)
                                emptyIdx = j;
                        } else {
                            if (emptyIdx != -1) {
                                tempMap[i][emptyIdx] = tempMap[i][j];
                                tempMap[i][j] = 0;
                                emptyIdx = -1;
                                for (int k = N - 1; k >= 0; k--) {
                                    if (tempMap[i][k] == 0) {
                                        emptyIdx = k;
                                        break;
                                    }
                                }
                            }
                        }
                    }
                }
                break;
            case 2:    //상
                for (int i = 0; i < N; i++) {
                    emptyIdx = -1;
                    for (int j = 0; j < N; j++) {
                        if (tempMap[j][i] == 0) {
                            if (emptyIdx == -1)
                                emptyIdx = j;
                        } else {
                            if (emptyIdx != -1) {
                                tempMap[emptyIdx][i] = tempMap[j][i];
                                tempMap[j][i] = 0;
                                emptyIdx = -1;
                                for (int k = 0; k < N; k++) {
                                    if (tempMap[k][i] == 0) {
                                        emptyIdx = k;
                                        break;
                                    }
                                }
                            }
                        }
                    }
                }
                break;
            case 3:    //하
                for (int i = 0; i < N; i++) {
                    emptyIdx = -1;
                    for (int j = N - 1; j >= 0; j--) {
                        if (tempMap[j][i] == 0) {
                            if (emptyIdx == -1)
                                emptyIdx = j;
                        } else {
                            if (emptyIdx != -1) {
                                tempMap[emptyIdx][i] = tempMap[j][i];
                                tempMap[j][i] = 0;
                                emptyIdx = -1;
                                for (int k = N - 1; k >= 0; k--) {
                                    if (tempMap[k][i] == 0) {
                                        emptyIdx = k;
                                        break;
                                    }
                                }
                            }
                        }
                    }
                }
                break;
        }
    }
}

/*
2000
1024
2048000


4 2
8 4
16 8

4
2 2 2 2
2 2 2 2
2 2 2 2
2 2 2 2

4
4 4 4 0
2 8 2 0
2 4 2 0

0 0 0 0
4 4 4 0
4 8 4 0

0 0 0 0
0 4 0 0
8 8 8 0

0 0 0 0
4 0 0 0
16 8 0 0


*/
