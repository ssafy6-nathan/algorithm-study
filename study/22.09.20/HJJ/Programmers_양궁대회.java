package study.nathan_algo_study.week29;

import java.util.ArrayList;
import java.util.Collections;

public class Programmers_양궁대회 {
    static int[] point = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
    static int maxPoint;
    static int N;
    static int[] apeach;
    static ArrayList<int[]> maxPointList;

    public int[] solution(int n, int[] info) {

        maxPoint = -1;
        N = n;
        apeach = info;
        maxPointList = new ArrayList<>();
        shot(0, 0, new int[11]);

        if (maxPoint == -1)
            return new int[]{-1};

        Collections.sort(maxPointList, (o1, o2) -> {
            for (int i = o1.length - 1; i >= 0; i--) {
                if (o1[i] != o2[i])
                    return o2[i] - o1[i];
            }
            return 0;
        });

        return maxPointList.get(0);
    }

    public void shot(int cnt, int start, int[] ryan) {
        if (N == cnt) {
            int ryanPoint = 0;
            int apeachPoint = 0;
            for (int i = 0; i < ryan.length; i++) {
                if (apeach[i] == 0 && ryan[i] == 0)
                    continue;

                if (apeach[i] >= ryan[i])
                    apeachPoint += point[i];
                else
                    ryanPoint += point[i];

            }
            if (ryanPoint > apeachPoint) {
                int diff = ryanPoint - apeachPoint;
                if (maxPoint < diff) {
                    maxPoint = ryanPoint - apeachPoint;
                    maxPointList.clear();
                    maxPointList.add(ryan.clone());
                } else if (maxPoint == diff)
                    maxPointList.add(ryan.clone());
            }

            return;
        }

        for (int i = start; i < point.length; i++) {
            if (apeach[i] < ryan[i])
                continue;

            ryan[i]++;
            shot(cnt + 1, i, ryan);
            ryan[i]--;
        }
    }
}
/*

 */