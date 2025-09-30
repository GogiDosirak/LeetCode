class Solution {
    public int[] twoSum(int[] nums, int target) {
        // 값, 인덱스
        Map<Integer,Integer> map = new HashMap<>();

        // 중복값 존재 가능 -> 값을 만족한다면 꺼내고, 아니라면 덮어씌우기
        for(int i = 0; i < nums.length; i++) {
            if(map.containsKey(target - nums[i])) {
                return new int[]{i,map.get(target-nums[i])};
            }

            // 아니라면 map에 넣기
            map.put(nums[i], i);
        }

        // 정답은 무조건 존재
        return null;
    }
}