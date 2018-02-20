package facebook;

public class BTBSS {
	//local[i+1]=max(local[i]+prices[i+1]-price[i],0), global[i+1]=max(local[i+1],global[i])
    //Time O(n) Space O(1)
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1) return 0;
        int maxCur = 0;
        int maxSofar = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            maxCur = Math.max(maxCur + prices[i + 1] - prices[i], 0);
            maxSofar = Math.max(maxCur, maxSofar);
        }
        return maxSofar;
    }
    
    public static void main(String[] args) {
    	int[] prices = {7, 1, 5, 3, 6, 4};
    	BTBSS bt = new BTBSS();
    	System.out.println(bt.maxProfit(prices));
    }
}
