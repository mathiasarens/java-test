import java.util.AbstractMap;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Map;

public class StockMaximize {

    // Stock span problem!!
    static long stockmax(int[] prices) {
        long profit = 0;
        int currentMax = 0;
        for (int i = prices.length-1; i>=0; i--) {
            if (prices[i] >= currentMax)
                currentMax = prices[i];
            profit += currentMax - prices[i];
        }
        return profit;
    }

    public static void main(String[] args) {
        System.out.println(stockmax(new int[]{1,2})==1);
        System.out.println(stockmax(new int[]{2,1})==0);
        System.out.println(stockmax(new int[]{2,1,3,5,2,1})==9);
        System.out.println(stockmax(new int[]{5,3,2})==0);
        System.out.println(stockmax(new int[]{1,2,100})==197);
        System.out.println(stockmax(new int[]{1,3,1,2})==3);
        System.out.println(stockmax(new int[]{5,4,3,4,5})==4);
    }

    static int stockmaxWrong(int[] prices) {
        int[] maxProfit = new int[prices.length];
        for (int i = 1; i < prices.length; i++) {
            if (prices[i-1] < prices[i]) {
                maxProfit[i] = maxProfit[i-1] + prices[i] - prices[i-1];
            } else {
                maxProfit[i] = maxProfit[i-1];
            }
        }
        return maxProfit[maxProfit.length-1];
    }
}
