package first;

import java.util.Arrays;

public class ProdExcSelf {
	//One Pass,  Space O(1)
    public int[] productExceptSelf(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        int[] rst = new int[nums.length];
        Arrays.fill(rst, 1);
        int l = 1;
        int r = 1;
        for (int i = 0; i < nums.length; i++) {
            rst[i] *= l;
            rst[nums.length - 1 - i] *= r;
            l *= nums[i];
            r *= nums[nums.length - 1 - i];
        }
        return rst;
    }
    
    public static void main(String[] args) {
    	int[] nums = {1, 2, 3, 4};
    	ProdExcSelf pe = new ProdExcSelf();
    	System.out.println(pe.productExceptSelf(nums));
    }
}
