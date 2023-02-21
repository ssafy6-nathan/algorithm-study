package study.nathan_algo_study.week47;

/**
 * 문제이름 : Wildcard Matching
 * 링크 : https://leetcode.com/problems/wildcard-matching/
 */

public class Leetcode_44 {
    public static void main(String[] args) {
        Leetcode_44 leetcode44 = new Leetcode_44();
        leetcode44.isMatch("baaabab", "ba*a");
    }

    public boolean isMatch(String s, String p) {
        int sLen = s.length();
        int pLen = p.length();
        boolean[][] dp = new boolean[pLen + 1][sLen + 1];
        dp[0][0] = true;

        for (int i = 0; i < pLen; i++) {
            if (p.charAt(i) == '*')
                dp[i + 1][0] = dp[i][0];
        }

        for (int i = 0; i < pLen; i++) {
            for (int j = 0; j < sLen; j++) {
                if (p.charAt(i) == '?' || p.charAt(i) == s.charAt(j))
                    dp[i + 1][j + 1] = dp[i][j];
                else if (p.charAt(i) == '*')
                    dp[i + 1][j + 1] = dp[i][j + 1] || dp[i + 1][j];
            }
        }

        return dp[pLen][sLen];
    }
}

/*

 */
