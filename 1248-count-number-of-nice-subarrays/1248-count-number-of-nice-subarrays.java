class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        int answer = 0;
        int curr = 0;

        for(int n : nums) {
            curr += n % 2;
            answer += map.getOrDefault(curr - k, 0);
            map.put(curr, map.getOrDefault(curr, 0) + 1);
        }

        return answer;
    }
}