class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        int lt = 0;
        int max = Integer.MIN_VALUE;

        Map<Integer, Integer> map = new HashMap<>();

        for(int rt = 0; rt < nums.length; rt++) {
            map.put(nums[rt], map.getOrDefault(nums[rt],0) + 1);
            while(map.get(nums[rt]) > k) {
                map.put(nums[lt], map.get(nums[lt]) - 1);
                lt++;
            }

            max = Math.max(max, rt - lt + 1);
        }

        return max;
    }
}