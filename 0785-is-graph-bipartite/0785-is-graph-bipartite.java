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

        // 이분 그래프 - 정점을 두 개의 집합 A와 B로 나눌 수 있는 그래프
        // 같은 집합 끼리는 절대 간선이 없어야함
        // 집합 A = {0, 2}, 집합 B = {1, 3} - 모든 간선은 A <-> B로 연결 가능

        // 시작 노드를 A 집합에 넣으면, 인접 노드는 B집합, -> 또 인접 노드는 A 집합..  이 규칙을 깨게끔 집합이 되어있다면 false
        // 아니라면 true 반환
        // 1은 집합 A, -1은 집합 B
        check = new int[graph.length];

        // 연결되지 않은 경우도 확인.
        for(int i = 0; i < graph.length; i++) {
            if(check[i] == 0) {
                if(!DFS(list, i, 1)) return false;
            }
        }
        return true;
    }

    // 결과를 상위 재귀까지 return 해야함 -> boolean 반환
    public boolean DFS(List<List<Integer>> list, int node, int state) {
        check[node] = state;
        for(int n : list.get(node)) {
            if(check[n] == 0) {
                check[n] = -state;
                if(!DFS(list, n, -state)) return false;
            } else if(check[n] == state) {
                return false;
            }
        }
        return true;
    }
}