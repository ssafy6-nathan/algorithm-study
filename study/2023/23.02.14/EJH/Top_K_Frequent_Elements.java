import java.util.*;
public class Top_K_Frequent_Elements {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        Queue<Integer> pq = new PriorityQueue<>(
                (a, b) -> map.get(b) - map.get(a)
        );

        for (Integer num : map.keySet()) {
            pq.add(num);
        }
        int[] answer = new int[k];
        for (int i = 0; i < k; i++) {
            answer[i] = pq.poll();
        }

        return answer;
    }
}
