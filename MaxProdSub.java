package first;

public class MaxProdSub {
	//在维护一个局部最大的同时，再维护一个局部最小
    //Time O(n) Space O(1)
    public int maxProduct(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int max = nums[0], min = nums[0], global = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int temp = max;
            max = Math.max(Math.max(max * nums[i], min * nums[i]), nums[i]);
            min = Math.min(Math.min(temp * nums[i], min * nums[i]), nums[i]);
            global = Math.max(global, max);
        }
        return global;
    }
    
    public static void main(String[] args) {
    	int[] nums = {2, 3, -2, 4};
    	MaxProdSub mp = new MaxProdSub();
    	System.out.println(mp.maxProduct(nums));
    }
}
