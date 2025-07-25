class Solution {
    public int[] getAverages(int[] nums, int k) {
        int[] answer = new int[nums.length];

        int lt = 0;
        int rt = 2*k;
        int windowSize = rt - lt + 1;

        for(int i = 0; i < answer.length; i++) {
            answer[i] = -1;
        }

        if(nums.length < 2 * k + 1) {
            return answer;
        }

        if(k == 0) return nums;

        long sum = 0;
        for(int i = 0; i <= rt; i++) {
            sum += nums[i];
        }

        answer[k] = (int) (sum / windowSize);


        for(int i = rt + 1; i < nums.length; i++) {
            sum -= nums[lt];
            sum += nums[i];
            lt++;

            answer[i - k] = (int)(sum / windowSize); 
        }

        return answer;    
  }
}