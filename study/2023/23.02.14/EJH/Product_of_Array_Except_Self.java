public class Product_of_Array_Except_Self {
    public int[] productExceptSelf(int[] nums) {
        int N = nums.length;
        int[] result = new int[N];

        int[] t1 = new int[N];
        int[] t2 = new int[N];

        t1[0]=1;
        t2[N-1]=1;

        for(int i=1; i<N; i++){
            t1[i] = nums[i - 1] * t1[i - 1];
            t2[N - i - 1] = t2[N - i] * nums[N - i];
        }

        for(int i=0; i<nums.length; i++){
            result[i] = t1[i] * t2[i];
        }

        return result;

    }
}
