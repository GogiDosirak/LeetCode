class Solution {
    public int minCostClimbingStairs(int[] cost) {
        // 최소로 가는법 -> n-2 또는 n-1을 최소로 갱신 -> 거기서 점프하는게 현재 칸까지 올 수 있는 최소 비용
        // n칸 도달 -> n-1 또는 n-2까지 올 수 있는 최소비용 중에 최소비용
        int n = cost.length;
        int[] dp = new int[n + 1];

        dp[0] = cost[0];
        dp[1] = cost[1];

        for(int i = 2; i <= n; i++) {
            if(i == n) {
                dp[i] = Math.min(dp[i-1], dp[i-2]);
            } else {
                dp[i] = Math.min(dp[i-1],dp[i-2]) + cost[i];
            }
        }
        return dp[n];
    }
}