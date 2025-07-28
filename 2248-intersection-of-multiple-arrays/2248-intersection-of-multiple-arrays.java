class Solution {
    public List<Integer> intersection(int[][] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < nums.length; i++) {
            for(int j = 0; j < nums[i].length; j++) {
                map.put(nums[i][j], map.getOrDefault(nums[i][j],0) + 1);
            }
        }

        List<Integer> arr = new ArrayList<>();

        for(int key : map.keySet()) {
            if(map.get(key) == nums.length) {
                arr.add(key);
            }
        }

        Collections.sort(arr);

        return arr;
    }
}