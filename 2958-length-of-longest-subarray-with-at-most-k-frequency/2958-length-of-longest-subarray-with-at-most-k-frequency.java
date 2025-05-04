class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
       int answer = 0;
       Map<Integer, Integer> map = new HashMap<>();
       int lt = 0;

       for(int rt = 0; rt < nums.length; rt++) {
            map.put(nums[rt], map.getOrDefault(nums[rt],0) + 1);
            while(map.get(nums[rt]) > k) {
                map.put(nums[lt], map.get(nums[lt]) - 1);
                lt++;
            }
            answer = Math.max(answer, rt - lt + 1);
       }

       return answer;
       
    }
}