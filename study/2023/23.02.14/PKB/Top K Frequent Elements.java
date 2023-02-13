class Solution {

    public int[] topKFrequent(int[] nums, int k) {

        if (nums.length == k) return nums;

        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        List<Integer> list = new ArrayList<>(map.keySet());

        list.sort((o1, o2) -> map.get(o2) - map.get(o1));

        int[] arr = new int[k];

        for (int i = 0; i < k; i++) {
            arr[i] = list.get(i);
        }

        return arr;

    }

}
