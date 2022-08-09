import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        
        //우선순위큐에 넣고 알아서 오름차순 정렬
        PriorityQueue<Integer> foods = new PriorityQueue<>();
        
        for(int food : scoville){
            foods.add(food);
        }
        int spicy = 0;
        
        while(true){
            //쓱 봤는데 스코빌 지수 넘겼으면 그만하기
            if(foods.peek() >= K) 
                break;
            
            //더이상 빼낼 음식이 없는 지경까지 오면 -1 리턴
            if(foods.size() <= 1)
                return -1;
            
            int Min = foods.poll();
            int Min2 = foods.poll();
            
            spicy = Min + (Min2*2);        
            answer++;
            foods.add(spicy);
            
        }
        
        return answer;
    }
}