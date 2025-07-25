class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int answer = 0;
        if(k <= 1) return 0;

        int lt = 0;
        int curr = 1;

        for(int rt = 0; rt < nums.length; rt++) {
            curr *= nums[rt];
            while(curr >= k) {
                curr /= nums[lt];
                lt++;
            }

            answer += rt - lt + 1;
        }

        return answer;  
    }
}