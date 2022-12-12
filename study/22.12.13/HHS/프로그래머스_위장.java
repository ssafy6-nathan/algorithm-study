import java.util.*;

class Solution {
    static int answer;
    static HashSet<String> clothesName;
    static HashMap<String, Integer> clothesType;
    
    public int solution(String[][] clothes) {

        clothesName = new HashSet<>();
        clothesType = new HashMap<>();
        
        for(int i = 0; i < clothes.length; i++){
            String Name = clothes[i][0];
            String Type = clothes[i][1];
            
            if(clothesName.contains(Name)) continue;
            clothesName.add(Name);
            clothesType.put(Type, clothesType.getOrDefault(Type, 0) +1);
        }
        answer = 1;
        for(String key : clothesType.keySet()){
            answer *= clothesType.get(key)+1;
        }
        
        return answer-1;
    }
}