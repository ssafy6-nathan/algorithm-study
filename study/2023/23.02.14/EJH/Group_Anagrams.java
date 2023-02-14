import java.util.*;
public class Group_Anagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for(int i=0; i<strs.length; i++) {
            char[] next = strs[i].toCharArray();
            Arrays.sort(next);
            String temp = Arrays.toString(next);
            if(!map.containsKey(temp)){
                List<String> list = new ArrayList<>();
                map.put(temp, list);

            }
            map.get(temp).add(strs[i]);
        }
        return new ArrayList(map.values());
    }
}
