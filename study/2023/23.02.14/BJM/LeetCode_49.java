package week47;

import java.util.*;

public class LeetCode_49 {
    public static void main(String[] args) {
        List<List<String>> list;
        String[][] strs = {{"eat","tea","tan","ate","nat","bat"}, {""}, {"a"}};

        for (String[] str : strs) {
            list = groupAnagrams(str);
            for (List<String> strings : list)
                System.out.print(strings);
            System.out.println();
        }
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        // 문자열의 철자들을 정렬하여 key 값으로 설정한 후, 원본 문자열을 value 리스트에 저장
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] words = str.toCharArray();
            Arrays.sort(words); // char 배열을 정렬시켜 같은 문자열을 가진 단어들을 같은 key 값에 저장하게 한다.
            String key = new String(words);

            if (!map.containsKey(key))
                map.put(key, new ArrayList<>());

            map.get(key).add(str);
        }

        return new ArrayList<>(map.values());
    }
}
