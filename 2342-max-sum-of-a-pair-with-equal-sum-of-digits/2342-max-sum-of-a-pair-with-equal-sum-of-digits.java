class Solution {
    public int maximumSum(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int answer = -1;

        for(int n : nums) { // 인덱스가 필요한것이 아님
            int sum = 0;
            int temp = n;
            while(temp > 0) {
                sum += temp % 10;
                temp /= 10;
            }

            if(map.containsKey(sum)) {
                answer = Math.max(answer, n + map.get(sum));
            }
            map.put(sum, Math.max(map.getOrDefault(sum,0), n));
        }

        return answer;

        
    }
}