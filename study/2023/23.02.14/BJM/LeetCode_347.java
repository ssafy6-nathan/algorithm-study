package week47;
import java.util.*;

public class LeetCode_347 {
    public static void main(String[] args) {
        int[][] nums = {{1,1,1,2,2,3}, {1}};
        int[] k = {2, 1};

        for (int i = 0; i < nums.length; i++) {
            System.out.println(Arrays.toString(topKFrequent(nums[i], k[i])));
        }
    }

    public static int[] topKFrequent(int[] nums, int k) {
        int[] answer = new int[k];
        HashMap<Integer, Integer> map = new HashMap<>();

        // 1. 숫자 별 빈도수 저장
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // 2. 빈도수 기준 내림차순 정렬
        List<Integer> keySet = new ArrayList<>(map.keySet());
        keySet.sort((o1, o2) -> map.get(o2).compareTo(map.get(o1)));

        // 3. 상위 k개 출력
        for (int i = 0; i < k; i++)
            answer[i] = keySet.get(i);

        return answer;
    }
}
