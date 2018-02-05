package first;

public class SubarrayProdLessK {
	//Time O(n) Space O(1)
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 1) {
            return 0;
        }
        int product = 1, rst = 0, left = 0;
        for (int i = 0; i < nums.length; i++) {
            product *= nums[i];
            while(product >= k) {
                product /= nums[left++];
            }
            rst += i - left + 1;
        }
        return rst;
    }
    
    public static void main(String[] args) {
    	int[] nums = {10, 5, 2, 6};
    	int k = 100;
    	SubarrayProdLessK sp = new SubarrayProdLessK();
    	System.out.println(sp.numSubarrayProductLessThanK(nums, k));
    }
}
