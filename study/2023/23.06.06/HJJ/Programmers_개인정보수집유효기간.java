package study.nathan_algo_study.week57;

import java.util.*;

/**
 * 문제이름 : 개인정보 수집 유효기간
 * 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/150370
 */

public class Programmers_개인정보수집유효기간 {
    public int[] solution(String today, String[] terms, String[] privacies) {
        Map<String, Integer> termMap = new HashMap<>();
        for (String t : terms) {
            StringTokenizer st = new StringTokenizer(t);
            String key = st.nextToken();
            String value = st.nextToken();
            //약관종류 저장
            termMap.put(key, Integer.parseInt(value));
        }

        List<Integer> answer = new ArrayList<>();
        for (int i = 0; i < privacies.length; i++) {
            StringTokenizer st = new StringTokenizer(privacies[i]);
            String startDate = st.nextToken();
            String term = st.nextToken();

            if (isCheck(today, termMap, startDate, term))  //파기날짜 넘었는지 확인
                answer.add(i + 1);
        }

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }

    public boolean isCheck(String today, Map<String, Integer> termMap, String startDate, String term) {
        String limitDate = calDate(startDate, termMap.get(term));

        if (today.compareTo(limitDate) > 0)
            return true;
        else
            return false;
    }

    public String calDate(String date, int addMonth) {
        StringTokenizer st = new StringTokenizer(date, ".");
        int year = Integer.parseInt(st.nextToken());
        int month = Integer.parseInt(st.nextToken());
        int day = Integer.parseInt(st.nextToken());

        month += addMonth;
        if (month > 12) {
            year += month / 12;
            month %= 12;
        }
        day--;
        if (day == 0) {
            day = 28;
            month--;
        }

        if (month == 0) {
            month = 12;
            year--;
        }

        return String.format("%04d.%02d.%02d", year, month, day);
    }
}

/*

 */
