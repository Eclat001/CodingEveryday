package first;

import java.util.Arrays;

public class ThreeSumClosest {
	public int threeSumClosest(int[] nums, int target) {
        if (nums == null || nums.length < 3) {
            return Integer.MAX_VALUE;
        }
        int closest = Integer.MAX_VALUE / 2;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            int l = i + 1;
            int r = nums.length - 1;
            while (l < r) {
                int sum = nums[i] + nums[l] + nums[r];
                if (sum == target) {
                    return target;
                }
                else if (sum > target) {
                    r--;
                }
                else {
                    l++;
                }
                closest = Math.abs(target - sum) > Math.abs(target - closest) ? closest : sum;
            }
        }
        return closest;
    }
	public static void main(String[] args) {
		ThreeSumClosest tsc = new ThreeSumClosest();
		int[] nums = {-1, 2, 1, -4};
		int target = 1;
		System.out.println(tsc.threeSumClosest(nums, target));
	}
}
