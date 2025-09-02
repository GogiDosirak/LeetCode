class Solution {
    List<List<Integer>> answer = new ArrayList<>();
    boolean[] visited;
    public List<List<Integer>> permute(int[] nums) {
        int n = nums.length;
        visited = new boolean[n];
        List<Integer> list = new ArrayList<>();
        backtracking(nums, list);
        return answer;
    }

    public void backtracking(int[] nums, List<Integer> list) {
        if(list.size() == nums.length) {
            answer.add(new ArrayList<>(list));
            return;
        }

        for(int i = 0; i < nums.length; i++) {
            if(!visited[i]) {
                visited[i] = true;
                list.add(nums[i]);
                backtracking(nums, list);
                list.remove(Integer.valueOf(nums[i]));
                visited[i] = false;
            }
        }
    }
}