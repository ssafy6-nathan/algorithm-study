package study.nathan_algo_study.week5;

/**
 * 문제이름 : 행렬 테두리 회전하기
 * 링크 : https://programmers.co.kr/learn/courses/30/lessons/77485
 */

public class Programmers_Matrix {
    static int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};   //오 아 왼 위
    static int[][] map;
    static boolean[][] v;
    static int minValue;

    public int[] solution(int rows, int columns, int[][] queries) {
        map = new int[rows][columns];
        for (int i = 0, n = 1; i < rows; i++)
            for (int j = 0; j < columns; j++)
                map[i][j] = n++;


        int[] answer = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int startR = queries[i][0] - 1;
            int startC = queries[i][1] - 1;
            v = new boolean[rows][columns];
            minValue = Integer.MAX_VALUE;
            rotation(queries[i], startR, startC, 0, map[startR+1][startC], false);
            answer[i] = minValue;
        }

        return answer;
    }

    private void rotation(int[] query, int r, int c, int d, int prevValue, boolean isRow) {
        int currValue = map[r][c];
        minValue = Math.min(minValue, currValue);
        map[r][c] = prevValue;

        if (r == query[0]-1 && c == query[1]-1 && v[r][c])
            return;

        v[r][c] = true;

        for (int i = 0; i < 1; i++) {
            int dr = r + dir[d][0];
            int dc = c + dir[d][1];

            if (isRow && (dr < query[0]-1 || dr > query[2]-1)) {    //세로로 이동중일 때
                d = (d + 1) % 4;
                i--;
                isRow = false;
                continue;
            }

            if (!isRow && (dc < query[1]-1 || dc > query[3]-1)) {   //가로로 이동중일 때
                d = (d + 1) % 4;
                i--;
                isRow = true;
                continue;
            }

            rotation(query, dr, dc, d, currValue, isRow);
        }
    }
}

/*
1, 1 ~ 1, 3

4, 1 ~ 4, 3

3+1, 2+1

3,3 ~ 3,6

6,3 ~ 6,6


*/
