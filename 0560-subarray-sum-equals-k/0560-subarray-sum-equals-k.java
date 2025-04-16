class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1); // 빈 배열일 땐 합이 0
        int sum = 0;
        int count = 0;

        for(int n : nums) {
            sum += n;
            if(map.getOrDefault(sum-k, 0) > 0) {
                count += map.get(sum-k);
            } 
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        return count;      
}
}