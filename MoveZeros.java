package facebook;

public class MoveZeros {
	//Shift non-zero values as far forward as possible
    //Fill remaining space with zeros
    //Time O(n)
    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }
        int insertPos = 0;
        for (int num : nums) {
            if (num != 0) {
                nums[insertPos++] = num;
            }
        }
        while (insertPos < nums.length) {
            nums[insertPos++] = 0;
        }
    }
    
    public static void main(String[] args) {
    	int[] nums = {0, 1, 0, 3, 12};
    	MoveZeros mz = new MoveZeros();
    	mz.moveZeroes(nums);
    	System.out.println(nums);
    }
}
