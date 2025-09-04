class Solution {
    List<List<Integer>> answer = new ArrayList<>();
    boolean[] visited;
    public String getPermutation(int n, int k) {
        visited = new boolean[n+1];
        List<Integer> list = new ArrayList<>();
        backtracking(n, k, list);
        String s = "";
        for(int i = 0; i < answer.get(k - 1).size(); i++) {
            s += String.valueOf(answer.get(k - 1).get(i));
        }
        return s;
    }

    public void backtracking(int n, int k, List<Integer> list) {
        if(list.size() == n) {
            answer.add(new ArrayList<>(list));
            return;
        }

        for(int i = 1; i <= n; i++) {
            if(visited[i] == false) {
                visited[i] = true;
                list.add(i);
                backtracking(n, k, list);
                list.remove(list.size() - 1);
                visited[i] = false;
            }
        }
    }
}