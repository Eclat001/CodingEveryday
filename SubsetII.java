package facebook;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetII {
	//时间和空间都是取决于结果的数量，也就是O(2^n) the power set -- 空间指extra的话，这里则为递归所用的栈大小O(logn)
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> rst = new ArrayList<>();
        if (nums == null || nums.length == 0) return rst;
        Arrays.sort(nums);
        backtrack(nums, 0, rst, new ArrayList<>());
        return rst;
    }
    
    private void backtrack(int[] nums, int pos, List<List<Integer>> rst, List<Integer> list) {
        rst.add(new ArrayList<Integer>(list));
        for (int i = pos; i < nums.length; i++) {
            if (i > pos && nums[i] == nums[i - 1]) continue;    //avoid duplicate
            list.add(nums[i]);
            backtrack(nums, i + 1, rst, list);
            list.remove(list.size() - 1);
        }
    }
}
