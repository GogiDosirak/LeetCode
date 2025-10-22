class Solution {
    public int lengthOfLIS(int[] nums) {
        // subsequence - 순서 변환없이 만들 수 있는 부분집합
        // 가장 긴 증가하는 subsequence의 길이를 구하는 문제
        // 1 <= nums.length <= 10^3 * 2.5
        // 완탐으로 풀면 모든 부분집합을 봐야하기 때문에 해당 원소를 포함할지 말지의 경우의 수 O(2^N) -> 완탐 불가능
        // 이 문제에선 O(nlogn)으로 풀어야함
        // 순서 변환도 못하므로 정렬 불가능

        // '현재 인덱스를 선택하는가?'가 다음 선택에 영향을 미침 -> dp
        // dp[i]는 현재 인덱스에서 만들 수 있는 최대 길이
        // 그 전 인덱스를 쭉 스캔하고 현재 숫자보다 작은 숫자 중 최대값 + 1
        // O(N^2)
        int answer = 1;
        int[] dp = new int[nums.length];
        dp[0] = 1;

        for(int i = 1; i < nums.length; i++) {
            int max = Integer.MIN_VALUE;
            for(int j = i-1; j >= 0 ; j--) {
                if(nums[i] > nums[j]) {
                    max = Math.max(max, dp[j]);
                }
            }
            dp[i] = max == Integer.MIN_VALUE ? 1 : max + 1;
            answer = Math.max(answer, dp[i]);
        }

        return answer;
    }
}