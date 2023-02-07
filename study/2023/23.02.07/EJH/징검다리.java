import java.util.Arrays;

public class 징검다리 {
    public int solution(int distance, int[] rocks, int n) {
        int answer = 0;
        int left = 0, right = distance;

        Arrays.sort(rocks);
        while(left <= right) {
            int mid = (left + right) / 2;
            int removeRocks = 0;
            int prev = 0;

            for(int i = 0; i < rocks.length; i++) {
                if (rocks[i] - prev < mid)
                    removeRocks++;
                else
                    prev = rocks[i];
            }
            if(distance - rocks[rocks.length-1] < mid)
                removeRocks++;
            if(removeRocks <= n) {
                answer = mid;
                left = mid + 1;
            }
            else
                right = mid - 1;
        }
        return answer;
    }
}
