class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];

        for(int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] + prices[i]);
            if(i == 1) {
                dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0] - prices[i]);
            } else {
            dp[i][1] = Math.max(dp[i-1][1], dp[i-2][0] - prices[i]);
            } // 어제 판 경우라면 사면 안되므로, 이틀전걸로 계산
        }

        return dp[n-1][0];
    }
}