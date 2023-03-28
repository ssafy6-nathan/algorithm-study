package study.nathan_algo_study.week47;

import java.util.*;

/**
 * 문제이름 : Top K Frequent Elements
 * 링크 : https://leetcode.com/problems/top-k-frequent-elements/
 */

public class Leetcode_347 {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> numFrequents = new HashMap<>();

        for (int i = 0; i < nums.length; i++)
            numFrequents.put(nums[i], numFrequents.getOrDefault(nums[i], 0) + 1);

        List<Map.Entry<Integer, Integer>> entryList = new LinkedList<>(numFrequents.entrySet());

        entryList.sort((i1, i2) -> {
            return i2.getValue() - i1.getValue();
        });

        List<Integer> result = new ArrayList<>();
        int idx = 0;
        for (Map.Entry<Integer, Integer> entry : entryList) {
            if (idx == k)
                break;

            result.add(entry.getKey());
            idx++;
        }

        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}

/*

 */
