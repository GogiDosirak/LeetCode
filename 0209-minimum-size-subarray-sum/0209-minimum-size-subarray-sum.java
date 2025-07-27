    class Solution {
      public int minSubArrayLen(int target, int[] nums) {
        int answer = Integer.MAX_VALUE;
        int lt = 0;
        int sum = 0;
        for(int rt = 0; rt < nums.length; rt++) {
            sum += nums[rt];
            while(sum >= target) {
                sum -= nums[lt];
                lt++;
                if(sum >= target) {
                 answer = Math.min(answer, rt-lt+1);
            }
            }
        }

        if(answer == Integer.MAX_VALUE) return 0;
        
        return answer;
    }
 }
