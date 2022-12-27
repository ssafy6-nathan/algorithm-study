package week33;

/**
 * 프로그래머스 17683번
 * 방금그곡
 * (https://school.programmers.co.kr/learn/courses/30/lessons/17683)
 **/

public class Programmers_17683 {

    public static void main(String[] args) {
        String[] musicinfos;
        String[] m = {"ABCDEFG", "CC#BCC#BCC#BCC#B", "ABC"};
        String[][] testcase = {{"11:50,12:04,HELLO,CDEFGAB", "12:57,13:11,BYE,CDEFGAB"},
                {"03:00,03:30,FOO,CC#B", "04:00,04:08,BAR,CC#BCC#BCC#B"},
                {"12:00,12:14,HELLO,C#DEFGAB", "13:00,13:05,WORLD,ABCDEF"}};

        for (int i = 0; i < testcase.length; i++) {
            musicinfos = new String[testcase[i].length];
            for (int j = 0; j < testcase[i].length; j++) {
                musicinfos[j] = testcase[i][j];
            }
            System.out.println(solution(m[i], musicinfos));
        }

    }

    private static String solution(String m, String[] musicinfos) {
        String answer = "(None)";
        String play; // 실제로 재생된 음계
        String[] info; // 한 곡의 정보 저장 {시작시간, 끝난시간, 곡 이름, 악보}
        int playtime, max = 0; // 총 재생시간, 최대 재생시간 비교 변수

        // musicinfos의 음악정보 개수만큼 확인
        for (int k = 0; k < musicinfos.length; k++) {
            // 1. 음악 정보 나눠서 저장하기
            info = musicinfos[k].split(",");

            // 2. 재생시간 계산
            int start = Integer.parseInt(info[0].substring(0, 2)) * 60 + Integer.parseInt(info[0].substring(3));
            int end = Integer.parseInt(info[1].substring(0, 2)) * 60 + Integer.parseInt(info[1].substring(3));
            playtime = end - start;

            // 3. 반음(#) 치환
            for (int i = 1; i < m.length(); i++) {
                if (m.charAt(i) == '#')
                    m = m.replace(m.substring(i - 1, i + 1), m.substring(i - 1, i).toLowerCase());
            }
            for (int i = 1; i < info[3].length(); i++) {
                if (info[3].charAt(i) == '#')
                    info[3] = info[3].replace(info[3].substring(i-1,i+1), info[3].substring(i-1,i).toLowerCase());
            }

            // 4. 문자열 비교
            play = "";
            for (int i = 0; i < playtime / info[3].length(); i++)  // 재생된 만큼 문자열 나열
                play += info[3];
            play += info[3].substring(0, playtime % info[3].length()); // 남은시간만큼의 문자 나열

            if (play.contains(m) && max < playtime) { // 재생시간이 더 길면 정답 갱신
                max = playtime;
                answer = info[2];
            }
        }

        return answer;
    }
}
