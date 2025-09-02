class Solution {
    int[] answer = new int[2];
    List<Integer> list = new ArrayList<>();
    public int[] twoSum(int[] nums, int target) {
        // 백트래킹
        backtracking(nums, 0, target);
        return answer;
    }

    public void backtracking(int[] nums, int start, int target) {
        if(list.size() == 2) {
            if(nums[list.get(0)] + nums[list.get(1)] == target) {
                answer[0] = list.get(0);
                answer[1] = list.get(1);
            }
            return; // 깊이 2 (list.size() == 2) 까지 내려오면 더 이상 탐색할 필요가 없다.
        }

        for(int i = start; i < nums.length; i++) {
            list.add(i);
            backtracking(nums, i + 1, target);
            list.remove(list.size() - 1);
        }
    }
}