package study.nathan_algo_study.week34;

/**
 * 문제이름 : 단어 변환
 * 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/43163
 */

public class Programmers_단어변환 {
    static boolean[] v;
    static int answer;
    public int solution(String begin, String target, String[] words) {
        v = new boolean[words.length];
        answer = 51;

        dfs(begin,target,words,0);

        return answer == 51 ? 0 : answer;
    }

    public void dfs(String begin, String target, String[] words, int cnt) {
        if (begin.equals(target)) {
            answer = Math.min(answer, cnt);
            return;
        }

        for (int i = 0; i < words.length; i++) {
            if (v[i] || !isOneDiff(begin,words[i]))
                continue;

            v[i] = true;
            dfs(words[i], target, words, cnt+1);
            v[i] = false;
        }
    }

    public boolean isOneDiff(String str1, String str2) {
        int diffCnt = 0;
        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) != str2.charAt(i))
                diffCnt++;

            if (diffCnt > 1)    //최적화
                return false;
        }

        return diffCnt == 1;
    }
}
