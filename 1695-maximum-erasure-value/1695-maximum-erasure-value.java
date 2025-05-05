class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int lt = 0, sum = 0, answer = 0;

        for (int rt = 0; rt < nums.length; rt++) {
            while (set.contains(nums[rt])) {
                set.remove(nums[lt]);
                sum -= nums[lt];
                lt++;
            }

            set.add(nums[rt]);
            sum += nums[rt];
            answer = Math.max(answer, sum);
        }

        return answer;
    }
}