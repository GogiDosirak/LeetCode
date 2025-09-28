class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        // 가중치 그래프 + 최대 비용(가능성)의 길 찾기 -> 최대힙을 이용한 다익스트라
        // 모든 경로 dis 배열에 대해 -1로 초기화, 시작점은 0으로 초기화
        // 현재 노드에서 갈 수 있는 경로에 대한 비용을 구하고, dis 보다 크다면 갱신하고 heap에 넣기
        // heap에서 최대 비용인 곳을 뽑아서 또 갱신.. 반복

        List<List<Edge>> graph = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        // 무방향 그래프 세팅
        for(int i = 0; i < edges.length; i++) {
            graph.get(edges[i][0]).add(new Edge(edges[i][1], succProb[i]));
            graph.get(edges[i][1]).add(new Edge(edges[i][0], succProb[i]));
        }

        double[] dist = new double[n];
        Arrays.fill(dist, -1);

        dist[start_node] = 0;
        
        BFS(n, graph, start_node, end_node, dist);
        
        return dist[end_node] == -1 ? -0 : dist[end_node];
    }

    public void BFS(int n, List<List<Edge>> graph, int start, int end, double[] dist) {
        // 최대힙
        PriorityQueue<State> heap = new PriorityQueue<>((a,b) -> Double.compare(b.probability, a.probability));
        heap.add(new State(start, 1));

        while(!heap.isEmpty()) {
            State now = heap.poll();
            // 이미 더 높은 값으로 갱신됐다면 스킵
            if(now.probability < dist[now.vertex]) continue;
            // 갈 수 있는 노드 탐색
            for(Edge edge : graph.get(now.vertex)) {
                double nextProb = now.probability * edge.weight;
                if(nextProb > dist[edge.to]) {
                    dist[edge.to] = nextProb;
                    heap.add(new State(edge.to, nextProb));
                }
            }
        }
    }
}

class State {
    int vertex;
    double probability;
    
    public State(int vertex, double probability) {
        this.vertex = vertex;
        this.probability = probability;
    }
}

class Edge {
    int to;
    double weight;

    public Edge(int to, double weight) {
        this.to = to;
        this.weight = weight;
    }
}