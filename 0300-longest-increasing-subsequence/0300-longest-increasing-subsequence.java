class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        if (n == 1) return 1;

        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int answer = 0;

        for(int i = 0; i < n ; i++) {
            for(int j = 0; j < i; j++) {
                if(nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
                answer = Math.max(answer, dp[i]);
            }
        }
        return answer;
    }
}