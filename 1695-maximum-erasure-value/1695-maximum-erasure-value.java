class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        int answer = 0;
        Map<Integer, Integer> map = new HashMap<>();
        int lt = 0;
        int sum = 0;
        
        for(int rt = 0; rt < nums.length; rt++) {
            sum += nums[rt];
            map.put(nums[rt], map.getOrDefault(nums[rt], 0) + 1);
            while(map.get(nums[rt]) > 1) {
                map.put(nums[lt], map.get(nums[lt]) - 1);
                sum -= nums[lt];
                lt++;
            }
            answer = Math.max(answer, sum);
        }

        return answer;
        
    }
}