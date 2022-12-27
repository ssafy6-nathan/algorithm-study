import java.util.*;

class Solution {

    public int solution(int[] queue1, int[] queue2) {

        int len = queue1.length, size = len * 2;
        int[] queue = new int[size];
        long sum1 = 0, sum2 = 0;

        for (int i = 0; i < len; i++) {
            int n1 = queue1[i];
            int n2 = queue2[i];

            queue[i] = n1;
            queue[len + i] = n2;

            sum1 += n1;
            sum2 += n2;
        }

        if ((sum1 + sum2) % 2 != 0) return -1;

        int cnt = 0, idx1 = 0, idx2 = len;

        while (sum1 != sum2) {
            if (sum1 > sum2) {
                sum1 -= queue[idx1];
                sum2 += queue[idx1];

                idx1++;
            } else {
                sum1 += queue[idx2];
                sum2 -= queue[idx2];

                idx2++;
            }

            cnt++;

            if (idx1 >= size || idx2 >= size) return -1;
        }

        return cnt;

    }

}
