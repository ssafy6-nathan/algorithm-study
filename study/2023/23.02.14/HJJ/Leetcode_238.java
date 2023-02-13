package study.nathan_algo_study.week47;

/**
 * 문제이름 : Product of Array Except Self
 * 링크 : https://leetcode.com/problems/product-of-array-except-self/
 */

public class Leetcode_238 {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];

        int left = 1;
        for (int i = 0; i < n; i++) {
            result[i] = left;
            left *= nums[i];

        }

        int right = 1;
        for (int i = n - 1; i >= 0; i--) {
            result[i] *= right;
            right *= nums[i];
        }

        return result;
    }
}

/*
1 2 3 4

1 0 0 0
1 1 2 6

1 1 2 6
1 1 8 6
1 12 8 6
24 12 8 6

*/
