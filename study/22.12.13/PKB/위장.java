import java.util.*;

class Solution {

    public int solution(String[][] clothes) {

        HashMap<String, Integer> map = new HashMap<>();
        int answer = 1;

        for (String[] cloth : clothes) {
            String type = cloth[1];

            map.put(type, map.getOrDefault(type, 1) + 1);
        }

        for (int value : map.values()) {
            answer *= value;
        }

        return answer - 1;

    }

}
