package facebook;

import java.util.HashMap;
import java.util.Map;

/* Given an array nums and a target value k, find the maximum length of a subarray that sums to k. If there 
 * isn't one, return 0 instead.
 * Example 1: Given nums = [1, -1, 5, -2, 3], k = 3, return 4. 
 * (because the subarray [1, -1, 5, -2] sums to 3 and is the longest)
 * Example 2: Given nums = [-2, -1, 2, 1], k = 1, return 2. 
 * (because the subarray [-1, 2] sums to 1 and is the longest)
 * Follow Up: Can you do it in O(n) time?
 * */

public class MaxSizeSub {
	public static int maxSubArrayLen(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int max = 0, sum = 0;
        map.put(0, -1);    //add this fake entry to make sum from 0 to j consistent
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sum == k) {
                max = i + 1;
            }
            else if (map.containsKey(sum - k)) {
                max = Math.max(max, i - map.get(sum - k));
            }
            if (!map.containsKey(sum)) {
                map.put(sum, i);
            }
        }
        return max;
    }
	public static void main(String... args) {
		int[] n1 = {1, -1, 5, -2, 3};
		int k1 = 3;
		int[] n2 = {-2, -1, 2, 1};
		int k2 = 1;
		MaxSizeSub ms = new MaxSizeSub();
		System.out.println(ms.maxSubArrayLen(n1, k1));
		System.out.println(ms.maxSubArrayLen(n2, k2));
	}
}
