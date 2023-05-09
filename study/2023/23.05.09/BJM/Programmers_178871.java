package week55;

import java.util.*;

/**
 * 프로그래머스 178871번
 * 달리기 경주
 * (https://school.programmers.co.kr/learn/courses/30/lessons/178871)
 **/
public class Programmers_178871 {
    public static void main(String[] args) {
        String[] players = {"mumu", "soe", "poe", "kai", "mine"};
        String[] callings = {"kai", "kai", "mine", "mine"};
        System.out.println(Arrays.toString(solution(players, callings)));
    }

    public static String[] solution(String[] players, String[] callings) {
        HashMap<String, Integer> map = new HashMap<String, Integer>();

        // key: 선수 이름 value: 현재 등수
        for (int i = 0; i < players.length; i++)
            map.put(players[i], i);

        for (int i = 0; i < callings.length; i++) {
            String player1 = callings[i]; // 현재 추월한 선수 이름
            int rank = map.get(player1); // 추월한 선수의 현재 등수
            String player2 = players[rank - 1]; // 추월 당한 선수 이름

            // 선수 등수 변경
            map.replace(player2, rank);
            map.replace(player1, rank - 1);

            players[rank] = player2;
            players[rank - 1] = player1;
        }

        return players;
    }
}
