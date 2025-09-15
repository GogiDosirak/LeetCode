class Solution {
    int[] check;
    public boolean isBipartite(int[][] graph) {
        List<List<Integer>> list = new ArrayList<>();

        for(int i = 0; i < graph.length; i++) {
            list.add(new ArrayList<>());
            for(int j = 0; j < graph[i].length; j++) {
                list.get(i).add(graph[i][j]);
            }
        }

        check = new int[graph.length];

        return BFS(list);
    }

    
    public boolean BFS(List<List<Integer>> list) {
        // 모든 노드에서 시작해야 연결되지 않은 곳도 탐색 가능
        // 대신 check 배열로 중복 탐색은 하지 않을 것
        for(int i = 0; i < list.size(); i++) {
            if(check[i] == 0) {
                Queue<Integer> queue = new LinkedList<>();
                queue.add(i);
                check[i] = 1;

                while(!queue.isEmpty()) {
                    int node = queue.poll();
                    for(int n : list.get(node)) {
                        if(check[n] == 0) {
                            queue.add(n);
                            check[n] = -check[node];
                        } else if(check[n] == check[node]) {
                            return false;
                        } 
                    }
                }
            }
        }
        // false로 return 되지 않았다면 전부 만족하는 것이므로 true 반환
        return true;
    }
}