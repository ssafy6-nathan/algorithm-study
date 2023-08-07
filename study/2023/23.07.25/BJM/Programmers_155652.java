import java.util.ArrayList;

/**
 * 프로그래머스 155652번
 * 둘만의 암호
 * (https://school.programmers.co.kr/learn/courses/30/lessons/155652)
 **/

public class Programmers_155652 {
    public static void main(String[] args) {
        System.out.println(solution("aukks", "wbqd", 5));
    }

    public static String solution(String s, String skip, int index) {
        StringBuilder sb = new StringBuilder();
        ArrayList<Character> skipChar = new ArrayList<>(); // skip 알파벳을 걸러내는 용도
        ArrayList<Character> alphabet = new ArrayList<>(); // skip에 있는 알파벳을 제외한 알파벳 리스트

        // skip 걸러내기
        for (int i = 0; i < skip.length(); i++)
            skipChar.add(skip.charAt(i));

        // 리스트에 알파벳 넣기
        for (int i = 0; i < 26; i++) {
            char c = (char)('a' + i);
            if (!skipChar.contains(c))
                alphabet.add(c);
        }

        // index 만큼 건너뛴 알파벳으로 변환하기
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int converted = (alphabet.indexOf(c) + index) % alphabet.size();
            sb.append(alphabet.get(converted));
        }

        return sb.toString();
    }
}