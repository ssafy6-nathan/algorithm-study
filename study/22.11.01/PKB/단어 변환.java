class Solution {

    static String[] W;
    static boolean[] visit;
    static int len, answer;

    public int solution(String begin, String target, String[] words) {

        answer = 51;
        W = words;
        len = W.length;
        visit = new boolean[len];

        dfs(begin, target, 0);

        // 변환할 수 없는 경우 0 반환
        if (answer == 51) return 0;

        return answer;

    }

    private static void dfs(String begin, String target, int cnt) {

        // 단어가 target 과 같아졌을 때 횟수의 최솟값 저장
        if (begin.equals(target)) {
            answer = Math.min(answer, cnt);

            return;
        }

        for (int i = 0; i < len; i++) {
            // 변환된 적 없으면서 알파벳이 하나만 다른 경우
            if (!visit[i] && check(begin, W[i])) {
                // 찾은 단어 표시
                visit[i] = true;
                // cnt 증가시키면서 다음 단계로 이동
                dfs(W[i], target, cnt + 1);
                // 완전 탐색을 위해 표시 제거
                visit[i] = false;
            }
        }

    }

    // 두 단어 비교
    private static boolean check(String s1, String s2) {

        int cnt = 0;

        // 두 단어를 비교하며 알파벳이 두 개 이상 다른 경우 false 리턴
        for (int i = 0, sLen = s1.length(); i < sLen; i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                if (++cnt > 1) return false;
            }
        }

        return true;

    }

}
