class Solution {
    public int maxFrequencyElements(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        int max = 0;
        int answer = 0;

        for(int n : nums) {
            map.put(n, map.getOrDefault(n,0) + 1);
            max = Math.max(map.get(n), max);
        }

        for(int key : map.keySet()) {
            int value = map.get(key);
            if(value == max) {
                answer += max;
            }
        }

        return answer;  
    }
}