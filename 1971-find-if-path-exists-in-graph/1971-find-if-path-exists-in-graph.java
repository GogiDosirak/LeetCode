class Solution {
    boolean flag;
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        List<List<Integer>> graph = new ArrayList<>();
        boolean[] ch = new boolean[n]; 
        for(int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for(int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        DFS(graph, ch, source, destination, source);

        return flag;
    }

    public void DFS(List<List<Integer>> graph, boolean[] ch, int source, int destination, int n) {
        if(n == destination) {
            flag = true;
            return;
        }
        ch[n] = true;
        for(int x : graph.get(n)) {
            if(ch[x] != true) {
                DFS(graph, ch, source, destination, x);
            }
        }
        return;
    }
}