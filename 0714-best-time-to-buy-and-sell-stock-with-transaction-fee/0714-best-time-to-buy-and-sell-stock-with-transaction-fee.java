class Solution {
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];

        // 주식을 보유하거나 보유하지 않음 - 두개의 상태
        for(int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] + prices[i] - fee); // 주식을 팔았거나 안팔았거나
            dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0] - prices[i]); // 주식을 샀거나 안샀거나 
        }

        return dp[n-1][0];
    }
}