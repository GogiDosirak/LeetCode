class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double answer = 0;
        int sum = 0;
        for(int i = 0; i < k; i++) {
            sum += nums[i];
        }
        answer = (double)sum / k;
        
        int lt = 0;
        for(int i = k; i < nums.length; i++) {
            sum += nums[i];
            sum -= nums[lt];
            lt++;

            answer = Math.max(answer, (double)sum/k);
        }

        return answer;
    }
}