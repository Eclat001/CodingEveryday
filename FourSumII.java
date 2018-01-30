package first;

import java.util.HashMap;
import java.util.Map;

public class FourSumII {
	//Time O(n^2) Space O(n^2)
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int rst = 0;
        
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                int sum = A[i] + B[j];
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }
        }
        
        for (int i = 0; i < C.length; i++) {
            for (int j = 0; j < D.length; j++) {
                rst += map.getOrDefault(-1 * (C[i] + D[j]), 0);
            }
        }
        
        return rst;
    }
    
    public static void main(String[] args) {
    	int[] A = {1, 2};
    	int[] B = {-2, -1};
    	int[] C = {-1, 2};
    	int[] D = {0, 2};
    	FourSumII fs = new FourSumII();
    	System.out.println(fs.fourSumCount(A, B, C, D));
    }
}
