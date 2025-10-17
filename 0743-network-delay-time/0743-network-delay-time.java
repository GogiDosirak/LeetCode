class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        // k에서 n으로 이동
        List<List<Node>> graph = new ArrayList<>();

        for(int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for(int i = 0; i < times.length; i++) {
            graph.get(times[i][0]).add(new Node(times[i][1], times[i][2]));
        }
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        dist[k] = 0;

        PriorityQueue<State> heap = new PriorityQueue<>((a,b) -> a.nowCost - b.nowCost);
        heap.add(new State(k, 0));

        while(!heap.isEmpty()) {
            State state = heap.poll();
            if(dist[state.nowNode] < state.nowCost) continue;

            for(Node node : graph.get(state.nowNode)) {
                int currCost = state.nowCost + node.cost;
                if(dist[node.node] > currCost) {
                    dist[node.node] = currCost;
                    heap.add(new State(node.node, currCost));
                }
            }
        }
        
        int answer = 0;

        for(int i = 1; i < dist.length; i++) {
            if(dist[i] == Integer.MAX_VALUE) return -1;
            answer = Math.max(answer, dist[i]);
        }

        return answer;
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

class State {
    int nowNode;
    int nowCost;

    public State(int nowNode, int nowCost) {
        this.nowNode = nowNode;
        this.nowCost = nowCost;
    }
}
