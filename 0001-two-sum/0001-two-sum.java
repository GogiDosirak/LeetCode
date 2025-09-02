class Solution {
    public int[] twoSum(int[] nums, int target) {
        // 완탐으로 풀어보기
        int n = nums.length;
        int[] answer = new int[2];
        for(int i = 0; i < n; i++) {
            for(int j = i+1; j < n; j++ ) {
                int sum = nums[i] + nums[j];
                if(sum == target) {
                    answer[0] = i;
                    answer[1] = j;
                    break;
                }
            }
        }
        return answer;
    }
}