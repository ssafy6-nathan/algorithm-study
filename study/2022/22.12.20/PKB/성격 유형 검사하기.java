import java.util.*;

class Solution {

    public String solution(String[] survey, int[] choices) {

        StringBuilder sb = new StringBuilder();
        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0, len = survey.length; i < len; i++) {
            char t1 = survey[i].charAt(0);
            char t2 = survey[i].charAt(1);
            int choice = choices[i] - 4;

            if (choice == 0) continue;

            if (choice < 0) map.put(t1, map.getOrDefault(t1, 0) - choice);
            else map.put(t2, map.getOrDefault(t2, 0) + choice);
        }

        if (map.getOrDefault('R', 0) >= map.getOrDefault('T', 0)) sb.append('R');
        else sb.append('T');

        if (map.getOrDefault('C', 0) >= map.getOrDefault('F', 0)) sb.append('C');
        else sb.append('F');

        if (map.getOrDefault('J', 0) >= map.getOrDefault('M', 0)) sb.append('J');
        else sb.append('M');

        if (map.getOrDefault('A', 0) >= map.getOrDefault('N', 0)) sb.append('A');
        else sb.append('N');

        return sb.toString();

    }

}
