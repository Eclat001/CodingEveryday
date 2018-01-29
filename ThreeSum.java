package first;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
	public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> rst = new ArrayList<List<Integer>>();
        if (nums == null || nums.length < 3) {
            return rst;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i ++) {
            if (i != 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int l = i + 1;
            int r = nums.length - 1;
            while (l < r) {
                if (nums[i] + nums[l] + nums[r] == 0) {
                    List<Integer> list = new ArrayList<Integer>();
                    list.add(nums[i]);
                    list.add(nums[l]);
                    list.add(nums[r]);
                    rst.add(list);
                    l++;
                    r--;
                    while (l < nums.length - 1 && nums[l] == nums[l - 1]) {
                        l++;
                    }
                    while (r > 0 && nums[r] == nums[r + 1]) {
                        r--;
                    }
                } else if (nums[i] + nums[l] + nums[r] > 0) {
                    r--;
                } else {
                    l++;
                }
            }
        }
        return rst;
    }
	
	public static void main(String[] args) {
		ThreeSum ts = new ThreeSum();
		int[] nums = {-1, 0, 1, 2, -1, -4};
		System.out.println(ts.threeSum(nums));
	}
}
