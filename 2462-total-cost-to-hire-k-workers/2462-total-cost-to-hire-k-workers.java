class Solution {
    public long totalCost(int[] costs, int k, int candidates) {
        PriorityQueue<Integer> heap = new PriorityQueue<>((a,b) -> {
            if(costs[a] == costs[b]) {
                return a - b;
            }
            return costs[a] - costs[b];
        });

        int left = 0;
        int right = costs.length - 1;
        long answer = 0;

        for(int i = 0; i < candidates && left <= right; i++) {
            heap.add(left++);
        }

        for(int i = 0; i < candidates && left <= right; i++) {
            heap.add(right--);
        }

        for(int i = 0; i < k; i++) {
            int index = heap.poll();
            answer += costs[index];
            if(left <= right) {
                if(index < left) {
                    heap.add(left++);
                } else {
                    heap.add(right--);
                }
            }
        }

        return answer;
        
    }
}