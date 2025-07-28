class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, List<Integer>> map = new HashMap<>(); //값, 인덱스
        int[] answer = new int[2];

        for(int i = 0; i < nums.length; i++) {
            map.put(nums[i], new ArrayList<Integer>());
        }

        for(int i = 0; i < nums.length; i++) {
            map.get(nums[i]).add(i);
        }

        for(int key : map.keySet()) {
            int k = target - key;
            if(map.containsKey(k)) {
                if(map.get(k).size() >= 2) {
                    answer[0] = map.get(k).get(0);
                    answer[1] = map.get(k).get(1);
                } else {
                    answer[0] = map.get(key).get(0);
                    answer[1] = map.get(k).get(0);
                }
            }
        }

        return answer;
        
    }
}