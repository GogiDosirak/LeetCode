class Solution {
    int answer = 0;
    public int minReorder(int n, int[][] connections) {
        List<List<Integer>> nonDirection = new ArrayList<>();
        Set<Integer> seen = new HashSet<>();
        for(int i = 0; i < n; i++) {
            nonDirection.add(new ArrayList<>());
        }
        for(int i = 0; i < connections.length; i++) {
            nonDirection.get(connections[i][0]).add(connections[i][1]);
            nonDirection.get(connections[i][1]).add(connections[i][0]);
        }

        for(int i = 0; i < nonDirection.size(); i++) {
            if(!seen.contains(i)) {
                DFS(connections, nonDirection, seen, i);
            }
        }
        return answer;
    }

    public void DFS(int[][] connections, List<List<Integer>> nonDirection, Set<Integer> seen, int n) {
        seen.add(n);
        for(int t : nonDirection.get(n)) {
            if(!seen.contains(t)){
                boolean flag = false;
            for(int[] arr : connections) {
                if(arr[1] == t) {
                    flag = true;
                    break;
                }
            }
            if(flag == true) {
                answer++;
            }
            DFS(connections, nonDirection, seen, t);
            }
        }
        return;

    }
}