class Solution {
    public int maximumSum(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int answer = -1;

        for(int i = 0; i < nums.length; i++) {
            int sum = 0;
            int n = nums[i];
            while(n > 0) {
                sum += n % 10;
                n /= 10;
            }

            if(map.containsKey(sum)) {
                answer = Math.max(answer, nums[i] + map.get(sum));
            }
            map.put(sum, Math.max(map.getOrDefault(sum, 0),nums[i] ));
        }

        return answer;



        
    }
}