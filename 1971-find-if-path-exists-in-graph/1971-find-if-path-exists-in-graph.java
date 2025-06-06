class Solution {
    boolean flag;
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        List<List<Integer>> graph = new ArrayList<>();
        boolean[] ch = new boolean[n];
        for(int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        
        for(int[] edge : edges) {
            int t = edge[0];
            int v = edge[1];
            graph.get(t).add(v);
            graph.get(v).add(t);
        }

        DFS(graph, ch, source, destination);

        return flag;
    }

    public void DFS(List<List<Integer>> graph, boolean[] ch, int n, int destination) {
        if (n == destination) {
            flag = true;
            return;
        }

        ch[n] = true;
        for(int v : graph.get(n)) {
            if(ch[v] != true) {
                DFS(graph, ch, v, destination);
            }
        }
        return;
    }
}