package facebook;

public class MaxSumOfThreeSub {
	//If the middle interval is [i, i+k-1], where k <= i <= n-2k, the left interval has to be in subrange [0, i-1], and the right interval is from subrange [i+k, n-1].
    //posLeft[i] is the starting index for the left interval in range [0, i];
    //posRight[i] is the starting index for the right interval in range [i, n-1]; 
    //Then we test every possible starting index of middle interval, i.e. k <= i <= n-2k, and we can get the corresponding left and right max sum intervals easily from DP. And the run time is O(n).
    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        int n = nums.length, maxsum = 0;
        int[] sum = new int[n + 1];
        int[] posLeft = new int[n];
        int[] posRight = new int[n];
        int[] rst = new int[3];
        for (int i = 0; i < n; i++) {
            sum[i + 1] = sum[i] + nums[i];
        }
        //DP for starting index of the left max sum interval
        for (int i = k, tot = sum[k] - sum[0]; i < n; i++) {
            if (sum[i + 1] - sum[i + 1 - k] > tot) {
                posLeft[i] = i + 1 - k;
                tot = sum[i + 1] - sum[i + 1 - k];
            }
            else {
                posLeft[i] = posLeft[i - 1];
            }
        }
        
        // DP for starting index of the right max sum interval
        // caution: the condition is ">= tot" for right interval, and "> tot" for left interval
        
        posRight[n - k] = n - k;
        for(int i = n - 1 - k, tot = sum[n] - sum[n - k]; i >= 0; i--) {
            if (sum[i + k] - sum[i] >= tot) {
                posRight[i] = i;
                tot = sum[i + k] - sum[i];
            }
            else {
                posRight[i] = posRight[i + 1];
            }
        }
        
        // test all possible middle interval
        for (int i = k; i <= n - 2 * k; i++) {
            int l = posLeft[i - 1], r = posRight[i + k];
            int tot = sum[i + k] - sum[i] + sum[l + k] - sum[l] + sum[r + k] - sum[r];
            if (tot > maxsum) {
                maxsum = tot;
                rst[0] = l; rst[1] = i; rst[2] = r;
            }
        }
        return rst;
    }
    public static void main(String[] args) {
    	int[] nums = {1, 2, 1, 2, 6, 7, 5, 1};
    	int k = 2;
    	MaxSumOfThreeSub ms = new MaxSumOfThreeSub();
    	System.out.println(ms.maxSumOfThreeSubarrays(nums, k));
    	
    }
}
