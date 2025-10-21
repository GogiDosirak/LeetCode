class Solution {
    public int rob(int[] nums) {
        // 하루 안에 가장 많은 돈을 털 수 있는 방향
        // 인접한 집을 털면 안됨. - 전의 선택이 다음에 영향을 미침 
        // 완전탐색으로 여기 털고... 여기 털고.. 하면서 최선의 경우의 수를 찾을 수도 있겠지만
        // 결국엔 n번집을 털었을 경우의 최대 돈은 정해져있음 -> n+2번 집은 그 최대 + n+2 번집을 털었을 때의 돈
        // 근데 [4,2,3,10]인 경우에는 4,3 보다 2,10 보다 4,10이 훨씬 크잖아 -> 저걸론 안될듯?
        // dp로 푸는게 훨씬 편하다.
        // 현재 집을 털었을 경우와 털지 않았을 경우 중 최대값이 그 집을 고려할 때의 최대값

        int[] dp = new int[nums.length];

        if(nums.length == 1) return nums[0];

        dp[0] = nums[0];
        dp[1] = Math.max(dp[0], nums[1]);

        for(int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i-2] + nums[i], dp[i-1]); // 털지 않았다면 dp[i-1]가 최대값, 털었다면 dp[i-2] + nums[i]가 최대값
        }

        int answer = 0;

        for(int n : dp) {
            answer = Math.max(answer, n);
        }

        return answer;
    }
}