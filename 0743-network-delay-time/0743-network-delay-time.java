class Solution {
    int[] dis;
    List<List<Node>> graph;
    public int networkDelayTime(int[][] times, int n, int k) {
        // n번쨰 노드까지 있음
        // k번째 노드에서 시그널을 보냄 -> 모든 n노드에 도달하는데 걸리는 최소의 시간 구하기 (가중치 그래프 + 최소비용 -> 다익스트라?)
        // 다익스트라는 힙을 이용. INF로 갱신 후, 출발지점에서 갈 수 있는 지점들 갱신 -> 힙에 넣고 또 최소에서 갱신.. 큐가 빌 때 까지 반복
        // 자기 자신으로는 못감 + 어차피 최소경로 위주로 탐색하기 때문에 check 배열 필요 X

        graph = new ArrayList<>();
        for(int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for(int i = 0; i < times.length; i++) {
            graph.get(times[i][0]).add(new Node(times[i][1], times[i][2]));
        }
        
        dis = new int[n + 1];
        Arrays.fill(dis, Integer.MAX_VALUE); 
        dis[k] = 0;

        dijkstra(n, k);
        int answer = 0;

       // 정답은 dis의 최대값 - 그래야 끝까지 탐색한거니까
        for(int i = 1; i < dis.length; i++) {
             // 탐색이 불가능한 경우 (dis[i]이 Integer.MAX_VALUE인 경우)
            if(dis[i] == Integer.MAX_VALUE) return -1;
            answer = Math.max(answer, dis[i]);
        }

        return answer;
    }

    public void dijkstra(int n, int k) {
        PriorityQueue<Path> queue = new PriorityQueue<>((a,b) -> a.cost - b.cost);
        queue.add(new Path(k,0));

        while(!queue.isEmpty()) {
            Path curr = queue.poll();
            // dis 배열이 이미 더 낮은값으로 갱신된 경우엔 continue
            if(curr.cost > dis[curr.node]) continue;
            for(Node node : graph.get(curr.node)) {
                // 현재 까지의 최소값 + 거기까지 가는 비용
                int nextCost = node.cost + curr.cost;
                // 그 비용이 더 낮다면 갱신
                if(nextCost < dis[node.node]) {
                    dis[node.node] = nextCost;
                    // 그리고 Queue에 넣어주기
                    queue.add(new Path(node.node, nextCost));
                }
            }
        }
    }
}

class Node {
    int node;
    int cost;

    public Node(int node, int cost) {
        this.node = node;
        this.cost = cost;
    }
}

class Path {
    int node;
    int cost;

    public Path(int node, int cost) {
        this.node = node;
        this.cost = cost;
    }
}