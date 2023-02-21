package study.nathan_algo_study.week47;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 문제이름 : Group Anagrams
 * 링크 : https://leetcode.com/problems/group-anagrams/
 */

public class Leetcode_49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        int[] alphabets;
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            alphabets = new int[26];

            for (int i = 0; i < str.length(); i++) {
                alphabets[str.charAt(i) - 'a']++;
            }

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < alphabets.length; i++) {
                sb.append((char)('a'+i)+"-");
                sb.append(alphabets[i]);
            }

            String key = sb.toString();
            List<String> value = map.getOrDefault(key, new ArrayList<>());
            value.add(str);
            map.put(key, value);
        }

        return new ArrayList<>(map.values());
    }
}

/*

*/
