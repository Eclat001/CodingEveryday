package facebook;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subset {
	//时间和空间都是取决于结果的数量, the power set
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> rst = new ArrayList<>();
        if (nums == null || nums.length == 0) return rst;
        Arrays.sort(nums);
        backtrack(nums, 0, rst, new ArrayList<>());
        return rst;
    }
    
    private void backtrack(int[] nums, int pos, List<List<Integer>> rst, List<Integer> list) {
        rst.add(new ArrayList<>(list));
        for (int i = pos; i < nums.length; i++) {
            list.add(nums[i]);
            backtrack(nums, i + 1, rst, list);
            list.remove(list.size() - 1);
        }
    }
}
