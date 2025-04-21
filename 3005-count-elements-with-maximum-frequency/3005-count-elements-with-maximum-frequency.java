class Solution {
    public int maxFrequencyElements(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        int max = 0;
        int answer = 0;

        for(int n : nums) {
            map.put(n, map.getOrDefault(n,0) + 1);
        }

        for(int value : map.values()) {
            max = Math.max(value, max);
        }

        for(int value : map.values()) {
            if(value == max) {
                answer += max;
            }
        }

        return answer;  
    }
}