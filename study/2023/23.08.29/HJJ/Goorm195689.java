package study.nathan_algo_study.week64;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 문제이름 : 문자열 나누기
 * 링크 : https://level.goorm.io/exam/195688/%EB%AC%B8%EC%9E%90%EC%97%B4-%EB%82%98%EB%88%84%EA%B8%B0/quiz/1
 */

public class Goorm195689 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String str = br.readLine();
        Set<String> strSet = new HashSet<>();
        List<String[]> strList = new ArrayList<>();
        for (int i = 1; i <= n - 2; i++) {
            for (int j = 1; j <= n - i - 1; j++) {
                for (int k = 1; k <= n - i - j; k++) {
                    String[] substrArr = new String[3];
                    substrArr[0] = str.substring(0, i);
                    substrArr[1] = str.substring(i, i+j);
                    substrArr[2] = str.substring(i+j);
                    strSet.add(substrArr[0]);
                    strSet.add(substrArr[1]);
                    strSet.add(substrArr[2]);
                    strList.add(substrArr);
                }
            }
        }

        List<String> sortStrList = new ArrayList<>(strSet);
        Collections.sort(sortStrList);
        Map<String, Integer> strPointMap = new HashMap<>();
        for (int i = 0; i < sortStrList.size(); i++)
            strPointMap.put(sortStrList.get(i), i + 1);

        int maxPoint = 0;
        for (String[] strArr : strList) {
            int point = 0;
            point += strPointMap.get(strArr[0]);
            point += strPointMap.get(strArr[1]);
            point += strPointMap.get(strArr[2]);

            maxPoint = Math.max(maxPoint, point);
        }

        System.out.println(maxPoint);
    }
}

/*

abcd

a b cd
a bc d
ab c d


1 2 1
2 1 1

substring


*/
