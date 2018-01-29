package first;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {
	public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> rst = new ArrayList<List<Integer>>();
        if (nums == null || nums.length < 4) {
            return rst;
        }
        
        Arrays.sort(nums);
        int len = nums.length;
        int max = nums[len - 1];
        if (4 * nums[0] > target || 4 * max < target) {
            return rst;
        }
        
        int i, cur;
        for (i = 0; i < len - 3; i ++) {
            cur = nums[i];
            if (i != 0 && cur == nums[i - 1]) {
                continue;
            }
            if (cur + 3 * max < target) { // cur is too small
                continue;
            }
            if (4 * cur > target) {  // cur is too larget
                break;
            }
            if (4 * cur == target) {  //cur is the boundary 
                if (i + 3 < len && nums[i + 3] == cur) {
                    rst.add(Arrays.asList(cur, cur, cur, cur));
                }
                break;
            }
            threeSumForFourSum(nums, target - cur, i + 1, len - 1, rst, cur);
        }
        return rst;
    }
    
    public void threeSumForFourSum(int[] nums, int target, int l, int r, List<List<Integer>> rst, int p) {
        if (l + 1 >= r) {
            return;
        }
        int max = nums[r];
        if (3 * nums[l] > target || 3 * nums[r] < target) {
            return;
        }
        int i, cur;
        for (i = l; i < r - 1; i++) {
            cur = nums[i];
            if (i != l && cur == nums[i - 1]) {
                continue;
            }
            if (cur + 2 * max < target) {
                continue;
            }
            if (3 * cur > target) {
                break;
            }
            if (3 * cur == target) {
                if (i + 2 <= r && nums[i + 2] == cur) {
                    rst.add(Arrays.asList(p, cur, cur, cur));
                }
                break;
            }
            twoSumForFourSum(nums, target - cur, i + 1, r, rst, p, cur);
        }
    }
    
    public void twoSumForFourSum(int[] nums, int target, int l, int r, List<List<Integer>> rst, int p1, int p2) {
        if (l >= r) {
            return;
        }
        if (2 * nums[l] > target || 2 * nums[r] < target) {
            return;
        }
        int i = l, j = r, sum, cur;
        while (i < j) {
            sum = nums[i] + nums[j];
            if (sum == target) {
                rst.add(Arrays.asList(p1, p2, nums[i], nums[j]));
                cur = nums[i];
                while (++i < j && cur == nums[i]) {
                    ;
                }
                cur = nums[j];
                while (--j > i && cur == nums[j]) {
                    ;
                }
            }
            if (sum < target) {
                i++;
            }
            if (sum > target) {
                j--;
            }
        }
        return;
    }
    
    public static void main(String[] args) {
    	FourSum fs = new FourSum();
    	int[] nums = {1, 0, -1, 0, -2, 2};
    	int target = 0;
    	System.out.println(fs.fourSum(nums, target));
    }
}
