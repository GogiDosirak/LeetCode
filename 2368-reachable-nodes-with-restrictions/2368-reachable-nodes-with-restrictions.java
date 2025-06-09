class Solution {
    int answer = 0; 
    public int reachableNodes(int n, int[][] edges, int[] restricted) {
        List<List<Integer>> graph = new ArrayList<>();
        boolean[] ch = new boolean[n];

        for(int x : restricted) {
            ch[x] = true;
        }

        for(int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for(int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        DFS(graph, ch, 0);

        return answer;
    }

    public void DFS(List<List<Integer>> graph, boolean[] ch, int n) {
        answer++;
        ch[n] = true;
        for(int x : graph.get(n)) {
            if(ch[x] != true) {
                DFS(graph, ch, x);
            }
        }
        return;
    }
}