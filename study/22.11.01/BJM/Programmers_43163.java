package week34;

/**
 * 프로그래머스 43163번
 * 단어 변환
 * (https://school.programmers.co.kr/learn/courses/30/lessons/43163)
 **/
public class Programmers_43163 {
    static boolean[] visited;
    static int answer;

    public static void main(String[] args) {
        String[][] words = {{"hot", "dot", "dog", "lot", "log", "cog"},
                {"hot", "dot", "dog", "lot", "log"}};
        System.out.println(solution("hit", "cog", words[0]));
        System.out.println(solution("hit", "cog", words[1]));
    }

    public static int solution(String begin, String target, String[] words) {
        answer = 0;
        visited = new boolean[words.length];
        dfs(begin, target, words, 0);
        return answer;
    }

    private static void dfs(String cur, String target, String[] words, int count) {
        // 종료조건: 현재 단어와 최종 변환 단어가 같을 때 변환 횟수를 저장하고 종료
        // **** 근데 변환 횟수 최소값을 구해야되는데 그건 어떻게하지 ??? ****
        // **** 우연히 테케 통과가 된 것 같은데 마지막으로 갱신된 answer값이 최소값이 아니면?? 아몰랑.. ****
        if (cur.equals(target)) {
            answer = count;
            return;
        }

        for (int i = 0; i < words.length; i++) {
            // 방문하지 않았으며 알파벳 차이가 1이면 탐색
            if (!visited[i] && check(cur, words[i])) {
                visited[i] = true;
                dfs(words[i], target, words, count+1);
                visited[i] = false;
            }
        }
    }

    // 다른 알파벳이 1개인지 체크
    private static boolean check(String str1, String str2) {
        boolean answer = true;
        int count = 0;
        for (int i = 0; i < str1.length(); i++)
            if (str1.charAt(i) != str2.charAt(i)) count++;
        if (count == 0 || count > 1)
            answer = false;
        return answer;
    }
}
