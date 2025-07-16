class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        Arrays.sort(nums);

        int n = nums.length;
        int lt = 1;
        int rt = nums[n-1];
        int mid = (lt + rt) / 2;
        int answer = Integer.MAX_VALUE;

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