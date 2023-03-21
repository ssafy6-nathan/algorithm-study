import java.util.*;
public class P_161988 {
    // 연속 펄스 부분 수열의 합
    class Solution {
        public long solution(int[] sequence) {
            long answer = 0;
            int perse = -1;
            long[] sum = new long[sequence.length + 1];
            long min = Long.MAX_VALUE;
            long max = Long.MIN_VALUE;

            for (int i = 1; i < sum.length ; i++){
                sum[i] = sum[i - 1] + (long) sequence[i - 1] * perse;
                perse *= -1;
            }

            for (int i = 0; i < sum.length ; i++){
                if(max < sum[i]) max = sum[i];
                if(min > sum[i]) min = sum[i];

            }
            answer = max - min;

            return answer;
        }
    }
}
