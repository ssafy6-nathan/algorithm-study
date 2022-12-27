import java.util.*;

class Solution {
    static ArrayList<Best> best;
    
    public int[] solution(String[] genres, int[] plays) {
         // 장르별 재생 수 합산해서 그 장르 먼저 나오게 하기
        // 해당 장르에서 탑2 씩 정렬해서 뽑기
        // 인덱스 넘버로 뽑기
        best = new ArrayList<>();
       
        Map<String, Integer> cnt = new HashMap<>();
        //map에 장르별 합산 값 저장하고, best 리스트에 각 값들 넣어놓기        
        for(int i = 0; i < genres.length; i++){
            String genre = genres[i];
            int count = plays[i];
            if(cnt.containsKey(genre)){
                cnt.put(genre, cnt.get(genre)+count);
            }else{
                cnt.put(genre, count);
            }    
            best.add(new Best(genre, count, i));
        }
        //재생 카운트 순으로 정렬 -> 인덱스 작은 것부터 정렬
        Collections.sort(best, new Comparator<Best>(){
            public int compare(Best b1, Best b2){
                if(b1.count < b2.count) return 1;
                else if(b1.count > b2.count) return -1;
                else
                    return b1.index - b2.index;
            }
        });
        
        //합산 값 순으로 정렬
        List<Map.Entry<String, Integer>> entryList = new LinkedList<>(cnt.entrySet());
        entryList.sort(((o1, o2) -> cnt.get(o2.getKey()) - cnt.get(o1.getKey())));

        
        ArrayList<Integer> ans = new ArrayList<>();

        for(Map.Entry<String, Integer> entry : entryList){
            String gen = entry.getKey();
            int sizes = 0;
            for(int i = 0; i < best.size(); i++){
                if((gen.equals(best.get(i).genre) && sizes < 2)){
                    ans.add(best.get(i).index);
                    sizes++;
                }
            }
        }
        int[] answer = new int[ans.size()];
        for(int i = 0; i < answer.length; i++){
            answer[i] = ans.get(i);
        }
        return answer;
    }
}
class Best{
    String genre;
    int count;
    int index;
    
    public Best(String genre, int count, int index){
        this.genre = genre;
        this.count = count;
        this.index = index;
    }
}