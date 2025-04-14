class Solution {
    public int missingNumber(int[] nums) {
        int expectedSum = 0;
        int actualSum = 0;

        for(int i = 1; i <= nums.length; i++) {
            expectedSum += i;
        }

        for(int i = 0; i < nums.length; i++) {
            actualSum += nums[i];
        }
        
        return expectedSum - actualSum;
    }
}