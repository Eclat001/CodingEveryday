package first;

public class FindPivot {
	public int pivotIndex(int[] nums) {
        int sum = 0, left = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            if (i != 0) {
                left += nums[i - 1];
            }
            if (sum - left - nums[i] == left) {
                return i;
            }
        }
        return -1;
    }
	
	public static void main(String[] args) {
		int[] nums = {1, 7, 3, 6 ,5, 6};
		FindPivot fp = new FindPivot();
		System.out.println(fp.pivotIndex(nums));
	}
}
