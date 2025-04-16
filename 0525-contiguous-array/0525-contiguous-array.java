class Solution {
    public int findMaxLength(int[] nums) {
         Map<Integer, Integer> map = new HashMap<>();

        map.put(0, -1);
        int max = 0;
        int curr = 0;

        for(int i = 0; i < nums.length; i++) {
            curr += nums[i] == 0 ? -1 : 1;

            if(map.containsKey(curr)) {
                max = Math.max(max, i - map.get(curr));
            } else {
                map.put(curr, i);
            }
        }

        return max;

    }
}