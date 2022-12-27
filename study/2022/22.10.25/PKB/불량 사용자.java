import java.util.*;

class Solution {

    static HashSet<String> set;
    static String[] user, banned;
    static boolean[] visit;
    static int uLen, bLen;

    public int solution(String[] user_id, String[] banned_id) {

        set = new HashSet<>();
        user = user_id;
        banned = banned_id;
        uLen = user.length;
        bLen = banned.length;
        visit = new boolean[uLen];

        dfs(0, "");

        return set.size();

    }

    private static void dfs(int idx, String ids) {

        if (idx == bLen) {
            String[] arr = ids.split(" ");
            Arrays.sort(arr);

            String str = "";

            for (String s : arr) {
                str += s;
            }

            set.add(str);

            return;
        }
        
        for (int i = 0; i < uLen; i++) {
            if (!visit[i] && check(user[i], banned[idx])) {
                visit[i] = true;

                dfs(idx + 1, ids + " " + user[i]);

                visit[i] = false;
            }
        }

    }

    private static boolean check(String s1, String s2) {

        if (s1.length() != s2.length()) return false;

        for (int i = 0, len = s2.length(); i < len; i++) {
            if (s2.charAt(i) == '*') continue;

            if (s1.charAt(i) != s2.charAt(i)) return false;
        }

        return true;

    }

}
