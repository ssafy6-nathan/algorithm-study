package week34;

/**
 * 프로그래머스 60057번
 * 문자열 압축
 * (https://school.programmers.co.kr/learn/courses/30/lessons/60057)
 **/

public class Programmers_60057 {

    public static void main(String[] args) {
        String[] test = {"aabbaccc", "ababcdcdababcdcd", "abcabcdede",
                "abcabcabcabcdededededede", "xababcdcdababcdcd"};

        for (int i = 0; i < test.length; i++) {
            System.out.println(solution(test[i]));
        }
    }

    private static int solution(String s) {
        int answer = s.length(); // 압축 불가능 문자열 그대로의 길이로 초기화
        StringBuilder sb; // 압축된 문자열 저장
        String curr; // 현재 비교 대상 문자열
        String part; // 비교할 분할 문자열
        int count; // 압축 개수

        // i개 단위로 문자 자르기
        // 두번째 문자부터 비교하므로 i = 1로 시작
        // 문자열 절반 길이를 초과할 경우 2분할도 안되므로 자를 수 없음
        for (int i = 1; i <= s.length() / 2; i++) {
            sb = new StringBuilder();
            part = s.substring(0, i);
            curr = "";
            count = 1;

            // 분할 단위인 i부터 비교하고 i만큼 건너뜀
            for (int start = i; start <= s.length() ; start += i) {

                // 0. curr 문자열 초기화
                // (if) 다음 분할 위치가 문자열 길이를 넘어가면(남은 문자열이 비교 개수보다 작으면) 남은 문자열 그대로 저장
                // (else) 그렇지 않을 경우 비교 개수만큼 분할하여 저장
                if (start + i >= s.length()) curr = s.substring(start);
                else curr = s.substring(start, start + i);

                // 1. 문자열이 같은 경우 count 증가
                if (curr.equals(part))
                    count++;

                // 2. 문자열이 다른 경우 sb에 문자열 추가하고 비교 문자열 변경
                // (else if) 압축된 문자가 없는 경우 문자열 그대로 추가
                // (else) 압축개수가 2개 이상인 경우 압축개수와 문자열 추가
                else if (count == 1) { 
                    sb.append(part);
                    part = curr;
                }
                else { 
                    sb.append(count);
                    sb.append(part);
                    part = curr;
                    count = 1;
                }
            }
            // 남은 문자열 그대로 추가
            if (i != part.length()) sb.append(part);
            // answer와 현재 sb길이 중 짧은 것으로 answer를 갱신
            answer = Math.min(answer, sb.length());
        }
        return answer;
    }


}
