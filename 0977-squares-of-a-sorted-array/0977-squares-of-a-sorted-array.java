class Solution {
    public int[] sortedSquares(int[] nums) {
        int[] arr = new int[nums.length];
        int lt = 0;
        int rt = nums.length-1;
        for(int i=nums.length-1; i >= 0; i--) {
            if(nums[lt] * nums[lt] < nums[rt] * nums[rt]) {
                arr[i] = nums[rt] * nums[rt];
                rt--;
            } else {
                arr[i] = nums[lt] * nums[lt];
                lt++;
            }

        }
        return arr;
    }
}