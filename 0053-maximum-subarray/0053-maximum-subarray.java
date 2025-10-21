class Solution {
    public int maxSubArray(int[] nums) {
        // 가장 큰 sum을 가진 연속된 subarray를 구하는 문제
        // -10^4 <= nums[i] <= 10^4 기 때문에, 투포인터로 풀면 -냐 +냐에 따라 조금 힘들어질듯?
        // dp 배열을 만들고, 현재 인덱스에서 새로 시작을 하는게 더 큰지 subarray에 포함되는게 더 큰지 비교하여 최대값으로 갱신
        // -> 갱신된 값이 현재 인덱스로 만들 수 있는 최대값 
        // -> 이렇게 갱신한 뒤 최대값을 꺼내면 됨

        int[] dp = new int[nums.length];
        int answer = nums[0];
        dp[0] = nums[0];

        for(int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i-1] + nums[i], nums[i]);
            answer = Math.max(answer, dp[i]);
        }

        return answer;
    }
}