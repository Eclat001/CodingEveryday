package facebook;

public class BTBSSCooldown {
/*buy[i] means before day i what is the maxProfit for any sequence end with buy.        buy[i] = max(rest[i-1]-price,  buy[i-1])
  sell[i] means before day i what is the maxProfit for any sequence end with sell.      sell[i] = max(buy[i-1]+price, sell[i-1])
  rest[i] means before day i what is the maxProfit for any sequence end with rest. rest[i] = max(sell[i-1, buy[i-1], rest[i-1]])
**/
    
    //buy[i] <= sell[i]   ==>  rest[i] = max(sell[i-1], rest[i-1])   to make sure [buy, rest, buy] is never occured
    //rest[i] <= sell[i]  ==>  rest[i] = sell[i-1] ==> buy[i] = max(sell[i-2]-price, buy[i-1])
    //                                                 sell[i] = max(buy[i-1]+price, sell[i-1])
    //Time O(n) Space O(1)
    public int maxProfit(int[] prices) {
        int sell = 0;
        int pre_sell = 0;
        int buy = Integer.MIN_VALUE;
        int pre_buy;
        for (int price: prices) {
            pre_buy = buy;
            buy = Math.max(pre_sell - price, pre_buy);
            pre_sell = sell;
            sell = Math.max(pre_buy + price, pre_sell);
        }
        return sell;
    }
}
