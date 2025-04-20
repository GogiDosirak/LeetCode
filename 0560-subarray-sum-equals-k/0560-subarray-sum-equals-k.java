class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        int answer = 0;

        map.put(0, 1);

        for(int n : nums) {
            sum += n;
            answer += map.getOrDefault(sum-k, 0);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        return answer;
}
}