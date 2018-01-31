package first;

public class TwoSumII {
	public int[] twoSum(int[] numbers, int target) {
        int[] rst = new int[2];
        if (numbers == null || numbers.length < 2) {
            return rst;
        }
        int l = 0, r = numbers.length - 1;
        while (l < r) {
            int sum = numbers[l] + numbers[r];
            if (sum == target) {
                rst[0] = l + 1;
                rst[1] = r + 1;
                break;
            }
            else if (sum < target) {
                l++;
            }
            else {
                r--;
            }
        }
        return rst;
    }
	
	public static void main(String[] args) {
		int[] nums = {2, 7, 11, 15};
		int target = 9;
		TwoSumII ts = new TwoSumII();
		System.out.println(ts.twoSum(nums, target));
	}
}
