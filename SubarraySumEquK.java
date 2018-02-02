package first;

import java.util.HashMap;
import java.util.Map;

public class SubarraySumEquK {
	//if we know SUM[0, i - 1] and SUM[0, j], then we can easily get SUM[i, j]. 
    //Time O(n) Space O(n)
    public int subarraySum(int[] nums, int k) {
        int sum = 0, rst = 0;
        Map<Integer, Integer> preSum = new HashMap<>();
        preSum.put(0, 1); //sum is the presum for first i+1 numbers in the array, e.g., sum of first 1 number is nums[0].                                     preSum.put(0,1); because the sum of first 0 number is 0 and this is an empty array[], which is also a                             subarray for nums. In other words, the number of time sum = 0 exists is 1
        
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (preSum.containsKey(sum - k)) {
                rst += preSum.get(sum - k);
            }
            preSum.put(sum, preSum.getOrDefault(sum, 0) + 1);
        }
        return rst;
    }
    
    public static void main(String[] args) {
    	int[] nums = {1, 1, 1};
    	int k = 2;
    	SubarraySumEquK ss = new SubarraySumEquK();
    	System.out.println(ss.subarraySum(nums, k));
    }
}
