class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double curr = 0;
        for(int i = 0; i < k; i++) {
            curr += nums[i];
        }

        double answer = curr;
        for(int i = k; i < nums.length; i++) {
            curr += nums[i] - nums[i-k];
            answer = Math.max(answer, curr);
        }
        return answer/k;
    }
}