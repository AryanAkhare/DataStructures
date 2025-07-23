package Arrays;

/**
 * Problem: Best Time to Buy and Sell Stock (LeetCode 121)
 * --------------------------------------
 * You are given an array 'prices' where prices[i] is the price of a given stock on day 'i'.
 * You want to maximize your profit by choosing a single day to buy one stock and 
 * choosing a different day in the future to sell that stock.
 * 
 * Return the maximum profit you can achieve from this transaction.
 * If no profit can be made, return 0.
 * 
 * Constraint:
 * - Only one transaction allowed (buy once, sell once).
 * - Cannot sell before buying.
 * 
 * Example:
 * --------
 * Input: prices = [7, 1, 5, 3, 6, 4]
 * Output: 5
 * Explanation:
 * Buy on day 1 (price = 1), Sell on day 4 (price = 6), Profit = 6 - 1 = 5.
 * 
 * Input: prices = [7, 6, 4, 3, 1]
 * Output: 0
 * Explanation:
 * No transaction is done, as prices are always decreasing.
 */

public class BuyandSellStock {

    // Function to calculate the maximum profit from buying and selling stock once
    public static int maxProfit(int prices[]) {
        int profit = 0;              // Maximum profit seen so far
        int min = prices[0];         // Minimum price so far (buying price)

        for (int i = 1; i < prices.length; i++) {
            int cost = prices[i] - min;       // Profit if we sell at prices[i]
            profit = Math.max(profit, cost);  // Update max profit if current is better
            min = Math.min(min, prices[i]);   // Update min if we find a lower price
        }

        return profit;
    }

    public static void main(String[] args) {
        // Test Case 1
        int[] prices1 = {7, 1, 5, 3, 6, 4};
        int result1 = maxProfit(prices1);
        System.out.println("Test Case 1: Maximum Profit = " + result1);
        // Explanation: Buy at 1 (day 1), sell at 6 (day 4) → Profit = 6 - 1 = 5

        // Test Case 2
        int[] prices2 = {7, 6, 4, 3, 1};
        int result2 = maxProfit(prices2);
        System.out.println("Test Case 2: Maximum Profit = " + result2);
        // Explanation: No profitable transaction possible → Output = 0
    }
}
