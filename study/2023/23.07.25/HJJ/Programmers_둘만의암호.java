package study.nathan_algo_study.week62;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 문제이름 : 둘만의 암호
 * 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/155652
 */

public class Programmers_둘만의암호 {
    static char[] alphabet;
    static Map<Character, Integer> idxMap;

    public String solution(String s, String skip, int index) {
        init(skip);
        StringBuilder answer = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            answer.append(changeAlphabet(s.charAt(i), index));
        }

        return answer.toString();
    }

    private char changeAlphabet(char c, int moveCnt) {
        int idx = idxMap.get(c);
        idx = (idx + moveCnt) % alphabet.length;

        return alphabet[idx];
    }

    private void init(String skip) {
        Set<Character> skipSet = new HashSet<>();
        for (char c : skip.toCharArray()) {
            skipSet.add(c);
        }

        List<Character> alphabetList = new ArrayList<>();
        for (char c = 'a'; c <= 'z'; c++) {
            if (!skipSet.contains(c)) {
                alphabetList.add(c);
            }
        }

        alphabet = alphabetList.stream().map(String::valueOf)
                                .collect(Collectors.joining())
                                .toCharArray();

        idxMap = new HashMap<>();
        for (int i = 0; i < alphabet.length; i++)
            idxMap.put(alphabet[i], i);

    }
}

/*

 */
