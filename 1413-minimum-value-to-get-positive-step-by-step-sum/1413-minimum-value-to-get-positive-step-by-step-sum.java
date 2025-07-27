class Solution {
    public int minStartValue(int[] nums) {
        int[] prefix = new int[nums.length];
        prefix[0] = nums[0];

        for(int i = 1; i < nums.length; i++) {
            prefix[i] = prefix[i-1] + nums[i];
        }

        int answer = Integer.MAX_VALUE;
        for(int n : prefix) {
            answer = Math.min(n, answer);
        }

        if(answer >= 1) return 1;

        return 1 - answer; 
    }
}