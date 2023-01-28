import java.util.*;

class Solution {
    static ArrayList<Drive> driving;
    
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0; // 총 걸린 시간
        int truck = 0;//완주한 트럭 개수
        driving = new ArrayList<>(); //현재 다리위에 있는 트럭의 무게와 입장 시간
        
        int sum = 0;
        
        while(true){
            if(truck == truck_weights.length)
                break;
            
            if(driving.size() <= truck_weights.length && driving.size()-truck > 0 && (answer-driving.get(truck).time) == bridge_length){   
                
                sum -= driving.get(truck).weight;
                truck++;
                
            }
            
            
            if(driving.size() < truck_weights.length 
               && bridge_length > driving.size()-truck){
               
                if(sum + truck_weights[driving.size()] <= weight){
                    sum += truck_weights[driving.size()];
                    driving.add(new Drive(truck_weights[driving.size()], answer));
                    
                }
            }
            answer++;
        } 
        
        return answer;
    }
}
class Drive{
    int weight;
    int time;
    public Drive(int weight, int time){
        this.weight = weight;
        this.time = time;
    }
}
