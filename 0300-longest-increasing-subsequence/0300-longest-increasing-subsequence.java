class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        if(n == 1) return 1;
        dp[0] = 1;
        int answer = 0;

        for(int i = 1; i < n; i++) {
            int max = 0;
            for(int j = 0; j < i; j++) {
                if(nums[i] > nums[j]) {
                    max = Math.max(max, dp[j]);
                }
                dp[i] = max + 1;
            }
            answer = Math.max(answer, dp[i]);
        }
        return answer;
    }
}