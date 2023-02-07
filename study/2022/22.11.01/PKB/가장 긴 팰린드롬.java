class Solution {

    public int solution(String s) {

        int len = s.length();

        // 가장 긴 팰린드롬의 길이를 구해야 하므로 큰 값부터 역순으로
        for (int i = len; i > 0; i--) {
            // 인덱스 0 부터 시작해서 i 길이만큼 팰린드롬 검사
            for (int j = 0; j + i <= len; j++) {
                if (check(s, j, j + i - 1)) return i;
            }
        }

        return 0;

    }

    private static boolean check(String s, int start, int end) {

        // 문자 비교
        while (start <= end) {
            if (s.charAt(start++) != s.charAt(end--)) return false;
        }

        return true;

    }

}
