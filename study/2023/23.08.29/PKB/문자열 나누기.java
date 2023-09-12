/*
 * 문제 : 문자열 나누기
 * 링크 : https://level.goorm.io/exam/195688/%EB%AC%B8%EC%9E%90%EC%97%B4-%EB%82%98%EB%88%84%EA%B8%B0/quiz/1
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main_195688 {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String S = br.readLine();

        List<String[]> list = new ArrayList<>();
        Set<String> set = new HashSet<>();

        for (int i = 1; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                String first = S.substring(0, i);
                String second = S.substring(i, j);
                String third = S.substring(j);
                list.add(new String[]{first, second, third});

                set.add(first);
                set.add(second);
                set.add(third);
            }
        }

        List<String> P = new ArrayList<>(set);
        Collections.sort(P);

        Map<String, Integer> map = new HashMap<>();
        int idx = 1;

        for (String p : P) {
            map.put(p, idx++);
        }

        int max = -1;

        for (String[] word : list) {
            int first = map.get(word[0]);
            int second = map.get(word[1]);
            int third = map.get(word[2]);

            max = Math.max(max, first + second + third);
        }

        System.out.println(max);

    }

}
