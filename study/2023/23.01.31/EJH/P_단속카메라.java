import java.util.*;

public class P_단속카메라 {

    class Solution {
        public int solution(int[][] routes) {
            Arrays.sort(routes, (r1,r2)-> Integer.compare(r1[1], r2[1]));
            int cnt = 0;

            int min = Integer.MIN_VALUE;
            for(int[] route : routes) {
                if(min <  route[0] ) {
                    min = route[1];
                    ++cnt;
                }
            }
            return cnt;
        }
    }
}
