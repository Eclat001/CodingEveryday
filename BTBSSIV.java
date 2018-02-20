package facebook;

public class BTBSSIV {
	//local[i][j]=max(global[i-1][j-1]+max(diff,0),local[i-1][j]+diff)
    //global[i][j]=max(local[i][j],global[i-1][j])
    //Time O(nk) Space O(k) 
    public int maxProfit(int k, int[] prices) {
        if (prices == null || prices.length <= 1 || k <= 0) return 0;
        
        int diff = 0;
        //问题的实质是从长度为n的prices数组中挑选出至多2 * k个元素，组成一个交易（买卖）序列
        if (k > prices.length / 2) {
            int profit = 0;
            for (int i = 0; i < prices.length - 1; i++) {
                diff = prices[i + 1] - prices[i];
                if (diff >= 0) profit += diff; 
            }
            return profit;
        }
        
        int[] local = new int[k + 1];
        int[] global = new int[k + 1];
        for (int i = 0; i < prices.length - 1; i++) {
            diff = prices[i + 1] - prices[i];
            for (int j = k; j >= 1; j--) {
                local[j] = Math.max(global[j - 1] + Math.max(diff, 0), local[j] + diff);
                global[j] = Math.max(local[j], global[j]);
            }
        }
        return global[k];
    }
}
