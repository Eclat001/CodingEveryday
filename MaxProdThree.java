package first;

public class MaxProdThree {
	//Simply find out the three largest numbers and the two smallest numbers using one pass
    //all positive - product of last three
    //one negative - product of last three
    //two or more negative - either product of first two and last or product of last three
    //Time O(n) Space O(1)
    public int maximumProduct(int[] nums) {
        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        int max3 = Integer.MIN_VALUE;
        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;
        
        for (int n : nums) {
            if (n > max1) {
                max3 = max2;
                max2 = max1;
                max1 = n;
            }
            else if (n > max2) {
                max3 = max2;
                max2 = n;
            }
            else if (n > max3) {
                max3 = n;
            }
            
            if (n < min1) {
                min2 = min1;
                min1 = n;
            } 
            else if (n < min2) {
                min2 = n;
            }
        }
        return Math.max(max1 * max2 * max3, max1 * min1 * min2);
    }
    public static void main(String[] args) {
    	int[] nums1 = {1, 2, 3};
    	int[] nums2 = {1, 2, 3, 4};
    	MaxProdThree mp = new MaxProdThree();
    	System.out.println(mp.maximumProduct(nums1));
    	System.out.println(mp.maximumProduct(nums2));
    }
}
