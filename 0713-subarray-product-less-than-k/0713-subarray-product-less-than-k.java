class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int answer = 0;

        for(int lt = 0; lt < nums.length; lt++) {
           int curr = nums[lt];
           if(curr < k) {
            answer++;
           } else {
            continue;
           }

           int rt = lt + 1;

           while(curr < k && rt < nums.length) {
            curr *= nums[rt];
            if(curr < k) {
              rt++;
              answer++;
            }
           }
        }
        return answer;  
    }
}