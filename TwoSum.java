package first;

import java.util.HashMap;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        int[] rst = new int[2];
        if (nums == null || nums.length < 2) {
            return rst;
        }
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            int ans = target - nums[i];
            if (map.containsKey(ans) && map.get(ans) != i) {
                rst[0] = map.get(ans);
                rst[1] = i;
            } 
            map.put(nums[i], i);
        }
        return rst;
    }
	
    public static void main(String[] args) {
    	TwoSum ts = new TwoSum();
    	int[] nums = {2, 7, 11, 15};
    	int target = 9;
    	System.out.println(ts.twoSum(nums, target));
    }
}
