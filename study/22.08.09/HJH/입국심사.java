import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        Arrays.sort(times); // 시간 순 정렬
        return search(n, times, times[times.length - 1]);
    }
    
    long search(int n, int[] times, long max) {
        long start = 1;
        long end = max * n; // 최대로 걸리는 시간
        long mid = 0; // 초기화
        long answer = Long.MAX_VALUE;
        
        while (start <= end) {  // pivot 역전되기 전까진 돌려
            mid = (start + end)/2;
            if(isInRange(n, times, mid)) {
                answer = answer > mid ? mid : answer;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return answer;
    }
    
    boolean isInRange(int n, int[] times, long mid) {
        long amount = 0;
        for(int i = 0; i < times.length; i++) {
            amount += mid/times[i];
        }
        if (amount >= n) return true;
        else return false;
    }
}
