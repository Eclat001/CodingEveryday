package first;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class KSum {
	List<List<Integer>> kSum(int[] nums, int target, int k){
		List<List<Integer>> rst = new ArrayList<List<Integer>>();
		if (nums == null || nums.length < k || k < 2) {
			return rst;
		}
		Arrays.sort(nums);
		kSum(nums, target, k, 0, rst, new ArrayList<Integer>());
		return rst;
	}
	
	void kSum(int[] nums, int target, int k, int p, List<List<Integer>> rst, List<Integer> list) {
		int max = nums[nums.length - 1];
		if (nums[p] * k > target || max * k < target) {
			return;
		}
		if (k == 2) {             // 2 sum
			int l = p;
			int r = nums.length - 1;
			while (l < r) {
				if (nums[l] + nums[r] < target) {
					l++;
				}
				else if (nums[l] + nums[r] > target) {
					r--;
				}
				else {
					rst.add(new ArrayList<Integer>(list));
					rst.get(rst.size() - 1).addAll(Arrays.asList(nums[l], nums[r]));
					l++; r--;
					while (l < r && nums[l] == nums[l - 1]) {
						l++;
					}
					while (l < r && nums[r] == nums[r + 1]) {
						r--;
					}
				}
			}
		}
		else {                   // k sum
			for (int i = p; i < nums.length - k + 1; i++) {
				if (i != p && nums[i] == nums[i - 1]) {
					continue;
				}
				if (nums[i] + max * (k - 1) < target) {
					continue;
				}
				if (nums[i] * k > target) {
					continue;
				}
				if (nums[i] * k == target) {
					if (nums[i + k - 1] == nums[i]) {
						rst.add(new ArrayList<Integer>(list));
						List<Integer> temp = new ArrayList<Integer>();
						for (int j = 0; j < k; j++) {
							temp.add(nums[i]);
						}
						rst.get(rst.size() - 1).addAll(temp);     //add result immediately
					}
					break;
				}
				list.add(nums[i]);
				kSum(nums, target - nums[i], k - 1, i + 1, rst, list);
				list.remove(list.size() - 1);    // backtracking
			}
		}
	}
	
	public static void main(String[] args) {
    	KSum ks = new KSum();
    	int[] nums = {1, 0, -1, 0, -2, 2};
    	int target = 0;
    	System.out.println(ks.kSum(nums, target, 4));
    }
}
