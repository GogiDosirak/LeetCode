class Solution {
    public int countCompleteSubarrays(int[] nums) {
        int n = nums.length;
        Set<Integer> set = new HashSet<>();
        HashMap<Integer, Integer> count = new HashMap<>();
        int answer = 0;

        for(int i = 0; i < n; i++) {
            set.add(nums[i]);
        }

        int size = set.size();
        int lt = 0;

        for(int rt = 0; rt < n; rt++) {
           count.put(nums[rt], count.getOrDefault(nums[rt], 0) + 1);
           while(size == count.size()) {
            answer += n - rt; // 조건을 만족한다면 오른쪽은 전부 complete
            
            count.put(nums[lt], count.get(nums[lt]) - 1); // lt를 1만큼 이동
            if (count.get(nums[lt]) == 0) {
                count.remove(nums[lt]);
            }
            lt++;
           }
        }
        return answer;
    }
}