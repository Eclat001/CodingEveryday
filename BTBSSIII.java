package facebook;

public class BTBSSIII {
	//第i天一定卖出,local[i][j],分两种情况:
    //1.第i-1天已经进行了j次买卖并且有卖出local[i-1][j],则撤销第i-1天的卖出,改为第i天卖出,local[i-1][j]-p[i-1]+p[i]；
    //2.第i-1天不一定卖出global,最后一次卖出在第i天,global[i-1][j-1],考虑两种情况,第i-1天买进第i天卖出或者第i天买进第i天卖出max(-p[i-1]+p[i],0) 
    //Time O(n * k) = O(n) Space O(k) = O(1)  -- k = 2
    //Local[i][j] = max(Local[i-1][j]+diff, global[i-1][j-1]+max(diff,0))
    //global[i][j] = max(Local[i][j], global[i-1][j])
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length <=1) return 0;
        
        int[] local = new int[3];
        int[] global = new int[3];
        for (int i = 0; i < prices.length - 1; i++) {
            int diff = prices[i + 1] - prices[i];
            for (int j = 2; j >= 1; j--) {
                local[j] = Math.max(local[j] + diff, global[j - 1] + Math.max(diff, 0));
                global[j] = Math.max(local[j], global[j]);
            }
        }
        return global[2];
    }
}
