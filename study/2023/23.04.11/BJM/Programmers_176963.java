package week52;

import java.util.Arrays;
import java.util.HashMap;

/**
 * 프로그래머스 176963번
 * 추억 점수
 * (https://school.programmers.co.kr/learn/courses/30/lessons/176963)
 **/
public class Programmers_176963 {
    public static void main(String[] args) {
        String[][] name = {{"may", "kein", "kain", "radi"}, {"kali", "mari", "don"}, {"may", "kein", "kain", "radi"}};
        int[][] yearning = {{5, 10, 1, 3}, {11, 1, 55}, {5, 10, 1, 3}};
        String[][][] photo = {{{"may", "kein", "kain", "radi"}, {"may", "kein", "brin", "deny"}, {"kon", "kain", "may", "coni"}},
                {{"kali", "mari", "don"}, {"pony", "tom", "teddy"}, {"con", "mona", "don"}},
                {{"may"}, {"kein", "deny", "may"}, {"kon", "coni"}}};

        for (int i = 0; i < name.length; i++)
            System.out.println(Arrays.toString(solution(name[i], yearning[i], photo[i])));
    }

    public static int[] solution(String[] name, int[] yearning, String[][] photo) {
        int[] answer = new int[photo.length];
        HashMap<String, Integer> map = new HashMap<>();
        // 1. 해시맵에 데이터(key : name / value : yearning)를 저장
        for (int i = 0; i < name.length; i++)
            map.put(name[i], yearning[i]);

        // 2. photo 배열을 돌면서 해당하는 이름이 해시맵에 있는지 확인
        for (int i = 0; i < photo.length; i++)
            for (int j = 0; j < photo[i].length; j++)
                // 2-1. 있으면 해당 value 값을 합산, 없으면 continue
                if (map.containsKey(photo[i][j]))
                    answer[i] += map.get(photo[i][j]);

        return answer;
    }
}