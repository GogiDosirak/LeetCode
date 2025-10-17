class Solution {
    public int coinChange(int[] coins, int amount) {
    // amount를 나타낼 수 있는 최소 코인의 수를 나타내는 문제
    // 만들 수 없다면 -1 반환
    // 코인은 중복 사용 가능
    // 코인을 하나하나 조합해가면서 탐색하는 완전탐색(BFS, DFS)도 가능하지만,
    // amount를 만들 수 있는 코인의 최소 수는 amount - coins[i~j]까지의 최소 + 1

    int[] dp = new int[amount + 1];
    Arrays.fill(dp, Integer.MAX_VALUE);
    dp[0] = 0;

    // 초기세팅
    for(int i = 0; i < coins.length; i++) {
        if(dp.length > coins[i]) {
            dp[coins[i]] = 1;
        }
    }

    for(int i = 1; i <= amount; i++) {
        for(int j = 0; j < coins.length; j++) {
            if(i - coins[j] >= 0 && dp[i - coins[j]] != Integer.MAX_VALUE) {
                dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
            }
        }
    }

    // MAX_VALUE라면 도달이 불가능한 것 -> -1 반환
    return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];

    }
}