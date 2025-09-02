class Solution {
    List<List<Integer>> answer = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        List<Integer> list = new ArrayList<>();
        backtracking(n, k, 1, list);
        return answer;
    }

    public void backtracking(int n, int k, int current, List<Integer> list) {
        if(list.size() == k) {
            answer.add(new ArrayList<>(list));
            return;
        }

        for(int i = current; i <= n; i++) {
            list.add(i);
            backtracking(n, k, i + 1, list);
            list.remove(Integer.valueOf(i));
        }
    }
}
