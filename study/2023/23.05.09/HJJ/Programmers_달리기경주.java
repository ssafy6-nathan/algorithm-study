package study.nathan_algo_study.week55;

import java.util.HashMap;
import java.util.Map;

/**
 * 문제이름 : 달리기 경주
 * 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/178871
 */

public class Programmers_달리기경주 {
    public String[] solution(String[] players, String[] callings) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < players.length; i++)
            map.put(players[i], i);

        for (int i = 0; i < callings.length; i++) {
            swap(callings[i], players, map);
        }

        return players;
    }

    public void swap(String callName, String[] players, Map<String, Integer> map) {
        int callingIdx = map.get(callName);

        int prevIdx = callingIdx - 1;
        String prevPlayerName = players[prevIdx];

        map.put(callName, prevIdx);
        map.put(prevPlayerName, callingIdx);

        players[prevIdx] = callName;
        players[callingIdx] = prevPlayerName;
    }
}

/*

*/
