package first;

import java.util.Map;
import java.util.HashMap;

public class ContSubSum {
	//(a+(n*x))%x is same as (a%x)
    //Time O(n) Space O(k)
    public boolean checkSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>(){{put(0, -1);}};;
        int runningSum = 0;
        for (int i = 0; i < nums.length; i++) {
            runningSum += nums[i];
            if (k != 0) {
                runningSum %= k;
            }
            Integer pre = map.get(runningSum);
            if (pre != null) {
                if (i - pre > 1) {
                    return true;
                }
            }
            else {
                map.put(runningSum, i);
            }
        }
        return false;
    }
    
    public static void main(String[] args) {
    	int[] nums1 = {23, 2, 4, 6, 7};
    	int[] nums2 = {23, 2, 6, 4, 7};
    	int k = 6;
    	ContSubSum cs = new ContSubSum();
    	System.out.println(cs.checkSubarraySum(nums1, k));
    	System.out.println(cs.checkSubarraySum(nums2, k));
    }
}
