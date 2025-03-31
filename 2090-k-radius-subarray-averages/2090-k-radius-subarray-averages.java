class Solution {
    public int[] getAverages(int[] nums, int k) {
        if(k == 0) {
            return nums;
        }
        int[] answer = new int[nums.length];

        for(int i = 0; i < nums.length; i++) {
            answer[i] = -1;
        }

        int sum = 0;
        for(int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if(i - (k * 2) < 0) {
                continue;
            }
            answer[i - k] = sum/(k*2+1);
            
            // 한 칸 이동 
            sum-=nums[i-(2*k)];
        }
        return answer;
    }
}