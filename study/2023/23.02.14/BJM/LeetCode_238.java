package week47;

import java.util.Arrays;

public class LeetCode_238 {
    public static void main(String[] args) {
        int[][] nums = {{1,2,3,4}, {-1,1,0,-3,3}};
        for (int[] num : nums) {
            System.out.println(Arrays.toString(productExceptSelf(num)));
        }
    }
    public static int[] productExceptSelf(int[] nums) {
        int[] answer = new int[nums.length];
        Arrays.fill(answer, 1);

        // 1. 정방향 곱셈 계산
        int left = 1;
        for (int i = 0; i < nums.length; i++) {
            answer[i] *= left;
            left *= nums[i];
        }

        // 2. 역방향 곱셈 계산
        int right = 1;
        for (int i = nums.length - 1; i >= 0 ; i--) {
            answer[i] *= right;
            right *= nums[i];
        }
        
        return answer;
    }
}
