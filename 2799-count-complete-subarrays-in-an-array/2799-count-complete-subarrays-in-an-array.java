class Solution {
    public int countCompleteSubarrays(int[] nums) {
        int n = nums.length;
        Set<Integer> set = new HashSet<>();
        int answer = 0;

        for(int i = 0; i < n; i++) {
            set.add(nums[i]);
        }

        for(int lt = 0; lt < n; lt++) {
            Set<Integer> target = new HashSet<>();
            for(int rt = lt; rt < n; rt++) {
                target.add(nums[rt]);
                if(set.size() == target.size()) {
                    answer += n - rt;
                    break;
                }
            }
        }
        return answer;
    }
}