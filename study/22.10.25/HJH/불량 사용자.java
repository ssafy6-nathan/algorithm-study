import java.util.*;

class Solution {
    private static String[] userId;
    private static String[] bannedId;
    private static Set<Set<String>> result = new HashSet<>();
    
    public int solution(String[] user_id, String[] banned_id) {
        userId = user_id;
        bannedId = banned_id;
        dfs(new LinkedHashSet<>());
        return result.size();
    }
    
    private static boolean isSame(String user, String banned) {
        if (user.length() != banned.length()) return false;
        for (int i = 0; i < user.length(); i++) {
            if (banned.charAt(i) == '*') continue;
            if (banned.charAt(i) != user.charAt(i)) return false;
        }
        return true;
    }
    
    private static void dfs(Set<String> set) {
        if (set.size() == bannedId.length) {
            if (isBId(set))
                result.add(new HashSet<>(set));
            return;
        }

        for (String user : userId) {
            if (!set.contains(user)) {
                set.add(user);
                dfs(set);
                set.remove(user);
            }
        }
    }
    
    private static boolean isBId(Set<String> set) {
        int i = 0;
        for (String user : set)
            if (!isSame(user, bannedId[i++]))
                return false;
        return true;
    }

    
}
