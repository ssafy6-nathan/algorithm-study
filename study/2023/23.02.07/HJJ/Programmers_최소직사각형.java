package study.nathan_algo_study.week46;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 문제이름 : 최소직사각형
 * 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/86491
 */

public class Programmers_최소직사각형 {
    public int solution(int[][] sizes) {
        List<Integer> minSize = new ArrayList<>();
        List<Integer> maxSize = new ArrayList<>();

        for (int[] size : sizes) {
            minSize.add(Arrays.stream(size)
                    .min()
                    .getAsInt());
            maxSize.add(Arrays.stream(size)
                    .max()
                    .getAsInt());
        }

        int row = minSize.stream().mapToInt(x -> x).max().getAsInt();
        int col = maxSize.stream().mapToInt(x -> x).max().getAsInt();

        return row * col;
    }
}

/*
80 70

60 50 - 60 50
30 70 - 60 70
60 30 - 60 70
80 40 - 80 70

60 50 - 60 50
70 30 - 70 50
60 30 - 60 50
80 40 - 80 50

*/
