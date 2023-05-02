class Solution {

    public int[] productExceptSelf(int[] nums) {

        int len = nums.length;
        int[] arr = new int[len];

        arr[0] = 1;

        for (int i = 1; i < len; i++) {
            arr[i] = arr[i - 1] * nums[i - 1];
        }

        int n = 1;

        for (int i = len - 1; i > 0; i--) {
            n *= nums[i];
            arr[i - 1] *= n;
        }

        return arr;

    }

}
