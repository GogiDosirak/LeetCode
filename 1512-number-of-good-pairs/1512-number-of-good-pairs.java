class Solution {
    public int numIdenticalPairs(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int answer = 0;

        for(int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        for(int value : map.values()) {
            if(value >=  2) {
                answer += dynamic(value);
            }
        }

        return answer;


    }

    private int dynamic(int n) {
        if(n == 2) return 1;
        return dynamic(n - 1) + n - 1;
    }
}