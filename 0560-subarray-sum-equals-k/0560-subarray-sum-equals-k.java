class Solution {
    public int subarraySum(int[] nums, int k) {
       Map<Integer, Integer> map = new HashMap<>();
       int sum = 0;
       int answer = 0;
       map.put(0,1);

       for(int i = 0; i < nums.length; i++) {
        sum += nums[i];
        if(map.getOrDefault(sum - k, 0) > 0) {
            answer += map.get(sum - k);
        }
        map.put(sum, map.getOrDefault(sum, 0) + 1);
       }

       return answer;
}
}