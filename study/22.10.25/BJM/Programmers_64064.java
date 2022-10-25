package week33;

import java.io.*;
import java.util.Arrays;

/**
 * 프로그래머스 64064번
 * 불량 사용자
 * (https://school.programmers.co.kr/learn/courses/30/lessons/64064)
 **/

public class Programmers_64064 {

    static int[][] checkArr;

    public static void main(String[] args) {
        String[][] user_id = {{"frodo", "fradi", "crodo", "abc123", "frodoc"},
                {"frodo", "fradi", "crodo", "abc123", "frodoc"},
                {"frodo", "fradi", "crodo", "abc123", "frodoc"}};
        String[][] banned_id = {{"fr*d*", "abc1**"},
                {"*rodo", "*rodo", "******"},
                {"fr*d*", "*rodo", "******", "******"}};

        for (int i = 0; i < user_id.length; i++) {
            System.out.println(solution(user_id[i], banned_id[i]));
        }

    }

    private static int solution(String[] user_id, String[] banned_id) {
        int answer = 0;

        // 1. 불량 사용자 아이디와 일치하는지 여부를 판단한 2차원배열 생성
        make_checkArr(user_id, banned_id);

        // 2. 순열 돌면서 checkArr값을 이용해 경우의 수 구하기
        // 3. 부합하는 경우를 HashSet에 추가
        // 4. Set의 크기 반환
        // 을 어떻게 ?????? 할까.............
        return answer;
    }

    // 불량사용자 후보 판단
    private static void make_checkArr (String[] user_id, String[] banned_id) {
        checkArr = new int[banned_id.length][user_id.length];
        for (int i = 0; i < banned_id.length; i++) {
            for (int j = 0; j < user_id.length; j++) {
                if (user_id[j].length() == banned_id[i].length()) {
                    for (int k = 0; k < user_id[i].length(); k++) {
                        if (user_id[j].charAt(k) != banned_id[i].charAt(k) && banned_id[i].charAt(k) != '*')
                            break;
                        else checkArr[i][j] = 1;
                    }
                }
            }
        }
    }
}
