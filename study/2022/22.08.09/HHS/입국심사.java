import java.util.*;

class Solution {
    
    public long solution(int n, int[] times) {
        long answer = 0;
    
        //0부터 최대시간까지 정해놓고 반씩 잘라가면서 확인하기
        //최대시간 : times sort해서 최댓값 * 인원수
        //반씩 자른 값을 각 심사관들의 일처리 시간으로 나눠 = 심사관이 해결할 수 있는 인원수
        //이 인원수들의 합이 n보다 크면 더 적은 시간으로 돌려보고
        //인원수들의 합이 n보다 작으면 시간 더 늘리기
        Arrays.sort(times);
        
        long min = 0;
        long max = (long)times[times.length-1] * n;

        while(min <= max){
            
            long mid = (min+max) / 2;
            
            long countSum = 0;
            for(int time : times){
                countSum += mid / time;
            }
            
            if(countSum >= n){
                //시간 더 줄여보기
                answer = mid;
                max = mid - 1;
            }else{
                //시간 더 필요
                min = mid + 1;
            }
            
        }
        
        return answer;
    }
}