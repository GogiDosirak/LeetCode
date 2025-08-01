    class Solution {

      public int minSubArrayLen(int target, int[] nums) {
        int lt = 0;
        int sum = 0;
        int answer = nums.length;
        boolean flag = false;

        for (int rt = 0; rt < nums.length; rt++) {
          sum += nums[rt];
          while (sum >= target) { // sum이 크다면 모두 만족하는 subarray
            answer = Math.min(answer, rt-lt+1);
            sum -= nums[lt];
            lt++;
            flag = true;
          }
        }
        if (!flag) {
          return 0;
      }
       return answer;
    }
    }
