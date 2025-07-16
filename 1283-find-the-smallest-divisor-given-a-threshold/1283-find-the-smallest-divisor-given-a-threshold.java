class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int n = nums.length;
        int lt = 1;
        int rt = Integer.MIN_VALUE;
        int answer = Integer.MAX_VALUE;
        for(int num : nums) {
            rt = Math.max(rt, num);
        }
        int mid = (lt + rt) / 2;

        while(lt <= rt) {
            int sum = 0;
            for(int i = 0; i < n; i++) {
                int temp = nums[i] / mid;
                if(nums[i] % mid == 0) {
                    sum += temp;
                } else {
                    sum += temp + 1;
                }
            }
            if(sum > threshold) {
                lt = mid + 1;
                mid = (lt + rt) / 2;
            } else {
                answer = Math.min(answer, mid);
                rt = mid - 1;
                mid = (lt + rt) / 2;
            }
        }
        return answer;  
    }
}