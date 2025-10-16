class Solution {
    int[] dp = new int[1001]; 
    public int minCostClimbingStairs(int[] cost) {
        // cost[i]가 0일수도 있음
        Arrays.fill(dp,-1);
        
        dp[0] = cost[0];
        dp[1] = cost[1];

        
        return dynamic(cost.length, cost);
    }

    public int dynamic(int n, int[] cost) {
        if (dp[n] != -1) return dp[n];

        if(n == cost.length) {
            return dp[n] = Math.min(dynamic(n-2, cost), dynamic(n-1, cost));
        } else {
            return dp[n] = Math.min(dynamic(n-2, cost), dynamic(n-1, cost)) + cost[n];
        }
    }
}