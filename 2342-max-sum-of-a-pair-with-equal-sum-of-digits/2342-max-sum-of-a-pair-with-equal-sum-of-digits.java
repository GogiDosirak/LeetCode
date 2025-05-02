class Solution {
    public int maximumSum(int[] nums) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        int answer = Integer.MIN_VALUE;

        for(int i = 0; i < nums.length; i++) {
            int sum = 0;
            String s = String.valueOf(nums[i]);
            for(char c : s.toCharArray()) {
                sum += c - '0';
            }

            if(!map.containsKey(sum)) {
                map.put(sum, new ArrayList<>());
            }
            map.get(sum).add(nums[i]);
        }

        for(List<Integer> list: map.values()) {
            if(list.size() >= 2) {
                for(int i = 0; i < list.size(); i++) {
                    for(int j = i+1; j < list.size(); j++) {
                        answer = Math.max(answer, list.get(i) + list.get(j));
                    }
                }
            }
        }
        if(answer == Integer.MIN_VALUE) return -1;
        return answer;

        
    }
}